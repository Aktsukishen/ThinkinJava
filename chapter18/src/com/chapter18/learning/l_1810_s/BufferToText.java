package com.chapter18.learning.l_1810_s;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
	private static final int BSIZE=1024;
	public static void main(String[] args) throws Exception {
		String fileOut="resource/BufferToTextOut.txt";
		FileChannel fc=new FileOutputStream(fileOut).getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		
		fc=new FileInputStream(fileOut).getChannel();
		ByteBuffer buff=ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		System.out.println(buff.asCharBuffer());
		buff.rewind();
		String encoding=System.getProperty("file.encoding");
		System.out.println("Decoded using "+encoding+":"+Charset.forName(encoding).decode(buff));
		
		fc=new FileOutputStream(fileOut).getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		fc.close();
		
		fc=new FileInputStream(fileOut).getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		
		//Use a CharBuffer to write through
		fc=new FileOutputStream(fileOut).getChannel();
		buff=ByteBuffer.allocate(24);
		buff.asCharBuffer().put("Some text");
		fc.write(buff);
		fc.close();
		
		fc=new FileInputStream(fileOut).getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer()+"xxx");
	}

}
