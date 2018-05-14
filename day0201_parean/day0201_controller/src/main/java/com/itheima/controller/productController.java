package com.itheima.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.product;
import com.itheima.service.IProductService;

/**
 * 创建商品的web层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/product")
public class productController {
	
	//给service层赋值
	@Autowired
	private IProductService productservice;
	
	//查询全部使用src250注解
//	@RolesAllowed("PRODUCT")
	//使用security注解形式
//	@Secured("PRODUCT")
	//使用spring表达式形式
	@PreAuthorize("hasAuthority('ROLE_PRODUCT')")
	@RequestMapping("/findAll")
	public String findAll(Model model,
			@RequestParam(required=true,defaultValue="1") Integer page,
			@RequestParam(required=true,defaultValue="2") Integer rows) {
		List<product> list=productservice.findAll(page,rows);
		PageInfo<product> info = new PageInfo<>(list);
		model.addAttribute("info", info);
		return "product-list";
	}
}
