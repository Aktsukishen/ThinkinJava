package com.chapter21.learning.l_210501_s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Car2{
	private Lock lock=new ReentrantLock();
	private Condition condition =lock.newCondition();
	private boolean waxOn=false;
	public void waxed(){
		lock.lock();
		try{
			waxOn=true;
			condition.signalAll();
		}finally{
			lock.unlock();
		}
	}
	public void buffed(){
		lock.lock();
		try{
			waxOn=false;
			condition.signalAll();
		}finally{
			lock.unlock();
		}
	} 
	public void waitForWaxing() throws InterruptedException{
		lock.lock();
		try{
			while(waxOn==false){
				condition.await();
			}
		}finally{
			lock.unlock();
		}
	}
	
	public void waitForBuffing() throws InterruptedException{
		lock.lock();
		try{
			while(waxOn==true)
				condition.await();
		}finally{
			lock.unlock();
		}
	}
}

class WaxOn2 implements Runnable{
	private Car2 car;
	public  WaxOn2(Car2 car){
		this.car=car;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				System.out.println("Wax On");
				TimeUnit.SECONDS.sleep(1);
				car.waxed();
				car.waitForBuffing();
			}
		}catch(InterruptedException e){
			System.out.println("Exiting via interrupt.");
		}
		System.out.println("Ending Wax On Task");
	}
}

class WaxOff2 implements Runnable{
	private Car2 car;
	public WaxOff2(Car2 car){
		this.car=car;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				car.waitForWaxing();
				System.out.println("Wax Off");
				TimeUnit.SECONDS.sleep(1);
				car.buffed();
			}
		}catch(InterruptedException e){
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax Off Task");
	}
}


public class WaxOMatic2 {

	public static void main(String[] args) throws InterruptedException {
		Car2 car=new Car2();
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute(new WaxOff2(car));
		exec.execute(new WaxOn2(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}

}
