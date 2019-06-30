package com.caddan.CTransport.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.caddan.CTransport.services.Imp.UserDetailsServiceImpl;

@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private ApplicationAuthenticationEntryPoint appAuthenticationEntryPoint;
	@Autowired
	private UserSuccessHandler userSuccessHandler;
	private SimpleUrlAuthenticationFailureHandler userFailureHandler = new SimpleUrlAuthenticationFailureHandler();

	public ApplicationSecurity() {
		super();
		SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requiresChannel().requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null).requiresSecure();
		http
		.csrf().disable().exceptionHandling().authenticationEntryPoint(appAuthenticationEntryPoint)
			.and().authorizeRequests().antMatchers("/app/**").hasRole("USER")
			.and()
			.formLogin()
			.successHandler(userSuccessHandler).failureHandler(userFailureHandler)
			.and().logout().logoutUrl("/logout");
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		/*auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("adminPass")).roles("ADMIN").and()
				.withUser("user").password(encoder().encode("userPass")).roles("USER");*/
		
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}}