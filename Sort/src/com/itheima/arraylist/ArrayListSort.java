package com.itheima.arraylist;

import java.util.Arrays;
import java.util.Collection;

//�Զ���arraylist
public class ArrayListSort<E>{

	private Object[] array;
	
	private int MIN_CAPACITY_INCREMENT=12;
	
	public static  Integer size;

	//�Զ����޲εļ���   ��ʵarraylist�ײ�������
	public ArrayListSort() {
		array=new Object[0];
		size=0;
	}
	
	public ArrayListSort(int catacipy) throws IllegalAccessException {
		
		if(catacipy<0) {
			throw new IllegalAccessException("���ϲ���Ϊ����");
		}
		
		array=(catacipy ==0 ?new Object[0]:new Object[catacipy]);
		
		size=catacipy;
		
		System.out.println(size);
	}
	
	public <E> ArrayListSort(Collection<? extends E> collection) {
		if(collection==null) {
			throw new NullPointerException("����Ϊ��");
		}
		
		Object[] a =collection.toArray();
		//˵��Ϊ�˲���  ��������Ϊϰ��
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
			throw new NullPointerException("���ϲ���Ϊ��"); 
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
			throw new IndexOutOfBoundsException("���ڷ�Χ��");
		}
		
		E obj=(E)a[index];
		
		//��src��srcpos��λ�ÿ�ʼ����ֵ��dest��destposλ�ã�����Ϊlength,�����Ĳ���
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

