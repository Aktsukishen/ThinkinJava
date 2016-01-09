package com.chapter18.learning.l_1812_s;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Blip1 implements Externalizable {

	public Blip1(){
		System.out.println("Blip1 Consructor");
	}
	
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		System.out.println("Blip1.readExternal");
	}

	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		System.out.println("Blip1.writeExternal");
	}

}

class Blip2 implements Externalizable{
	Blip2(){
		System.out.println("Blip2 Consructor");
	}
	
	
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		System.out.println("Blip2.readExternal");
	}

	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		System.out.println("Blip2.writeExternal");
	}
}

public class Blips{
	public static void main(String[]args) throws Exception{
		System.out.println("Constructing objects");
		Blip1 b1=new Blip1();
		Blip2 b2=new Blip2();
		ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("resource/Blips.out"));
		System.out.println("Saving objects:");
		o.writeObject(b1);
		o.writeObject(b2);
		o.close();
		//Now get them back
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("resource/Blips.out"));
		System.out.println("Recovering b2:");
		b1=(Blip1)in.readObject();
		//error Blip2 constructor public
		System.out.println("Recovering b1");
		b2=(Blip2)in.readObject();
		in.close();
	}
}
