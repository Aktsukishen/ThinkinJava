package com.chapter17.learning.l_1710_s;

public abstract class Test<C> {
	String name;
	public Test(String name){
		this.name=name;
	}
	abstract int test(C container,TestParam p);
}
