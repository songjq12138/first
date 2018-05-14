package com.itheima.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itheima.domain.product;


/**
 * 商品的dao层
 * @author Administrator
 *
 */
public interface IProductDao {

	//查询全部商品信息
	@Select("select * from product")
	public List<product> findAll();

}
