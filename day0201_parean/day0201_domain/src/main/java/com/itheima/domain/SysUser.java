package com.itheima.domain;

import java.util.List;

public class SysUser {

	private Integer id;
	private String username;
	private String email;
	private String password;
	private String phoneNum;
	private int status;
	private List<SysRole> roles;
	
	public String getStatusStr() {
		return status==1?"¿ªÆô":"¹Ø±Õ";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public List<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", phoneNum=" + phoneNum + ", status=" + status + ", roles=" + roles + "]";
	}
	
}
