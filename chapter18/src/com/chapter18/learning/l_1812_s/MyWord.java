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
 * ʹ�����л��������Է���Ľ�����ȸ��Ʋ�������¡��:�ڷ����л��Ĺ����У����Ḵ��ԭ�еĶ���Ĺ�ϵ����
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
		//animals1,animals2���Ǵ�ͬһ����ͬһ�������������ָ����ͬ�ĵ�ַ
		//animals1,animals2��aninals3������д����������ͬ�Ķ��󣬵�������ͬ��������͸�ԭ֮���Ѿ�ָ��ͬ�ĵ�ַ
		System.out.println("animals1��"+animals1);
		System.out.println("animals2��"+animals2);
		System.out.println("animals3��"+animals3);
	}
}
