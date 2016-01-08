package com.chapter18.learning.l_1812_s;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FreezeAlien {

	public static void main(String[] args) throws Exception {
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("resource/X.file"));
		Alien quellek=new Alien();
		out.writeObject(quellek);
	}

}
