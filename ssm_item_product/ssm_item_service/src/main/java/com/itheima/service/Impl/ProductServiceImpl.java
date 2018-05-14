package com.itheima.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.dao.ProductDao;
import com.itheima.domain.items;
import com.itheima.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productdao;

	@Override
	public List<items> findByAll() {
		// TODO Auto-generated method stub
		return productdao.findAll();
	}

	@Override
	public items findById(int id) {
		// TODO Auto-generated method stub
		return productdao.findById(id);
	}

	@Override
	public void save(items it) {
		// TODO Auto-generated method stub
		productdao.save(it);
	}
	
}
