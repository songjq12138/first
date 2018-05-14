package com.itheima.service;

import java.util.List;

import com.itheima.domain.SysConfig;

public interface ConfigService {

	List<SysConfig> findAll();

	void save(SysConfig log);

}
