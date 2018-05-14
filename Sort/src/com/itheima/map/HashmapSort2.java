package com.itheima.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.itheima.domain.User;

/**
 * 让hashmap变成有序的使用linkedhashmap
 * @author Administrator
 *
 */
public class HashmapSort2 {
	
	public static void main(String[] args) {
		Map<Integer,User> map=new HashMap<>();
		
		User user=new User("张三",18);
		User user1=new User("李四",20);
		User user2=new User("王五",19);
		
		map.put(1, user);
		map.put(2, user1);
		map.put(3, user2);
		
		LinkedHashMap<Integer, User> linkedmap=change(map);
		
		Set<Entry<Integer,User>> entrySet = linkedmap.entrySet();
		
		for (Entry<Integer, User> entry : entrySet) {
			System.out.println(entry.getKey()+entry.getValue().getAge());
			System.out.println(entry);
			System.out.println("------------------------------------");
		}
	}

	private static LinkedHashMap<Integer, User> change(Map<Integer, User> map) {
		LinkedHashMap<Integer, User> linkedmap=new LinkedHashMap<Integer, User>();
		//先获取结果集
		Set<Entry<Integer,User>> entrySet = map.entrySet();
		//然后将其结果集转换为list集合  好进行排序
		List<Entry<Integer,User>> list=new ArrayList<Entry<Integer,User>>(entrySet);
		//使用java的工具类collections进行排序
		Collections.sort(list, new Comparator<Entry<Integer,User>>() {

			@Override
			public int compare(Entry<Integer,User> o1, Entry<Integer,User> o2) {
				
				return o1.getValue().getAge()-o2.getValue().getAge();
			}
			
		});
		//将list中排序后的结果复制给linkedhashmap
		for (Entry<Integer, User> entry : list) {
			linkedmap.put(entry.getKey(), entry.getValue());
		}
		return linkedmap;
	}

}
