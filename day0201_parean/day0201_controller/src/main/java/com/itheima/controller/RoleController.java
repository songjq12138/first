package com.itheima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.domain.SysRole;
import com.itheima.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleservice;
	
	@RequestMapping("/save")
	public String sava(SysRole sysrole) {
		roleservice.sava(sysrole);
		return "redirect:findAll.do";
	}
	
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<SysRole> Rolelist = roleservice.findAll();
		model.addAttribute("RoleList", Rolelist);
		return "role-list";
	}
	
	@RequestMapping("/findByUid")
	public String findByUid(Model model,String id) {
		List<SysRole> list = roleservice.findByUid(id);
		model.addAttribute("userId", id);
		model.addAttribute("list", list);
		return "user-role-add";
	}
	
	@RequestMapping("savaRole")
	public String savaRole(String userId,String ids) {
//		System.out.println(userId+ids);
		roleservice.savaRole(userId,ids);
		return "redirect:/user/findById.do?id="+userId;
	}
	
}
