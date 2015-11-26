package com.chapter15.learning.l_1508_s;

abstract class GenericWithCreate<T>{
	final T element;
	public GenericWithCreate() {
		element=create();
	}
	abstract T create();
}

class X{}

class Creator extends GenericWithCreate<X>{

	@Override
	X create() {
		return new X();
	}
	
	void f(){
		System.out.println(element.getClass().getSimpleName());
	}
}

public class CreatorGerneric {

	public static void main(String[] args) {
		Creator c=new Creator();
		c.f();
	}

}
