package com.chapter18.learning.l_1810_s;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 文件的快速拷贝
 * 文件通道的transferTo,transferFrom可以直接对接2个管道
 * @author li.shensong
 *
 */
public class TransferTo {

	public static void main(String[] args) throws Exception {
		String fileIn="resource/data.txt";
		String fileOut="resource/dataTransferTo.txt";
		FileChannel in=new FileInputStream(fileIn).getChannel();
		FileChannel out=new FileOutputStream(fileOut).getChannel();
//		in.transferTo(0, in.size(), out);
		out.transferFrom(in, 0, in.size());
		in.close();
		out.close();
	}

}
