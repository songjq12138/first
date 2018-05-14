package com.itheima.constant;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * 用以测试hashmap支持空字符串还是hashtable支持
 * @author Administrator
 *
 */
public class hashmap {

	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		map.put(null, null);
		map.put("", "");
		//结论:hashmap和hashtable都支持空字符串 
		//hashmapkey和value都支持null值
		//hashtable的key和value都不支持null值
		/*Map<String,String> map=new Hashtable<>();
		map.put("", "");
		map.put("", "");*/
	}
}
