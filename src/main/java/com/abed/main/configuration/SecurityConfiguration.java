
package com.abed.main.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity

public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	DataSource datasource ; 
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.csrf().disable().authorizeRequests().antMatchers("/api/tickets/**").hasAnyRole("USER","ADMIN").and().formLogin();
		http.csrf().disable().authorizeRequests().antMatchers("/api/admin/**").hasAnyRole("ADMIN").and().formLogin();
		
		
	}
	
	// InMemort Authentication 
//	@Autowired
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception
//	
//	{
//		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("abed").password("abed92").roles("ROLE_USER","ROLE_ADMIN");
//		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("issa").password("issa91").roles("ROLE_USER");
//	}
//	
	
	
	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().dataSource(datasource)
		.passwordEncoder(passwordEncoder())
        .usersByUsernameQuery("SELECT username,password,1 FROM users where username=?")
        .authoritiesByUsernameQuery("SELECT username, authorities FROM user_roles where username=?");;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	

}
