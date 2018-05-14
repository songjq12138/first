package com.itheima.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itheima.domain.SysRole;

public interface RoleService {

	public void sava(SysRole sysrole);
	
	public List<SysRole> findAll();
	
	public List<SysRole> findByUid(String uid);

	public void savaRole(String userId, String ids);
}
