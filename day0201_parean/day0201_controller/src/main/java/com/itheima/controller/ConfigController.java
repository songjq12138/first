package com.itheima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.domain.SysConfig;
import com.itheima.service.ConfigService;

@Component
@RequestMapping("/config")
public class ConfigController {

	@Autowired
	private ConfigService configservice;
	
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<SysConfig> list=configservice.findAll();
		model.addAttribute("list", list);
		return "syslog-list";
	}
}
