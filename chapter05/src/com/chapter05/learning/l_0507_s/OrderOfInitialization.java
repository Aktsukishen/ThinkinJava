package com.chapter05.learning.l_0507_s;

class Window{
	Window(int maker){System.out.println("Window("+maker+")");}
}

class House{
	Window w1=new Window(1);
	House(){
		System.out.println("House()");
		w3=new Window(33);
	}
	Window w2=new Window(2);
	Window w3=new Window(3);
	void f(){
		System.out.println("f()");
	}
}

public class OrderOfInitialization {

	public static void main(String[] args) {
		House house=new House();
		house.f();
	}

}
