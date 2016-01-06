package com.chapter18.learning.l_1811_s;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipCompress {

	public static void main(String[] args) throws Exception{
		BufferedReader reader=new BufferedReader(new FileReader("resource/test.txt"));
		BufferedOutputStream out=new BufferedOutputStream(
				new GZIPOutputStream(new FileOutputStream("resource/test.zip")));//使用GZIPOutputStream进行输出进行压缩
		System.out.println("Writing File");
		int c;
		while((c=reader.read())!=-1){
			out.write(c);
		}
		reader.close();
		out.close();
		System.out.println("Reading File");
		BufferedReader reader2=new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream("resource/test.zip"))));//使用GZIPInputStream读入进行解压缩
		String s;
		while((s=reader2.readLine())!=null){
			System.out.println(s);
		}
	}

}
