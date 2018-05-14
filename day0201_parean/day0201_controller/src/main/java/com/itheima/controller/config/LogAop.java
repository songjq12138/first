package com.itheima.controller.config;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.domain.SysConfig;
import com.itheima.service.ConfigService;

@Component
@Aspect
public class LogAop {

	@Autowired
	private ConfigService configservice;
	
	@Autowired
	private HttpServletRequest request;
	private Date visitTime;
	private Class clazz;
	private Method method;
	
	@Before("execution(* com.itheima.controller.*.*(..))")
	public void doBefore(JoinPoint point) throws Exception {
		visitTime =new Date();
		
		//获取clazz对象
		clazz = point.getTarget().getClass();
		String methodName = point.getSignature().getName();
		Object[] args = point.getArgs();
		//获取方法
		if(args==null || args.length==0) {
			method=clazz.getMethod(methodName);
		}else {
			Class[] calarray=new Class[args.length];
				for (int i = 0; i < args.length; i++) {
					if(args[i] instanceof HttpServletResponse) {
						calarray[i] = HttpServletResponse.class;
					}else if(args[i] instanceof HttpServletRequest){
						calarray[i] = HttpServletRequest.class;
					}else if(args[i] instanceof Model){
						calarray[i] = Model.class;
					}else {
						calarray[i] = args[i].getClass();
					}
				}
				//方法中有参数
				method = clazz.getMethod(methodName, calarray);
			}
		}
	
	@After("execution(* com.itheima.controller.*.*(..))")
	public void doAfter() {
		SysConfig log=new SysConfig();
		
		RequestMapping anclazz=(RequestMapping)clazz.getAnnotation(RequestMapping.class);
		if(anclazz!=null) {
			RequestMapping anmethod=(RequestMapping)method.getAnnotation(RequestMapping.class);
			if(anmethod!=null) {
				//获取时长
				Long executionTime = new Date().getTime()-visitTime.getTime();
				//获取访问时长
				log.setExecutionTime(executionTime);
				log.setIp(request.getRemoteAddr());
				log.setMethod("类名"+clazz.getName()+"方法名"+method.getName());
				log.setUrl(anclazz.value()[0]+anmethod.value()[0]);
				log.setUsername(request.getUserPrincipal().getName());
				//获取访问日期
				log.setVisitTime(visitTime);
				configservice.save(log);
			}
		}
	}
}
