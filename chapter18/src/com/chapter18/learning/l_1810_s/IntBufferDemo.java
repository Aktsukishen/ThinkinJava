package com.chapter18.learning.l_1810_s;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 
 * flip:limit设置成当前position，丢弃之前的设置，position归0，清除所有mark
 * @author li.shensong
 *
 */
public class IntBufferDemo {
	private static final int BSIZE=1024;
	public static void main(String[] args) {
		ByteBuffer bb=ByteBuffer.allocate(BSIZE);
		IntBuffer ib=bb.asIntBuffer();
		ib.put(new int[]{11,41,53,64,75,5});
		System.out.println(ib.get(3));
		ib.put(3, 81);
		System.out.println(ib.get(3));
		//Flips this buffer. 
		//The limit is set to the current position and then the position is set to zero. 
		//If the mark is defined then it is discarded. 
		//After a sequence of channel-read or put operations,
		// invoke this method to prepare for a sequence of channel-write or relative get operations. 
		ib.flip();
		while(ib.hasRemaining()){
			System.out.println(ib.get());
		}
	}

}
