package org.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
/*
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
*/
//注释,方便测试,暂不使用此配置,还需要注释掉pom中的spring-security
//@EnableWebSecurity
public class MultiHttpSecurityConfig {
	/*
	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user").password("password").roles("USER").build());
		manager.createUser(User.withUsername("admin").password("password").roles("USER", "ADMIN").build());
		return manager;
	}

	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/message").authorizeRequests().anyRequest().hasAnyRole("GUEST","USER").and().httpBasic();
			http.antMatcher("/refresh").authorizeRequests().anyRequest().hasRole("ADMIN").and().httpBasic();
			http.antMatcher("/home/**").authorizeRequests().anyRequest().hasRole("ADMIN").and().httpBasic();
		}
	}

	@Configuration
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().authenticated().and().formLogin();
		}
	}
	*/
}
