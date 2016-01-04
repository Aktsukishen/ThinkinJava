package com.chapter18.learning.l_1806_s;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * 缓冲输入文件
 * Reader:面向字符，更容易实现国际化
 * FileInputReader:字符输入
 * FileReader:构造函数String或者File
 * 为了提高速度，对文件进行缓冲，所以使用BufferedReader
 * 文件读入最好使用BufferedReader
 * @author li.shensong
 *
 */
public class BufferedInputFile {
	public static String read(String fileName) throws IOException{
		BufferedReader in=new BufferedReader(new FileReader(fileName));
		String s;
		StringBuilder sb=new StringBuilder();
		while((s=in.readLine())!=null){
			sb.append(s+"\n");
		}
		in.close();
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(read("resource/test.txt"));
	}

}
