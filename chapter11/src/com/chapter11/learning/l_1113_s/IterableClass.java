package com.chapter11.learning.l_1113_s;

import java.util.Iterator;

/**
 * 
 * �ܹ�����foreach�ı�������ʵ����Iterable�Ľӿ�
 * Iterable<T>�ӿ�ֻ��һ����Ҫʵ�ֵķ��� iterator<T>������Iterator<T> ������
 * ������Iterator<T> ��2����Ҫʵ�ֵķ���hasNext()��next()
 * @author Administrator
 *
 */
public class IterableClass implements Iterable<String>{

	protected String[] words=("And that us how we know the earth to be banana-shaped").split(" ");
	
	
	public static void main(String[]args){
		for(String s:new IterableClass()){
			System.out.println(s+" ");
		}
	}


	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index=0;
			@Override
			public boolean hasNext() {
				return index<words.length;
			}

			@Override
			public String next() {
				return words[index++];
			}
			
		};
	}
	

}
