package com.itheima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.domain.SysPermission;
import com.itheima.service.permissionService;

@Controller
@RequestMapping("/permission")
public class permissionController {

	@Autowired
	private permissionService permissionservice;
	
	@RequestMapping("/save")
	public String  sava(SysPermission syspermission) {
		permissionservice.sava(syspermission);
		return "redirect:findAll.do";
	}
	
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<SysPermission> list = permissionservice.findAll();
		model.addAttribute("list", list);
		return "permission-list";
	}
}
