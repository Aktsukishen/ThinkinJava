package com.chapter18.learning.l_1808_s;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Redriecting {

	public static void main(String[] args) throws IOException {
		String file="src/com/chapter18/learning/l_1808_s/Redriecting.java";
		PrintStream console=System.out;
		BufferedInputStream in=new BufferedInputStream(new FileInputStream(file));
		PrintStream out=new PrintStream(new BufferedOutputStream(new FileOutputStream("resource/test3.txt")));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null)
			System.out.println(s);
		out.close();
		System.setOut(console);
	}

}
