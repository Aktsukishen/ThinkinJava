package com.chapter11.learning.l_1101_s;

import java.util.ArrayList;

class Apple{
	private static long counter;
	private final long id=counter++;
	public long id(){
		return id;
	}
}

class Orange{}


public class ApplesAndOrangesWithoutGenerics {

	public static void main(String[] args) {
		ArrayList apples=new ArrayList();
		for(int i=0;i<3;i++){
			apples.add(new Apple());
		}
		apples.add(new Orange());
		for(int i=0;i<apples.size();i++){
			//û�����Ͳ���������apples�е����ж�����Object�����Ĭ�϶����Լ��롣����ȥ��ʱת���ڱ�����Ҳû�����ִ���
			((Apple)(apples.get(i))).id();
		}
	}

}
