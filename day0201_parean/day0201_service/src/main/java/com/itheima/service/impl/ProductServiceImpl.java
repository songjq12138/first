package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IProductDao;
import com.itheima.domain.product;
import com.itheima.service.IProductService;
/**
 * 商品的service实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	
	//给商品的dao层赋值
	@Autowired
	private IProductDao productdao;
	
	//查询全部商品
	@Override
	public List<product> findAll(int page,int rows) {
		PageHelper.startPage(page, rows);
		return productdao.findAll();
	}

}
