package com.itheima.arraylist;

import java.util.HashMap;
import java.util.Map;

/**
 * 求数组中重复的个数
 * @author Administrator
 *
 */
public class ArrayCount {
	private static void countSameNumber1(int[] number){  
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();  
        for(int i =0;i < number.length;i++){  
            if(!hm.containsKey(number[i])){  
                hm.put(number[i],1); 
            }  
            else{  
            	Integer count = hm.get(number[i]);
                hm.put(number[i],(count+1));  
            }  
        }  
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){  
            System.out.println(entry.getKey() + "出现了" + entry.getValue() + "次");  
        }  
    }
	
	public static void main(String[] args) {
		int[] number=new int[] {1,1,2,3,5,95,1,64,2,1,6,3,1};
		countSameNumber1(number);
	}
}
