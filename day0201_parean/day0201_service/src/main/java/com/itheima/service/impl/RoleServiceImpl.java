package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.dao.RoleDao;
import com.itheima.domain.SysRole;
import com.itheima.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roledao;
	
	@Override
	public void sava(SysRole sysrole) {
		roledao.sava(sysrole);
	}

	@Override
	public List<SysRole> findAll() {
		// TODO Auto-generated method stub
		return roledao.findAll();
	}

	@Override
	public List<SysRole> findByUid(String uid) {
		// TODO Auto-generated method stub
		return roledao.findByUid(uid);
	}

	@Override
	public void savaRole(String userId, String ids) {
		roledao.savaRole(userId,ids);
	}

}
