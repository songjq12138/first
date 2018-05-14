package com.itheima.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.itheima.domain.SysUser;

public interface userService extends UserDetailsService {

	public List<SysUser> findAll();

	public void sava(SysUser sysuser);
	
	public SysUser findById(String id);
}
