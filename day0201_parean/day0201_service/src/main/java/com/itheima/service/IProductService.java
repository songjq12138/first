package com.itheima.service;

import java.util.List;

import com.itheima.domain.product;

/**
 * 创建一个商品的service层
 * @author Administrator
 *
 */
public interface IProductService {

	//查询全部
	List<product> findAll(int page,int rows);

	
}
