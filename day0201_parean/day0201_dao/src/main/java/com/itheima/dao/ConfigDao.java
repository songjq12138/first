package com.itheima.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itheima.domain.SysConfig;

public interface ConfigDao {

	@Select("select * from sysLog")
	List<SysConfig> findAll();

	@Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values("
			+ "#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
	void save(SysConfig log);

}
