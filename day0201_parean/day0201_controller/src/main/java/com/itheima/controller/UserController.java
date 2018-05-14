package com.itheima.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.domain.SysUser;
import com.itheima.service.userService;                       
                                                              
@Controller                                                   
@RequestMapping("/user")                                      
public class UserController {                                 
                                                              
	@Autowired                                                
	private userService userservice;                          
	         
	
	@RequestMapping("/findAll")                               
	public String findAll(Model model) {                      
		List<SysUser> list = userservice.findAll();           
		model.addAttribute("list", list);                     
		return "user-list";                                   
	}                                                         
	                                                          
	@RequestMapping("/save")                                  
	public String sava(SysUser sysuser) {  
		userservice.sava(sysuser);
		return "redirect:findAll.do";                                                      
	}                                                         
	
	
	@RequestMapping("/findById")                               
	public String findById(Model model,String id) {                      
		SysUser sysuser = userservice.findById(id);          
		model.addAttribute("user", sysuser);                     
		return "user-show";                                   
	}
	

	@RequestMapping("/findUsername")
	public void findUsername(HttpServletResponse response,HttpServletRequest request) throws IOException {
		String name = request.getUserPrincipal().getName();
//		request.getParameter(arg0)
//		System.out.println(name);
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			UserDetails user=(UserDetails)principal;
			String username = user.getUsername();
//			System.out.println(username);
		}
		
		if(name==null||name.equals("")) {
			name="Î´µÇÂ¼";
		}
		
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().print(name);
	}
	
}
