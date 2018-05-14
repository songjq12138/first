package com.itheima.arraylist;

import java.util.Arrays;
import java.util.Collection;

//自定义arraylist
public class ArrayListSort<E>{

	private Object[] array;
	
	private int MIN_CAPACITY_INCREMENT=12;
	
	public static  Integer size;

	//自定义无参的集合   其实arraylist底层是数组
	public ArrayListSort() {
		array=new Object[0];
		size=0;
	}
	
	public ArrayListSort(int catacipy) throws IllegalAccessException {
		
		if(catacipy<0) {
			throw new IllegalAccessException("集合不能为负数");
		}
		
		array=(catacipy ==0 ?new Object[0]:new Object[catacipy]);
		
		size=catacipy;
		
		System.out.println(size);
	}
	
	public <E> ArrayListSort(Collection<? extends E> collection) {
		if(collection==null) {
			throw new NullPointerException("集合为空");
		}
		
		Object[] a =collection.toArray();
		//说是为了并发  可能是因为习惯
		if(a.getClass()!=Object[].class) {
			Object[] obj=new Object[a.length];
			System.arraycopy(a, 0, obj, 0, a.length);
			a=obj;
		}
		
		array=a;
		
		size=a.length;
	}
	
	public <E> boolean add(E object) {
		
		if(object == null) {
			throw new NullPointerException("集合不能为空"); 
		}
		
		Object[] obj=array;
		
		int i=size;
		
		if(i==obj.length) {
			Object[] newarray=new Object[i+(i<MIN_CAPACITY_INCREMENT/2?MIN_CAPACITY_INCREMENT:i/2)];
		
			System.arraycopy(obj, 0, newarray, 0, i);
			
			array=obj=newarray;
		}
		array[i]=object;
		
		size=i+1;
		
		return true;
	}
	
	
	public E remove(int index) {
		
		Object[] a = array;
		int s = size;
		
		if(index<0 || index>=s) {
			throw new IndexOutOfBoundsException("不在范围内");
		}
		
		E obj=(E)a[index];
		
		//从src的srcpos的位置开始，赋值到dest的destpos位置，长度为length,其他的不变
		System.arraycopy(a, index+1, a, index, --s-index);
		
		a[s]=null;
		
		size=s;
		
		return obj;
	}
	
	public void clear() {
		if(size!=0) {
			Arrays.fill(array,0,size,null);
		}
		size=0;
	}
	
	
}

