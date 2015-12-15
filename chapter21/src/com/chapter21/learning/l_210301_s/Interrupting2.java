package com.chapter21.learning.l_210301_s;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockMutex{
	private Lock lock=new ReentrantLock();
	public BlockMutex(){
//		lock.lock();//构造的同时即上锁
	}
	public void f(){
		try{
			lock.lockInterruptibly();//阻塞 除非外界主动interrupt或者锁释放
			System.out.println("lock acquired f()");
		}catch(InterruptedException e){
			System.out.println("Interrputed from lock acquisition in f()");
		}
	}
}

class Blocked2 implements Runnable{
	BlockMutex blocked=new BlockMutex();
	public void run(){
		System.out.println("Wating for f() in BlockMutex");
		blocked.f();
		System.out.println("stop");
	}
}


public class Interrupting2 {

	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(new Blocked2());
		t.start();
		
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Issuing t.interrupt");
		t.interrupt();
	}

}
