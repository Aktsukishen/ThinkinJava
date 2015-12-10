package com.chapter21.learning.l_2102_s;

public class BasicThreads {

	public static void main(String[] args) {
		Thread t=new Thread(new LiftOff());
		t.start();
		System.out.println("Wating for LiftOff");
	}

}
