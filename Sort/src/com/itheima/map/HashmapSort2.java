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
 * ��hashmap��������ʹ��linkedhashmap
 * @author Administrator
 *
 */
public class HashmapSort2 {
	
	public static void main(String[] args) {
		Map<Integer,User> map=new HashMap<>();
		
		User user=new User("����",18);
		User user1=new User("����",20);
		User user2=new User("����",19);
		
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
		//�Ȼ�ȡ�����
		Set<Entry<Integer,User>> entrySet = map.entrySet();
		//Ȼ��������ת��Ϊlist����  �ý�������
		List<Entry<Integer,User>> list=new ArrayList<Entry<Integer,User>>(entrySet);
		//ʹ��java�Ĺ�����collections��������
		Collections.sort(list, new Comparator<Entry<Integer,User>>() {

			@Override
			public int compare(Entry<Integer,User> o1, Entry<Integer,User> o2) {
				
				return o1.getValue().getAge()-o2.getValue().getAge();
			}
			
		});
		//��list�������Ľ�����Ƹ�linkedhashmap
		for (Entry<Integer, User> entry : list) {
			linkedmap.put(entry.getKey(), entry.getValue());
		}
		return linkedmap;
	}

}
