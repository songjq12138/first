package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * ���ù���springmvc��������
 * @author Administrator
 *
 */
@Configuration
@ComponentScan("com.itheima.controller")
@EnableWebMvc
public class SpringMvcConfig {

	
	/**
	 * ��ͼ������
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		
		InternalResourceViewResolver view=new InternalResourceViewResolver();
		view.setPrefix("/pages/");
		view.setSuffix(".jsp");
		return view;
	}
	

}
