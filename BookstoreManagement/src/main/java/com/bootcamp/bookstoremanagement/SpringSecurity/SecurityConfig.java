package com.bootcamp.bookstoremanagement.SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
			http
		
			.csrf()  //It is used to Prevent non browser client to Use PostMapping. CSRF is a Cross-Site Request Forgery attack
			.disable()
			.authorizeRequests()
			.antMatchers("/user/**").hasRole("NORMAL")
			.antMatchers("/admin/**").hasRole("ADMIN") 
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth ) throws Exception{
		auth.inMemoryAuthentication().withUser("admin1").password(this.passwordEncoder().encode("admin")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user1").password(this.passwordEncoder().encode("user")).roles("NORMAL");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(10);  
	}

}
