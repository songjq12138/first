package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.dao.ConfigDao;
import com.itheima.domain.SysConfig;
import com.itheima.service.ConfigService;
@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	private ConfigDao configdao;
	
	@Override
	public List<SysConfig> findAll() {
		// TODO Auto-generated method stub
		return configdao.findAll();
	}

	@Override
	public void save(SysConfig log) {
		configdao.save(log);
	}

}
