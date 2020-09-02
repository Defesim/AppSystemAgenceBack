package com.intiformation.appAgenceImmo.authentification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.service.IAgentImmobilierService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private IAgentImmobilierService agentService;
	
	@Autowired
	private PasswordEncoder crypt;
	
	/**
	 * recherche le conseiller par son login, ici e-mail, au moment de se valider la connection
	 * @param pEmail : le nom utilisé pour se connecter
	 */
	@Override
	public UserDetails loadUserByUsername(String pEmail) throws UsernameNotFoundException {
		AgentImmobilier agent = agentService.findByMail(pEmail);
		
		// cas où un agent correspond à la recherche
		if (agent != null) {
			
			// ajoute l'autorité AGENT pour avoir accès aux fonctions correspondantes
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
			List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
			updatedAuthorities.add(authority);
			return new User(agent.getEmail(), agent.getMotDePasse(), updatedAuthorities);
		
		// cas où aucun agent ne correspond
		} else {
			throw new UsernameNotFoundException("Aucun agent ne correpsond - Veuillez réessayer.");
		}
		
	}//end loadUserByUsername()
	
	// crypte le mot de passe nouvellement créé pour l'agent immobilier
	// renvoie un agent immobilier en appelant ensuite la méthode ajouter() de l'agent
	public AgentImmobilier newMdpAgent(AgentImmobilier agent) {
		agent.setMotDePasse(crypt.encode(agent.getMotDePasse()));
		return agentService.ajouter(agent);
	}//end newMdpAgent()

}
