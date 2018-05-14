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
 * ��Ʒ��serviceʵ����
 * @author Administrator
 *
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	
	//����Ʒ��dao�㸳ֵ
	@Autowired
	private IProductDao productdao;
	
	//��ѯȫ����Ʒ
	@Override
	public List<product> findAll(int page,int rows) {
		PageHelper.startPage(page, rows);
		return productdao.findAll();
	}

}
