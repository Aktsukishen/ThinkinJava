package com.chapter18.learning.l_1810_s;

import java.nio.ByteBuffer;

/**
 * 
 * 状态初始化：position为0，清除所有mark
 * @author li.shensong
 *
 */
public class GetData {
	private static final int BASIZE=1024;
	public static void main(String[] args) {
		ByteBuffer bb=ByteBuffer.allocate(BASIZE);
		int i=0;
		while(i++<bb.limit()){
			if(bb.get()!=0) System.out.println("nonzero");
		}
		System.out.println("i="+i);
		bb.rewind();
		bb.asCharBuffer().put("Howdy!");
		char c;
		while((c=bb.getChar())!=0){
			System.out.print(c+" ");
		}
		System.out.println();
		bb.rewind();
		//Store and read a short
		bb.asShortBuffer().put((short)471142);
		System.out.println(bb.getShort());
		
		bb.rewind();//position=0 clear marks
		//store and read an integer
		bb.asIntBuffer().put(99471142);
		System.out.println(bb.getInt());
		bb.rewind();
		
		bb.asLongBuffer().put(99471142);
		System.out.println(bb.getLong());
		bb.rewind();
		
		bb.asFloatBuffer().put(99471142);
		System.err.println(bb.getFloat());
		bb.rewind();
		
		bb.asDoubleBuffer().put(99471142);
		System.out.println(bb.getDouble());
		bb.rewind();
	}

}
