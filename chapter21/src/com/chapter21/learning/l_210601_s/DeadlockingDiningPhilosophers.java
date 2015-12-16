package com.chapter21.learning.l_210601_s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 死锁条件：
 * 1.共用互斥资源
 * 2.必须至少有一个任务必须持有一个资源并且等待获取一个当前被别的任务持有的资源
 * 3.资源不能强行占有，只能有任务自己释放
 * 4.必须要有循环等待：如果不构成循环等待不会出现死锁
 * @author li.shensong
 *
 */
public class DeadlockingDiningPhilosophers {

	public static void main(String[] args) throws Exception{
		int ponder=1;
		if(args.length>0){
			ponder=Integer.parseInt(args[0]);
		}
		int size=5;
		if(args.length>1){
			size=Integer.parseInt(args[1]);
		}
		ExecutorService exec=Executors.newCachedThreadPool();
		Chopstick[] sticks=new Chopstick[size];
		for(int i=0;i<size;i++){
			sticks[i]=new Chopstick();
		}
		for(int i=0;i<size;i++){
			exec.execute(new Philosopher(sticks[i], sticks[(i+1)%size], i, ponder));
		}
		if(args.length==3&&args[2].equals("timeout")){
			TimeUnit.SECONDS.sleep(5);
		}else{
			System.out.println("Press 'Enter' to quit");
			System.in.read();
		}
		exec.shutdownNow();
	}

}
