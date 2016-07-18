package com.chapter21.learning.l_2102_t;

import java.util.concurrent.TimeUnit;

public class Exe01 {

	public static void main(String[]args){
		for (int i= 0; i<10;i++){
			new Thread(new PrinterRunnable()).start();
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finish task1");
		for (int i= 1; i < 10; i++ ){
			new Thread(new FibonacciRunnable(i)).start();;
		}
	}
}


