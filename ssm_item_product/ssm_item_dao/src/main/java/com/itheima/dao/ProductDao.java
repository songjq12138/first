package com.itheima.dao;

import java.util.List;

import com.itheima.domain.items;

public interface ProductDao {
	

	public List<items> findAll();

	public items findById(int id);

	public void save(items it);
}
