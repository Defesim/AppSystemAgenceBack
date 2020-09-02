package com.intiformation.appAgenceImmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
// configure AuthenticationManager so that it knows from where to load
// user for matching credentials
// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		//==============================================================================
		//==============================================================================
			// COMMENTAIRE ANAIS : ligne commenté pour test
		//==============================================================================
		//==============================================================================
/*
		
// We don't need CSRF for this example
		httpSecurity.csrf().disable()
// dont authenticate this particular requests
				.authorizeRequests().antMatchers("/authenticate").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/registerAdmin").permitAll()
				
				// Authorize public data
				.antMatchers("/biensImmo/list").permitAll()
				.antMatchers("/biensImmo/listForPublic").permitAll()
				.antMatchers("/ficheInfoBien/list").permitAll()
				.antMatchers("/ficheInfoBien/listForPublic").permitAll()
				.antMatchers("/public/**").permitAll()
				
				// Authorize ANGULAR OPTIONS CALLS
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				
				// Admin inly
				.antMatchers("/contratAchat/**").hasRole("ADMIN")
				.antMatchers("/contratLocation/**").hasRole("ADMIN")
				
				// Client & Admin only
				.antMatchers("/adresses/**").hasAnyRole("ADMIN", "CLIENT")
				.antMatchers("/visites/**").hasAnyRole("ADMIN", "CLIENT")
				.antMatchers("/client/**").hasAnyRole("ADMIN", "CLIENT")
				.antMatchers("/acquereur/**").hasAnyRole("ADMIN", "CLIENT")
				.antMatchers("/ficheInfoBien/**").hasAnyRole("ADMIN", "CLIENT")
				.antMatchers("/proprietaire/**").hasAnyRole("ADMIN", "CLIENT")
				.antMatchers("/utilisateurs/**").hasAnyRole("ADMIN", "CLIENT")
				
				
// all other requests need to be authenticated
			
				.anyRequest().authenticated().and().
				
// make sure we use stateless session; session won't be used to
// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
*/	}

}