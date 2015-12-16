package com.chapter21.learning.l_210701_s;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskPortion implements Runnable{
	private static int counter=0;
	private final int id=counter++;
	private static Random rand=new Random(47);
	private final CountDownLatch latch;
	public TaskPortion(CountDownLatch latch){
		this.latch=latch;
	}
	public void run(){
		try{
			doWork();
			latch.countDown();
		}catch(InterruptedException e){
			
		}
	}
	public void doWork() throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
		System.out.println(this+" completed");
	}
	public String toString(){
		return String.format("%1$-3d", id);
	}
}

class WaitingTask implements Runnable{
	private static int counter=0;
	private final int id=counter++;
	private final CountDownLatch latch;
	WaitingTask(CountDownLatch latch){
		this.latch=latch;
	}
	public void run(){
		try{
			latch.await();//只有当数量变为0的时候才会往下执行，否则会一直阻塞
			System.out.println("Latch barrier pressed for "+this);
		}catch(InterruptedException e){
			System.out.println(this+ " interrupted");
		}
	}
	public String toString(){
		return String.format("WatingTask %1$-3d", id);
	}
}

public class CountDownLatchDemo {
	static final int SIZE=100;
	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();
		CountDownLatch latch=new CountDownLatch(SIZE);
		for(int i=0;i<10;i++){
			exec.execute(new WaitingTask(latch));
		}
		for(int i=0;i<SIZE;i++){
			exec.execute(new TaskPortion(latch));
		}
		System.out.println("Lauched all tasks");
		exec.shutdown();
	}

}
