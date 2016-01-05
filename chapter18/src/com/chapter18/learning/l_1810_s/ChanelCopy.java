package com.chapter18.learning.l_1810_s;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 
 * 文件的拷贝读取
 * @author li.shensong
 *
 */
public class ChanelCopy {
	private static int BSIZE=1024;
	@SuppressWarnings("resource")
	public static void main(String[]args) throws Exception{
		String fileIn="resource/data.txt";
		String fileOut="resource/datacopy.txt";
		FileChannel in=new FileInputStream(fileIn).getChannel();
		FileChannel out=new FileOutputStream(fileOut).getChannel();
		ByteBuffer buff=ByteBuffer.allocate(BSIZE);
		while((in.read(buff))!=-1){//每次最多读取1024个字节
			buff.flip();//prepare for writing,getting
			out.write(buff);
			buff.clear();//prepare for reading
		}
	}
}
