package com.itheima.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.itheima.service.userService;

@Configuration
@EnableWebSecurity
//三种方式的权限设置
@EnableGlobalMethodSecurity(jsr250Enabled=true,prePostEnabled=true,securedEnabled=true)
public class securityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
	@Autowired
	private userService userservice;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//配置security中的过滤器
		CharacterEncodingFilter filter=new CharacterEncodingFilter();
		http.addFilterBefore(filter, CsrfFilter.class);
		
		http.authorizeRequests()
		.antMatchers("/index.jsp", "/login.jsp", "/login.do", "/pages/aside.jsp", "/pages/header.jsp", "/css/**", "/img/**", "/plugins/**")
		.permitAll().anyRequest().authenticated().and().csrf().disable().formLogin().loginPage("/login.jsp")
		.loginProcessingUrl("/login.do").successForwardUrl("/pages/main.jsp")
		.failureForwardUrl("/failer.jsp")
		.and().logout().logoutUrl("/logout.do").logoutSuccessUrl("/login.jsp")
		.and().exceptionHandling().accessDeniedPage("/403.jsp");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userservice).passwordEncoder(getBCryptPasswordEncoder());
	}
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
