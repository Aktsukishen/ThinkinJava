package com.chapter21.learning.l_210301_s;

public class EventGenerator extends IntGenerator {
	private int currentValue=0;
	@Override
	public int next() {
		++currentValue;
		++currentValue;
		return currentValue;
	}
	
	public static void main(String[]args){
		EventChecker.test(new EventGenerator());
	}
}
