package com.itheima.arraylist;

import java.util.Collection;

/**
 * �Զ���list����
 * @author Administrator
 *
 */
public class ArrayLitSort1 <E>{

	private Object[] array;
	
	private Integer size;
	
	private Integer number=12;
	
	//Ĭ�Ϲ��캯��
	public ArrayLitSort1() {
		array=new Object[0];
		
		size=0;
	}
	//�����ȵĹ��캯��
	public ArrayLitSort1(int i) {
		if(i<0) {
			throw new IndexOutOfBoundsException("����ȷ������");
		}
		
		if(i==0) {
			array=new Object[0];
		}else {
			array=new Object[i];
		}
		size=i;
	}
	//��ת���Ĺ��캯��
	public ArrayLitSort1(Collection<? extends E> collection) {
		if(collection==null) {
			throw new NullPointerException("����Ϊ��");
		}
		array = collection.toArray();
		
		if(array.getClass()!=Object[].class) {
			array=new Object[collection.size()];
		}
		
		size=collection.size();
	}
	
	//���
	public Boolean add(Collection<? extends E> collection) {
		
		if(collection==null) {
			throw new NullPointerException("����Ϊ��");
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
	
	//ɾ��
	public E remove(int index){
		if(index<0||index>=size) {
			throw new  IndexOutOfBoundsException("�봫����ȷ����ֵ��Χ");
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
