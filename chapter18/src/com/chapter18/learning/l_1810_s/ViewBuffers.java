package com.chapter18.learning.l_1810_s;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/**
 * 
 * 底层为字节缓冲器
 * 可以利用字节缓冲器转换成不同的视图缓冲器
 * 不同的视图缓冲器数据的存储数据时每个数据的字节数不同
 * 
 * byte 	1个byte
 * char 	2个byte
 * short    2个byte
 * integer  4个byte
 * float    4个byte
 * long     8个byte
 * double   8个byte
 * 数据结构：默认高位在前，低位在后
 * 
 * @author li.shensong
 *
 */
public class ViewBuffers {

	public static void main(String[] args) {
		ByteBuffer bb=ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
		bb.rewind();
		System.out.print("Byte Buffer ");
		while(bb.hasRemaining()){
			System.out.print(bb.position()+" -> "+bb.get()+",");
		}
		System.out.println();
		
		CharBuffer cb=((ByteBuffer)(bb.rewind())).asCharBuffer();
		System.out.print("Char Buffer ");
		while(cb.hasRemaining()){
			System.out.print(cb.position()+" -> "+cb.get()+",");
		}
		System.out.println();
		
		FloatBuffer fb=((ByteBuffer)(bb.rewind())).asFloatBuffer();
		System.out.print("Float Buffer ");
		while(fb.hasRemaining()){
			System.out.print(fb.position()+" -> "+fb.get()+",");
		}
		System.out.println();
		
		IntBuffer ib=((ByteBuffer)(bb.rewind())).asIntBuffer();
		System.out.print("Int Buffer ");
		while(ib.hasRemaining()){
			System.out.print(ib.position()+" -> "+ib.get()+",");
		}
		System.out.println();
		
		LongBuffer lb=((ByteBuffer)(bb.rewind())).asLongBuffer();
		System.out.print("Long Buffer ");
		while(lb.hasRemaining()){
			System.out.print(lb.position()+" -> "+lb.get()+",");
		}
		System.out.println();
		
		ShortBuffer sb=((ByteBuffer)(bb.rewind())).asShortBuffer();
		System.out.print("Short Buffer ");
		while(sb.hasRemaining()){
			System.out.print(sb.position()+" -> "+sb.get()+",");
		}
		System.out.println();
		
		DoubleBuffer db=((ByteBuffer)(bb.rewind())).asDoubleBuffer();
		System.out.print("Double Buffer ");
		while(db.hasRemaining()){
			System.out.print(db.position()+" -> "+db.get()+",");
		}
		System.out.println();
		
	}

}
