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

/**
 * 
 * 类的全局变量定义的顺序决定了初始化的顺序，且在调用构造器之前就已经初始值
 * 对于方法的局部变量，由于是第一次使用，之前并没有初始化，所以全局变量首次出现时必须赋初始值
 * @author Administrator
 *
 */
public class OrderOfInitialization {

	public static void main(String[] args) {
		House house=new House();
		house.f();
	}

}
