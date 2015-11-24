package com.chapter15.learning.l_1502_s;

/**
 * 
 * 使用泛型来存储任何对象
 * @author li.shensong
 *
 *泛型的使用方法注意：
 *1.在类名后面使用尖括号来括住类型参数，此后其他方法中不需要在使用尖括号
 *2.在使用构造函数进行对象创建时，使用类名<类型参数1，类型参数2...类型参数n>(参数1，参数2...参数m)来进行对象的创建
 *
 * @param <T>
 */
public class Holder3<T> {
	private T a;
	public Holder3(T a){this.a=a;}
	public void set(T a){this.a=a;}
	public T get(){ return a;}
	public static void main(String[]args){
		Holder3<Automobile> h3=new Holder3<Automobile>(new Automobile());
		Automobile a=h3.get();
	}

}
