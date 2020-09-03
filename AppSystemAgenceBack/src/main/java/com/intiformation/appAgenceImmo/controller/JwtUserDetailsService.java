package com.intiformation.appAgenceImmo.controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.intiformation.appAgenceImmo.service.IAgentImmobilierService;
import com.intiformation.appAgenceImmo.service.IClientService;
import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.modele.Client;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IAgentImmobilierService agentImmobilierService;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	
	public UserDetails loadUserByUsername(Long username) throws UsernameNotFoundException {
		
		// can be a conseiller or a client
		AgentImmobilier cons = agentImmobilierService.trouverViaId(username);
		
		if ( cons != null ) {
			
			// add admin Authority
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
			List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
			updatedAuthorities.add(authority);
			return new User(String.valueOf(cons.getId_personne()), cons.getMotDePasse(), updatedAuthorities);
			
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
	}

	
	public AgentImmobilier saveAdmin(AgentImmobilier cons) {
		cons.setMotDePasse(bcryptEncoder.encode(cons.getMotDePasse()));
		return agentImmobilierService.ajouter(cons);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}