package com.chapter21.learning.l_210301_s;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


public class AttemptLocking {
	private ReentrantLock lock=new ReentrantLock();
	public void untimed(){
		boolean catpture=lock.tryLock();
		try{
			System.out.println("trylock(): "+catpture);
		}finally{
			if(catpture){
				lock.unlock();
			}
		}
	}
	
	public void timed(){
		boolean capture=false;
		try{
			capture=lock.tryLock(2, TimeUnit.SECONDS);//尝试在2秒的时间里获取锁
		}catch(InterruptedException e){
			throw new RuntimeException();
		}
		try{
			System.out.println("lock.tryLock(2, TimeUnit.SECONDS):"+capture);	
		}finally{
			if(capture){
				lock.unlock();
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		final AttemptLocking al=new AttemptLocking();
		al.untimed();
		al.timed();
		new Thread(){
			{
				setDaemon(true);//这是什么写法？？？
			}
			public void run(){
				al.lock.lock();
				System.out.println("acquired");
			}
		}.start();;
		TimeUnit.SECONDS.sleep(2);
		Thread.yield();
		al.untimed();
		al.timed();
	}

}
