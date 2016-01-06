package com.chapter18.learning.l_1810_s;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {

	public static void main(String[] args) {
		char[] data="UsingBuffers".toCharArray();
		ByteBuffer bb=ByteBuffer.allocate(data.length<<1);
		CharBuffer cb=bb.asCharBuffer();
		cb.put(data);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
	}

	private static void symmetricScramble(CharBuffer buffer){
		while(buffer.hasRemaining()){
			buffer.mark();//先标记位置
			char c1=buffer.get();
			char c2=buffer.get();
			buffer.reset();//恢复位置
			buffer.put(c2).put(c1);//当前位置先放入后一个数据再放入下一个数据
		}
	}
}
