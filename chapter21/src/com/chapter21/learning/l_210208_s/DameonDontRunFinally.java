package com.chapter21.learning.l_210208_s;

import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable{
	public void run(){
		try{
			System.out.println("Starting ADaemon");
			TimeUnit.SECONDS.sleep(1);
		}catch(InterruptedException e){
			System.out.println("Exiting via Interrution");
		}finally{
			System.out.println("This should always run?");
		}
	}
}

/**
 * 
 * 后台线程不能保证其结束的时间，故而finally不能保证会执行
 * 
 * @author li.shensong
 *
 */
public class DameonDontRunFinally {
	public static void main(String[]args){
		Thread t=new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}
}
