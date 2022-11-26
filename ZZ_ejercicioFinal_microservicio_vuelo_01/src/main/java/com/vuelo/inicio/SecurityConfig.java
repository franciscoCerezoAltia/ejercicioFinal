package com.vuelo.inicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class SecurityConfig {	
	
	private static final String[] AUTH_WHITELIST = {
	        "/authenticate",
	        "/swagger-resources/**",
	        "/swagger-ui/**",
	        "/v2/api-docs",
	        "/webjars/**"
	};
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
			.antMatchers(HttpMethod.GET,"/vuelo/**").authenticated()
			.antMatchers(HttpMethod.PUT,"/vuelo").hasRole("Admin")
			.antMatchers(HttpMethod.PUT,"/vuelo/**").hasAnyRole("Operador","Admin")
			.antMatchers(HttpMethod.DELETE,"/vuelo/**").hasAnyRole("Operador","Admin")
			.and()
			.httpBasic();
		
		return http.build();
    }
     
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
    	return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }
    
    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user1")
	          .password(bCryptPasswordEncoder.encode("user1"))
	          .roles("Invitado")
	          .build());
        manager.createUser(User.withUsername("user2")
	          .password(bCryptPasswordEncoder.encode("user2"))
	          .roles("Operador")
	          .build());
        manager.createUser(User.withUsername("user3")
                .password(bCryptPasswordEncoder.encode("user3"))
                .roles("Admin")
                .build());
        manager.createUser(User.withUsername("user4")
                .password(bCryptPasswordEncoder.encode("user4"))
                .roles("Admin","Operador")
                .build());
        return manager;
    }
    
    @Bean
    public AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailsService) 
      throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
          .userDetailsService(userDetailsService)
          .passwordEncoder(bCryptPasswordEncoder)
          .and()
          .build();
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder () {
    	return new BCryptPasswordEncoder();
    }
	
}
