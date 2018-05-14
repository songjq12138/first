package com.itheima.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.UserDao;
import com.itheima.domain.SysRole;
import com.itheima.domain.SysUser;
import com.itheima.service.userService;

@Service
@Transactional
public class userServiceImpl implements userService {

	/**
	 * 注入加盐加密的方法
	 */
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserDao userdao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = userdao.findByName(username);
		if(user!=null) {
			List<SimpleGrantedAuthority> list=new ArrayList<>();
			List<SysRole> roles = user.getRoles();
			for (SysRole sysRole : roles) {
				
				list.add(new SimpleGrantedAuthority("ROLE_"+sysRole.getRoleName()));
			}
			User users=new User(user.getUsername(),user.getPassword(),
						user.getStatus()==1?true:false,true,true,true, list);
			return users;
		}
		return null;
	}

	@Override
	public List<SysUser> findAll() {
		
		return userdao.findAll();
	}

	@Override
	public void sava(SysUser sysuser) {
		sysuser.setPassword(encoder.encode(sysuser.getPassword()));
		userdao.sava(sysuser);
	}

	@Override
	public SysUser findById(String id) {
		// TODO Auto-generated method stub
		return userdao.findById(id);
	}
	
	

}
