package com.itheima.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itheima.domain.product;


/**
 * ��Ʒ��dao��
 * @author Administrator
 *
 */
public interface IProductDao {

	//��ѯȫ����Ʒ��Ϣ
	@Select("select * from product")
	public List<product> findAll();

}
