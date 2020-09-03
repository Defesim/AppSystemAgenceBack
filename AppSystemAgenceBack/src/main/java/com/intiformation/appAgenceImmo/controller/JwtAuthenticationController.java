package com.intiformation.appAgenceImmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.appAgenceImmo.controller.JwtTokenUtil;
import com.intiformation.appAgenceImmo.controller.JwtUserDetailsService;
import com.intiformation.appAgenceImmo.modele.AgentImmobilier;
import com.intiformation.appAgenceImmo.controller.JwtRequest;
import com.intiformation.appAgenceImmo.controller.JwtResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/authenticate")
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		System.out.println(" AUTHORITIES : " + userDetails.getAuthorities() );
		final String token = jwtTokenUtil.generateToken(userDetails);
		// add authority in response
		final SimpleGrantedAuthority authority = userDetails.getAuthorities().iterator().hasNext() ? 
				(SimpleGrantedAuthority) userDetails.getAuthorities().iterator().next() : null;
				
		return ResponseEntity.ok(new JwtResponse(token, authority ));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
	@RequestMapping(value="/registerAdmin", method = RequestMethod.POST)
	public AgentImmobilier register(@RequestBody AgentImmobilier cons) {
		System.out.println("REGISTER ADMIN :: " + cons);
		return userDetailsService.saveAdmin(cons);
	}
	
}