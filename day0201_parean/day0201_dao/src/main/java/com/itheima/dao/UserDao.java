package com.itheima.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.itheima.domain.SysUser;
import com.itheima.domain.UserDomain;

public interface UserDao {

	@Select("select * from sys_user where username=#{username}")
	@Results({
		@Result(property="roles",column="id",javaType=List.class,
				many=@Many(select="com.itheima.dao.RoleDao.findById",fetchType=FetchType.LAZY))
	})
	SysUser findByName(String username);

	@Select("select * from sys_user")
	public List<SysUser> findAll();

	@Insert("insert into sys_user(id,username,email,password,phoneNum,status) "
			+ "values(sq_user.nextval,#{username},#{email},#{password},#{phoneNum},#{status})")
	void sava(SysUser sysuser);
	
	
	@Select("select * from sys_user where id=#{id}")
	@Results({
		@Result(property="roles",column="id",javaType=List.class,
				many=@Many(select="com.itheima.dao.RoleDao.findById",fetchType=FetchType.LAZY))
	})
	SysUser findById(String id);
}
