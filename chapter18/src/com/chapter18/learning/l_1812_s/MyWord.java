package com.chapter18.learning.l_1812_s;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class House implements Serializable{}

class Animal implements Serializable{
	private String name;
	private House preferredHouse;
	Animal(String name,House h){
		this.name=name;
		this.preferredHouse=h;
	}
	public String toString(){
		return name+"["+super.toString()+"], "+preferredHouse+"\n";
	}
}

/**
 * 
 * 使用序列化操作可以方便的进行深度复制操作（克隆）:在反序列化的过程中，将会复制原有的对象的关系网，
 * @author Administrator
 *
 */
public class MyWord {
	
	public static void main(String[]args) throws Exception{
		House house=new House();
		List<Animal> animals=new ArrayList<Animal>();
		animals.add(new Animal("Bosco the dog", house));
		animals.add(new Animal("Ralph the hamster", house));
		animals.add(new Animal("Molly the cat", house));
		System.out.println(animals);
		ByteArrayOutputStream buf1=new ByteArrayOutputStream();
		ObjectOutputStream o1=new ObjectOutputStream(buf1);
		o1.writeObject(animals);
		o1.writeObject(animals);
		ByteArrayOutputStream buf2=new ByteArrayOutputStream();
		ObjectOutputStream o2=new ObjectOutputStream(buf2);
		o2.writeObject(animals);
		//Now get them back
		ObjectInputStream in1=new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
		ObjectInputStream in2=new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
		List animals1=(List)in1.readObject();
		List animals2=(List)in1.readObject();
		List animals3=(List)in2.readObject();
		//animals1,animals2都是从同一流中同一对象读出，所以指向相同的地址
		//animals1,animals2与aninals3尽管在写入流中是相同的对象，但经过不同流的输入和复原之后已经指向不同的地址
		System.out.println("animals1："+animals1);
		System.out.println("animals2："+animals2);
		System.out.println("animals3："+animals3);
	}
}
