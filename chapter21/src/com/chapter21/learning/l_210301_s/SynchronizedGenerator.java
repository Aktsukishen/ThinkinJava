package com.chapter21.learning.l_210301_s;

public class SynchronizedGenerator extends IntGenerator{
	private int currentValue=0;
	public synchronized int next(){
		++currentValue;
		Thread.yield();
		++currentValue;
		return currentValue;
	}
	
	public static void main(String[] args) {
		EventChecker.test(new SynchronizedGenerator());
	}

}
