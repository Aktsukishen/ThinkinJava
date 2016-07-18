package com.chapter21.learning.l_2102_t;

import java.util.concurrent.TimeUnit;

public class Exe07 {

	public static void main(String[] args) throws InterruptedException {
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		TimeUnit.SECONDS.sleep(5);
	}

}

class Daemon implements Runnable{
	private Thread[] ts = new Thread[10];
	
	@Override
	public void run(){
		for(int i =0; i<ts.length;i++){
			ts[i] = new Thread(new DaemonSpawn());
			ts[i].start();
			System.out.println("DaemonSpawn " + i + " started");
		}
		for(int i= 0; i< ts.length;i++){
			System.out.println("ts[" + i +"] is daemon():" + ts[i].isDaemon());
		}
		while(true){
			Thread.yield();
		}
	}
}

class DaemonSpawn implements Runnable{
	public void run(){
		while(true)
			Thread.yield();
	}
}
