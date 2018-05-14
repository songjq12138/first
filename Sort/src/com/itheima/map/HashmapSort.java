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

public class HashmapSort {

	public static void main(String[] args) {
		Map<Integer,User> map=new HashMap<>();
		map.put(1, new User("张三",18));
		map.put(2, new User("李四",20));
		map.put(3, new User("王五",19));
		
		HashMap<Integer,User> hashmap=SortLinkHasnMap(map);
		System.out.println(hashmap);
	}

	private static HashMap<Integer,User> SortLinkHasnMap(Map<Integer, User> map) {
		Set<Entry<Integer,User>> entrySet = map.entrySet();
		List<Entry<Integer,User>> list=new ArrayList<Entry<Integer,User>>(entrySet);
		
		Collections.sort(list,new Comparator<Entry<Integer, User>>(){

			@Override
			public int compare(Entry<Integer, User> o1, Entry<Integer, User> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().getAge()-o2.getValue().getAge();
			}
			
		});
		
		LinkedHashMap<Integer,User> linkmap=new  LinkedHashMap<Integer,User>();
		for (Entry<Integer, User> entry : list) {
			linkmap.put(entry.getKey(), entry.getValue());
		}
		return linkmap;
	}

}
