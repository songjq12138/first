package com.itheima.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itheima.domain.SysPermission;

public interface permissionService {

	public void sava(SysPermission syspermission);
	
	public List<SysPermission> findAll();
}
