package com.chapter18.learning.l_1812_s;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

class Data implements Serializable{
	private int n;
	public Data(int n){
		this.n=n;
	}
	public String toString(){
		return Integer.toString(n);
	}
}

public class Worm implements Serializable{

	private static Random rand=new Random(47);
	
	private Data[] d={
			new Data(rand.nextInt(10)),
			new Data(rand.nextInt(10)),
			new Data(rand.nextInt(10))
	};
	
	private Worm next;
	private char c;
	public Worm(int i,char x){
		System.out.println("Worm constructor: "+i);
		c=x;
		if(--i>0){
			next=new Worm(i,(char)(x+1));
		}
	}
	public Worm(){
		System.out.println("Default constructor");
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder(":");
		sb.append(c);
		sb.append("(");
		for(Data data:d){
			sb.append(data);
		}
		sb.append(")");
		if(next!=null){
			sb.append(next);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception{
		Worm w=new Worm(6,'a');
		System.out.println("w="+w);
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("resource/worm.out"));
		out.writeObject("Worm storage\n");
		out.writeObject(w);
		out.close();
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("resource/worm.out"));
		String s=(String)(in.readObject());
		Worm w2=(Worm)(in.readObject());
		System.out.println(s+" w2="+w2);
		ByteArrayOutputStream bot=new ByteArrayOutputStream();
		ObjectOutputStream out2=new ObjectOutputStream(bot);
		out2.writeObject("Worm storage\n");
		out2.writeObject(w);
		out2.flush();
		ObjectInputStream in2=new ObjectInputStream(new ByteArrayInputStream(bot.toByteArray()));
		s=(String)in2.readObject();
		Worm w3=(Worm) in2.readObject();
		System.out.println(s+" w3="+w3);
	}

}
