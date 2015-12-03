package com.chapter05.learning.l_0502_s;

public class PrimitiveOverLoading {
	
	static void f1(float x){
		System.out.println("f1(float x)");
	}
	
	
	static void f1(long x){
		System.out.println("f1(long x)");
	}
	
	static void f1(X x){
		System.out.println("f1(X x)");
	}
	
	static void f1(Y y){
		System.out.println("f1(Y Y)");
	}
	
	public static void main(String[] args) {
		//�����������͵�������Ȼ�����ᣬǿ�����½�
		f1(2);
		f1((float) 2.0D);
		//�����������ǿ������������Ȼ���½�
		PrimitiveOverLoading pol=new PrimitiveOverLoading();
		f1(pol.new Z());
	}

	class X{}
	class Y extends X{}
	class Z extends Y{}
}
