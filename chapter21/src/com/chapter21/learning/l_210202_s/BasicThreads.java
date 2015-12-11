package com.chapter21.learning.l_210202_s;

public class BasicThreads {

	public static void main(String[] args) {
		Thread t=new Thread(new LiftOff());
		t.start();
		System.out.println("Wating for LiftOff");
	}

}
