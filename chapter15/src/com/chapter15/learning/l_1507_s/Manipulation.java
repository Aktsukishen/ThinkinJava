package com.chapter15.learning.l_1507_s;

class HasF{
	public void f(){System.out.println("HasF.f()");}
}

class HasF2 extends HasF{
	public void f(){System.out.println("HasF2.f()");}
	public void f2(){System.out.println("HasF2.f2()");}
}

class HasF3 extends HasF{
	public void f(){System.out.println("HasF3.f()");}
	public void f3(){System.out.println("HasF3.f3()");}
}

class Manipulator<T>{
	private T obj;
	public Manipulator(T x){obj=x;}
//	下面语句无法编译通过，因为编译器不能保证你赋值的x是否具有f方法
//	public void mainipulate(){obj.f();}
}

class Manipulator2<T extends HasF>{
	private T obj;
	public Manipulator2(T x){obj=x;}
//	下面语句编译通过，因为extends表明T一定具有f方法
	public void mainipulate(){obj.f();}
}

class Manipulator3{
	private HasF obj;
	public Manipulator3(HasF x){obj=x;}
//	从2中可以看到当使用extends与将obj的类型定义为接口和基础类没什么区别，而且简洁明了
//  所以如果，一个方法或者类不是被多个不同类型（基础类不同）的参数所公用，最好不要使用泛型
	public void mainipulate(){obj.f();}
}

class Manipulator4<T extends HasF>{
	private T obj;
	public Manipulator4(T x){obj=x;}
	public void mainipulate(){obj.f();}
	//现在看来，较之使用接口或者类的继承，使用extends的唯一好处是我们在返回数据类型时可以直接获得指定类型的数据，而不需要再次向上转型
	public T get(){ return obj;}
}

public class Manipulation { 

	public static void main(String[] args) {
        Manipulator4<HasF2> t1=new Manipulator4<HasF2>(new HasF2());
        t1.get().f();
        t1.get().f2();//不用强制转型为HasF2
        
        Manipulator4<HasF3> t2=new Manipulator4<HasF3>(new HasF3());
        t2.get().f();
        t2.get().f3();//不用强制转型为HasF3
	}
	

}
