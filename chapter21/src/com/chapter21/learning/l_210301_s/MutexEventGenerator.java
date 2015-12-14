package com.chapter21.learning.l_210301_s;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEventGenerator extends IntGenerator{
	private int currentValue;
	private Lock lock=new ReentrantLock();
	public	int next(){
		lock.lock();
		try{
			++currentValue;
			Thread.yield();
			++currentValue;
			return currentValue;
		}finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		EventChecker.test(new MutexEventGenerator());
	}

}
