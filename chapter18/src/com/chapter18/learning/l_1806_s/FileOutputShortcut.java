package com.chapter18.learning.l_1806_s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {
	static String file="resource/FileOutputShortcut.txt";
	static String test="src/com/chapter18/learning/l_1806_s/FileOutputShortcut.java";
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new StringReader(BufferedInputFile.read(test)));
		PrintWriter out=new PrintWriter(file);//快速的文件输出类，再也不需要多次new装饰器类了
		int lineCount=1;
		String s;
		while((s=in.readLine())!=null){
			out.println(lineCount+++" "+s);
		}
		out.close();
		System.out.println(BufferedInputFile.read(test));
	}

}
