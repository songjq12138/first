package com.itheima.service;

import java.util.List;

import com.itheima.domain.product;

/**
 * ����һ����Ʒ��service��
 * @author Administrator
 *
 */
public interface IProductService {

	//��ѯȫ��
	List<product> findAll(int page,int rows);

	
}
