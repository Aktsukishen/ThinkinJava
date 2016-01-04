package com.chapter18.learning.l_1806_s;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {

	public static void main(String[] args) throws IOException{
		DataInputStream in=new DataInputStream(
				new ByteArrayInputStream(BufferedInputFile.read("test.txt").getBytes()));
		while(in.available()!=0){//available()方法查看还有多少个可供存取的字符
			System.out.println((char)in.readByte());
		}
	}

}
