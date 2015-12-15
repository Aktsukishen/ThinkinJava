package com.chapter21.learning.l_210501_s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car{
	
	public synchronized void waxed() throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(200);//模拟打蜡的过程
		System.out.println("111111:"+System.currentTimeMillis());
		notifyAll();//唤醒所有在等待此锁的线程：打蜡结束，将唤醒所有正在准备进行进行抛光的线程
		wait();//让出锁，并让当前线程挂起，不往下执行，进入阻塞状态：打蜡线程挂起，不往下执行
		System.out.println("aaaaaa:"+System.currentTimeMillis());
	}
	
	public synchronized void buffed() throws InterruptedException{//抛光
		TimeUnit.MILLISECONDS.sleep(300);//模拟抛光的过程
		System.out.println("222222:"+System.currentTimeMillis());
		notifyAll();//抛光结束，将唤醒所有正在准备进行打蜡的线程
		wait();
		System.out.println("bbbbbb:"+System.currentTimeMillis());
	}
	
}

class WaxOn implements Runnable{
	private Car car;
	public WaxOn(Car c){ car=c;}
	public void run(){
		try{
			while(!Thread.interrupted()){
				car.waxed();
			}
		}catch(InterruptedException e){
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax On task");
	}
}

class WaxOff implements Runnable{
	private Car car;
	public WaxOff(Car c){ car=c;}
	public void run(){
		try{
			while(!Thread.interrupted()){
				car.buffed();
			}
		}catch(InterruptedException e){
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax Off task");
	}
}

public class WaxOMatic {

	public static void main(String[] args) throws InterruptedException {
		Car car=new Car();
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}

}
