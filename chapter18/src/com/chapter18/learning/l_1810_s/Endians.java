package com.chapter18.learning.l_1810_s;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * 
 * 设置字节读取时 高位优先还是低位优先
 * @author li.shensong
 *
 */
public class Endians {
	public static void main(String[]args){
		ByteBuffer bb=ByteBuffer.wrap(new byte[12]);
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
		
		bb.rewind();
		bb.order(ByteOrder.BIG_ENDIAN);//高位优先
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
		
		bb.rewind();
		bb.order(ByteOrder.LITTLE_ENDIAN);//低位优先
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
	}
}
