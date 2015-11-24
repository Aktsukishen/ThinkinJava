package com.chapter15.learning.l_1502_t;

/**
 * 
 * 使用一个对象使其能够具有相同类型的3个对象
 * @author li.shensong
 *
 * @param <T>
 */
public class Holder<T> {
	private T a;
	private T b;
	private T c;
	public T getA() {
		return a;
	}
	public void setA(T a) {
		this.a = a;
	}
	public T getB() {
		return b;
	}
	public void setB(T b) {
		this.b = b;
	}
	public T getC() {
		return c;
	}
	public void setC(T c) {
		this.c = c;
	}
	public Holder(T a,T b,T c){ this.a=a;this.b=b;this.c=c;}
	public static void main(String[]args){
		Holder<String> holder1=new Holder<String>("one", "two", "three");
		System.out.println("a="+holder1.getA()+" b="+holder1.getB()+" c="+holder1.getC());
		Holder<Integer> holder2=new Holder<Integer>(1, 2, 3);
		System.out.println("a="+holder2.getA()+" b="+holder2.getB()+" c="+holder2.getC());
	}
}
