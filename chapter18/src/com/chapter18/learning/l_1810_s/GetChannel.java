package com.chapter18.learning.l_1810_s;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 
 * FileChannel 文件通道  ByteBuffer 缓冲器  提高读写速度
 * FileInputStream,FileOutStream,RandomAccessFile可以产生FileChannel
 * 唯一直接与通道交互的缓冲器是ByteBuffer
 * @author li.shensong
 *
 */
public class GetChannel {
	private static final int BSIZE=1024;
	@SuppressWarnings("resource")
	public static void main(String[]args) throws Exception{
		//获得文件通道
		FileChannel fc=new FileOutputStream("resource/data.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));//注意:只有ByteBuffer可以直接与通道打交道
		fc.close();
		fc=new RandomAccessFile("resource/data.txt", "rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap(" Some more".getBytes()));
		fc.close();
		fc=new FileInputStream("resource/data.txt").getChannel();
		ByteBuffer bb=ByteBuffer.allocate(BSIZE);//只能使用此静态方法来创建实例
		fc.read(bb);//读入数据到ByteBuffer
		bb.flip();//设置内置的标志位到数据准备读取的状态
		while(bb.hasRemaining()){
			System.out.println((char)bb.get());
		}
		fc.close();
	}
}
