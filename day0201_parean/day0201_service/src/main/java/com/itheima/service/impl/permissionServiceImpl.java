package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.dao.PermissionDao;
import com.itheima.domain.SysPermission;
import com.itheima.service.permissionService;

@Service
public class permissionServiceImpl implements permissionService {

	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	public void sava(SysPermission syspermission) {
		permissionDao.sava(syspermission);
	}

	@Override
	public List<SysPermission> findAll() {
		// TODO Auto-generated method stub
		return permissionDao.findAll();
	}

}
