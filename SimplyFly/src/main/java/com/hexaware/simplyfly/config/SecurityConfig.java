package com.hexaware.simplyfly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.authorizeHttpRequests(auth -> {

			auth.requestMatchers("/").permitAll();
			auth.anyRequest().authenticated();
		}).oauth2Login(Customizer.withDefaults()).formLogin(Customizer.withDefaults()).build();

	}

	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails user1 = User.withUsername("vikash").password("vikash123").roles("admin").build();

		return new InMemoryUserDetailsManager(user1);

	}

	@Bean
	public AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

		return authenticationProvider;
	}

}
