package com.itheima.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * ≈‰÷√»˝¥Û◊Èº˛
 * @author Administrator
 *
 */
public class webConfig  implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletcontext) throws ServletException {
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(SpringConfig.class,SpringMvcConfig.class,securityConfig.class);
		//≈‰÷√º‡Ã˝∆˜
		servletcontext.addListener(new ContextLoaderListener(context));
		//≈‰÷√servlet
		ServletRegistration.Dynamic servlet = servletcontext.addServlet("dispatcherServlet", new DispatcherServlet(context));
		servlet.addMapping("*.do");
		
		servletcontext.addListener(new RequestContextListener());
		
		//≈‰÷√π˝¬À∆˜
		FilterRegistration.Dynamic filter = servletcontext.addFilter("filter", new CharacterEncodingFilter("utf-8"));
		EnumSet<DispatcherType> enumset=EnumSet.noneOf(DispatcherType.class);
		enumset.add(DispatcherType.REQUEST);
		enumset.add(DispatcherType.FORWARD);
		filter.addMappingForUrlPatterns(enumset, false, "/*");
		
	}

}
