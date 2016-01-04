package com.chapter18.learning.l_1808_s;

import java.io.PrintWriter;

public class ChangeSystemOut {

	public static void main(String[] args) {
		PrintWriter out=new PrintWriter(System.out,true);//true开启自动清空功能，否则会看不到输出
		out.println("Hello world");
	}

}
