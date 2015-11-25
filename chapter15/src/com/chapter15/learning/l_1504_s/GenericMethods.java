package com.chapter15.learning.l_1504_s;

/**
 * 
 * 泛型方法
 * @author li.shensong
 *
 */
public class GenericMethods {

	//泛型方法格式：public <泛型参数1，泛型参数2，... 泛型参数n> 返回值类型  方法名(参数1，参数2，...，参数m)
	public <T> void f(T x){
		System.out.println(x.getClass().getSimpleName());
	}
	
	public <T,X> T g(T t,X x,int a){
		return t;
	}
	public static void main(String[]args){
		GenericMethods gm=new GenericMethods();
		gm.f("");
		gm.f(1);
		System.out.println(gm.g(10, 11.0f, 100));
	}
	
}
