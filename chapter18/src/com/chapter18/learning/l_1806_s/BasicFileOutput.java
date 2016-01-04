package com.chapter18.learning.l_1806_s;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * 
 * 输出到文件尽量使用PrintWriter:创建简单明了
 * @author li.shensong
 *
 */
public class BasicFileOutput {
	static String file="resource/BasicFileOutput.txt";
	static String test="src/com/chapter18/learning/l_1806_s/BasicFileOutput.java";
	public static void main(String[]args) throws IOException{
		BufferedReader in=new BufferedReader(new StringReader(BufferedInputFile.read(test)));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(file)));
		int fileCount=1;
		String s;
		while((s=in.readLine())!=null)
			out.println(fileCount++ +" "+s);
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}
}
