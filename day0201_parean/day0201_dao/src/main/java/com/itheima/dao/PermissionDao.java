package com.itheima.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itheima.domain.SysPermission;

public interface PermissionDao {

	@Insert("insert into sys_permission values(seq_permission.nextval,"
			+ "#{permissionName},#{url},#{pid})")
	public void sava(SysPermission syspermission);
	
	@Select("select * from sys_permission")
	public List<SysPermission> findAll();
	
	@Select("select sp.* from sys_permission sp,role_permission rp where sp.id=rp.permissionid "
			+ " and rp.roleid=#{id}")
	public List<SysPermission> findById(String id);
}
