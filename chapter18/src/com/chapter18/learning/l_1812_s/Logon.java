package com.chapter18.learning.l_1812_s;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * transient 瞬时，不会把数据保存到磁盘，另外自动化序列也不会尝试去恢复他
 * @author Administrator
 *
 */
public class Logon implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Date date =new Date();
	private String username;
	private transient String password;
	public Logon(String name,String pwd){
		username=name;
		this.password=pwd;
	}
	public String toString(){
		return "logon info:\n\tusername:"+username+"\n\tdate:"+date+"\n\tpaswword:"+password;
	}
	public static void main(String[] args) throws Exception {
		Logon a=new Logon("Hulk","myLittlePony");
		System.out.println("longon a="+a);
		ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("resource/Logon.txt"));
		o.writeObject(a);
		o.close();
		//Now get them back
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("resource/Logon.txt"));
		System.out.println("Recovering object at "+new Date());
		a=(Logon)in.readObject();
		System.out.println(a);
		in.close();
	}

}
