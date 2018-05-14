package com.itheima.domain;

import java.util.List;

public class SysRole {

	private String id;
	private String roleName;
	private String roleDesc;
	private List<SysPermission> permissions;
	private List<SysUser> users;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public List<SysPermission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}
	public List<SysUser> getUsers() {
		return users;
	}
	public void setUsers(List<SysUser> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "SysRole [id=" + id + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", permissions="
				+ permissions + ", users=" + users + "]";
	}
	
	
}
