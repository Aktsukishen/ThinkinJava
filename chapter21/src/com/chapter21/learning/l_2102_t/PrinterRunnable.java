package com.chapter21.learning.l_2102_t;

public class PrinterRunnable implements Runnable{
	static int count = 0;
	int id = ++ count;
	int account = 3;
	
	public PrinterRunnable() {
		System.out.println("PrinterRunnable " + id + " start");
		
	}
	
	@Override
	public void run() {
		while(account > 0){
			System.out.println("PrinterRunnable "+ id + " print" +  account--);
			Thread.currentThread().yield();
		}
		System.out.println("PrinterRunnable " + id + " end printing");
	}
	
}
