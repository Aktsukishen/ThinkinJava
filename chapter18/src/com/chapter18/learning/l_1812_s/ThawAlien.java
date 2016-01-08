package com.chapter18.learning.l_1812_s;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ThawAlien {

	public static void main(String[] args) throws Exception {
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("resource/X.file"));
		Object mystery=in.readObject();
		System.out.println(mystery.getClass());
	}

}
