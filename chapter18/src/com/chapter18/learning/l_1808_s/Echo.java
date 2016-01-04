package com.chapter18.learning.l_1808_s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {
	public static void main(String[]args) throws IOException{
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=stdin.readLine())!=null&& !s.equals(""))
			System.out.println(s);
	}
}
