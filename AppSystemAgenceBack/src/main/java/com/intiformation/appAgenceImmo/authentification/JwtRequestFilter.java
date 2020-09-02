package com.intiformation.appAgenceImmo.authentification;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	private JwtTokenUtil tokenUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Autorisation");
		String email = null;
		String token = null;
		
		// jwt token est un "Bearer Token"
		// => on enlève "Bearer " pour ne garder que "Token"
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			
			token = requestTokenHeader.substring(7);
			
			try {
				email = tokenUtil.getUsernameFromToken(token);
			} catch (IllegalArgumentException e) {
				System.out.println("Token impossible à récupérer");
			} catch (ExpiredJwtException e) {
				System.out.println("Le Token a expiré");
			}//end try - catch
			
		// prévient si le token ne commence pas par "Bearer "
		} else {
			logger.warn("Le JWT Token ne commence pas par 'Bearer '.");
		}//end if - else
		
		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.jwt
		}
		
	}//end doFilterInternal()

}
