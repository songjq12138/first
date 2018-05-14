package com.itheima.domain;

import java.util.List;

public class SysPermission {

	private Integer id;
	private String permissionName;
	private String url;
	private String pid;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	private List<SysRole> roles;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "SysPermission [id=" + id + ", permissionName=" + permissionName + ", url=" + url + ", roles=" + roles
				+ "]";
	}
	
}
