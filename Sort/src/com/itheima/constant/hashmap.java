package com.itheima.constant;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * ���Բ���hashmap֧�ֿ��ַ�������hashtable֧��
 * @author Administrator
 *
 */
public class hashmap {

	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		map.put(null, null);
		map.put("", "");
		//����:hashmap��hashtable��֧�ֿ��ַ��� 
		//hashmapkey��value��֧��nullֵ
		//hashtable��key��value����֧��nullֵ
		/*Map<String,String> map=new Hashtable<>();
		map.put("", "");
		map.put("", "");*/
	}
}
