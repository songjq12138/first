package com.itheima.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.itheima.domain.items;
import com.itheima.service.ProductService;
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/findByAll")
	public String findByAll(Model model) {
		List<items> list = productService.findByAll();
		model.addAttribute("list", list);
		return "itemList";
	}
	
	@RequestMapping("/findById")
	public String findById(Model model,String id) {
		int ids=Integer.valueOf(id);
		items item=productService.findById(ids);
		model.addAttribute("item", item);
		return "editItem";
	}
	
	@RequestMapping("/save")
	public String Save(HttpServletRequest request,MultipartFile pictureFile,items item) throws Exception{
		//��ȡ�Ƿ����ļ��ϴ���
		boolean multipartContent = ServletFileUpload.isMultipartContent(request);
		if(!multipartContent) {
			throw new RuntimeException("�����ļ��ϴ���");
		}
		//��ȡ�ļ�·��
		String realPath = request.getSession().getServletContext().getRealPath("/update").trim();
		//Ϊ�˷�ֹ�ļ��ж���� ��ȡ�����ļ���
		String path=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).replace("-", "").toUpperCase().trim();
		//����Ŀ¼
		File file=new File(realPath,path);
		if(!file.exists()) {
			file.mkdirs();
		}
		//��ȡ�ļ���
		String filename = pictureFile.getOriginalFilename();
		//Ϊ�˷�ֹ�ļ��������ӵ���
		filename=(UUID.randomUUID().toString()+"_"+filename).trim();
		//д�ļ�
		pictureFile.transferTo(new File(file,filename));
		item.setPic(file+"\\"+filename);
		System.out.println(item.getPic());
//		item.setPic(path+"/"+filename);
		productService.save(item);
		return "redirect:findByAll";
	}
}
