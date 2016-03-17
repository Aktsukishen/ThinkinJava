package com.lss.gson.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class GsonTest {

	public static void main(String[]args) throws IOException{
		FileReader in=new FileReader("files/test.json");
		BufferedReader reader=new BufferedReader(in);
		String json="";
		String line="";
		while((line=reader.readLine())!=null){
			json+=line;
		}
		reader.close();
		Gson gson=new Gson();
		Person p=gson.fromJson(json, Person.class);
		System.out.println("firstName:"+p.getFirstName()+" lastName:"+p.getLastName());		
	}
}
