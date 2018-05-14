package com.itheima.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SysConfig {

	private String id;
	private Date visitTime;
	private String username;
	private String ip;
	private String url;
	private Long executionTime;
	private String method;
	
	public String getVisitTimeStr() {
		return visitTime!=null?new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(visitTime):"没有参数";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	

}
