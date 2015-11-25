package com.chapter15.learning.l_1504_s;

public class CountedObject {

	private static long counter=1;
	private final long id=counter++;
	private long id(){return id;}
	public String toString(){
		return "CountedObject "+id;
	}
}
