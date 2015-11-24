package com.chapter15.learning.l_1502_s;

/**
 * 
 * 使用元组，一次返回多个对象
 * @author li.shensong
 *
 * @param <A> 第一个对象的类型参数
 * @param <B> 第二个对象的类型参数
 */
public class TwoTuple<A, B> {

	public final A first;
	public final B second;
	public TwoTuple(A a,B b){first=a;second=b;}
	@Override
	public String toString(){
		return "("+first+","+second+")";
	}
}
