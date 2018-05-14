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
 * ������Ʒ��web��
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/product")
public class productController {
	
	//��service�㸳ֵ
	@Autowired
	private IProductService productservice;
	
	//��ѯȫ��ʹ��src250ע��
//	@RolesAllowed("PRODUCT")
	//ʹ��securityע����ʽ
//	@Secured("PRODUCT")
	//ʹ��spring���ʽ��ʽ
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
