package com.cts.user;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableRedisHttpSession
@Configuration
public class Config extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS).and().csrf().disable()
				.authorizeRequests().anyRequest().permitAll();
	}
}