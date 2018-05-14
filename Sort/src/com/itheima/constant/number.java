package com.itheima.constant;

import java.util.ArrayList;
import java.util.List;

import com.itheima.arraylist.ArrayListSort;
import com.itheima.domain.User;

public class number {

	public static void main(String[] args) {
		ArrayListSort<User> list=new ArrayListSort<>();
		User user=new User("ÕÅÈı",14);
		list.add(user);
		list.add(user);
		list.add(user);
		list.add(user);
		list.add(user);
		list.add(user);
		List lit=new ArrayList();
		for (Object object : lit) {
			
		}
		System.out.println(list.size);
		list.remove(1);
		System.out.println(list.size);
		list.clear();
		System.out.println(list.size);
	}
}
