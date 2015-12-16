package com.chapter21.learning.l_210601_s;

public class Chopstick {
	private boolean taken=false;
	public synchronized void take() throws InterruptedException{
		while(taken){//如果已经被获取
			wait();
		}
		taken=true;//获取
	}
	public synchronized void drop(){
		taken=false;
		notifyAll();
	}
}
