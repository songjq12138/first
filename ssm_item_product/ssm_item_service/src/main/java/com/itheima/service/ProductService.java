package com.itheima.service;

import java.util.List;

import com.itheima.domain.items;

public interface ProductService {

	public List<items> findByAll();

	public items findById(int ids);

	public void save(items it);
}
