package com.itheima.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.itheima.domain.SysRole;

public interface RoleDao {

	@Insert("insert into sys_role (roleName,roleDesc) values("
			+ "#{roleName},#{roleDesc})")
	public void sava(SysRole sysrole);
	
	@Select("select * from sys_role")
	public List<SysRole> findAll();
	
	@Select("select sr.* from sys_role sr,user_role ur where sr.id=ur.roleid and ur.userid=#{id}")
	@Results({
		@Result(property="permissions",column="id",javaType=List.class
				,many=@Many(select="com.itheima.dao.PermissionDao.findById"))
	})
	public List<SysRole> findById(String id);
	
	@Select("select * from sys_role sr where sr.id not in ("+ 
			"select sr.id "+
			"from sys_role sr,user_role ur "+
			"where sr.id=ur.roleid and ur.userid=#{uid})")
	public List<SysRole> findByUid(String uid);

	@Insert("insert into user_role values(#{uid},#{rid})")
	public void savaRole(@Param("uid")String userId, @Param("rid")String ids);
}
