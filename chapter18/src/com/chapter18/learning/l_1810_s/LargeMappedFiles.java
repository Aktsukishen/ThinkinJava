package com.chapter18.learning.l_1810_s;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMappedFiles {
	static int length=0X8FFFFFF;//128MB
	public static void main(String[] args) throws Exception {
		MappedByteBuffer out=new RandomAccessFile("resource/largemap.txt", "rw").getChannel()
								.map(FileChannel.MapMode.READ_WRITE	, 0, length);
		for(int i=0;i<length;i++){
			out.put((byte)'x');
		}
		System.out.println("Finish writing");
		for(int i=length/2;i<length/2+6;i++)
			System.out.println((char)out.get(i));
	}

}
