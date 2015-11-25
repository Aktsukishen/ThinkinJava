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
//	��������޷�����ͨ������Ϊ���������ܱ�֤�㸳ֵ��x�Ƿ����f����
//	public void mainipulate(){obj.f();}
}

class Manipulator2<T extends HasF>{
	private T obj;
	public Manipulator2(T x){obj=x;}
//	����������ͨ������Ϊextends����Tһ������f����
	public void mainipulate(){obj.f();}
}

class Manipulator3{
	private HasF obj;
	public Manipulator3(HasF x){obj=x;}
//	��2�п��Կ�����ʹ��extends�뽫obj�����Ͷ���Ϊ�ӿںͻ�����ûʲô���𣬶��Ҽ������
//  ���������һ�����������಻�Ǳ������ͬ���ͣ������಻ͬ���Ĳ��������ã���ò�Ҫʹ�÷���
	public void mainipulate(){obj.f();}
}

class Manipulator4<T extends HasF>{
	private T obj;
	public Manipulator4(T x){obj=x;}
	public void mainipulate(){obj.f();}
	//���ڿ�������֮ʹ�ýӿڻ�����ļ̳У�ʹ��extends��Ψһ�ô��������ڷ�����������ʱ����ֱ�ӻ��ָ�����͵����ݣ�������Ҫ�ٴ�����ת��
	public T get(){ return obj;}
}

public class Manipulation { 

	public static void main(String[] args) {
        Manipulator4<HasF2> t1=new Manipulator4<HasF2>(new HasF2());
        t1.get().f();
        t1.get().f2();//����ǿ��ת��ΪHasF2
        
        Manipulator4<HasF3> t2=new Manipulator4<HasF3>(new HasF3());
        t2.get().f();
        t2.get().f3();//����ǿ��ת��ΪHasF3
	}
	

}
