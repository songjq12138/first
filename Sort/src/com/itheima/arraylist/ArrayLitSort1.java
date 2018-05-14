package com.itheima.arraylist;

import java.util.Collection;

/**
 * 自定义list集合
 * @author Administrator
 *
 */
public class ArrayLitSort1 <E>{

	private Object[] array;
	
	private Integer size;
	
	private Integer number=12;
	
	//默认构造函数
	public ArrayLitSort1() {
		array=new Object[0];
		
		size=0;
	}
	//带长度的构造函数
	public ArrayLitSort1(int i) {
		if(i<0) {
			throw new IndexOutOfBoundsException("不正确的数字");
		}
		
		if(i==0) {
			array=new Object[0];
		}else {
			array=new Object[i];
		}
		size=i;
	}
	//带转换的构造函数
	public ArrayLitSort1(Collection<? extends E> collection) {
		if(collection==null) {
			throw new NullPointerException("不能为空");
		}
		array = collection.toArray();
		
		if(array.getClass()!=Object[].class) {
			array=new Object[collection.size()];
		}
		
		size=collection.size();
	}
	
	//添加
	public Boolean add(Collection<? extends E> collection) {
		
		if(collection==null) {
			throw new NullPointerException("不能为空");
		}
		
		Object[] obj=array;
		
		int i=size;
		
		if(i==obj.length) {
			obj=new Object[i+(i>number?number/2:number)];
			
			System.arraycopy(array, 0, obj, 0, obj.length);
		}
		
		array[i]=collection;
		
		size=obj.length;
		
		return true;
	}
	
	//删除
	public E remove(int index){
		if(index<0||index>=size) {
			throw new  IndexOutOfBoundsException("请传入正确的数值范围");
		}
		Object[] obj=array;
		
		E o=(E)obj[index];
		
		int i=size;
		
		System.arraycopy(obj, index, obj, index+1, --i-index);
		
		obj[i]=null;
		
		size=obj.length;
		
		array=obj;
		
		return o;
	}
}
