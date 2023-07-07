package com.phoenix.pma.Security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//	@Bean
//	protected UserDetailsService userDetailsService(DataSource dataSource) {
//		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("1651").roles("USER").build();
//		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("1651").roles("USER", "ADMIN")
//				.build();
//		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//		users.createUser(user);
//		users.createUser(admin);
//		return users;
//	}

	@Bean
	protected JdbcUserDetailsManager users(DataSource datasource) {
		JdbcUserDetailsManager jdbcUDM = new JdbcUserDetailsManager(datasource);
		return jdbcUDM;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder;
	}

	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//		.requestMatchers("/employees/new", "/projects/new", "/app-api/employees/**", "/app-api/projects/**").hasRole("ADMIN")
				.requestMatchers("/", "/**").permitAll().and().formLogin();

		http.csrf().disable();
		http.headers().frameOptions().disable();

		return http.build();

	}

}
