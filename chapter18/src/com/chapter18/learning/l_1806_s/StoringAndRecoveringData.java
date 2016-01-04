package com.chapter18.learning.l_1806_s;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StoringAndRecoveringData {
	static String file="resource/StoringAndRecoveringData.txt";
	public static void main(String[] args) throws IOException {
		DataOutputStream out=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		out.writeDouble(3.14159);
		out.writeUTF("This was pi");
		out.writeDouble(1.41413);
		out.writeUTF("Square root of 2");
		out.writeDouble(1.1);
		out.writeDouble(2.2);
		out.close();
		DataInputStream in=new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readDouble());
	}

}
