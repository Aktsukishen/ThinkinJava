package com.chapter21.learning.l_210301_s;

import java.util.concurrent.TimeUnit;

/**
 * 
 * 中断发生的唯一时刻是任务处于阻塞操作红或者已经在阻塞操作的内部时
 * 如果程序运行的时间不在阻塞操作中 那么程序将继续往下运行,直至进入阻塞状态
 * 如果程序处于阻塞状态，则直接抛出InterruptException
 * @author li.shensong
 *
 */
public class InterruptingIdiom{
	public static void main(String[]args) throws Exception{
		if(args.length!=1){
			System.out.println("usage:java InterruptingIdiom delay-in-ms");
			System.exit(1);
		}
		Thread t=new Thread(new Blocked3());
		t.start();
		TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
		t.interrupt();
	}
}

class NeedsCleanup{
	private final int id;
	public NeedsCleanup(int indent){
		this.id=indent;
		System.out.println("NeedsCleanup "+id);
	}
	public void cleanup(){
		System.out.println("Cleaning up "+id);
	}
}

class Blocked3 implements Runnable{
	private volatile double d=0.0;
	public void run(){
		long start=System.currentTimeMillis();
		System.out.println("start:"+start);
		try{
			while(!Thread.interrupted()){
				//point1
				NeedsCleanup n1=new NeedsCleanup(1);
				
				try{
					System.out.println("Sleeping begin time:"+(System.currentTimeMillis()-start));
					TimeUnit.SECONDS.sleep(1);//在此时被中断时，走finally,抛出InterruptException
					System.out.println("Sleeping end time:"+(System.currentTimeMillis()-start));
					//point2 此时被中断，不是阻塞状态，那么继续往下执行，直至遇到阻塞状态
					NeedsCleanup n2=new NeedsCleanup(2);
					try{
						System.out.println("Calculating");
						for(int i=0;i<2500000;i++){
							d=d+(Math.PI+Math.E)/d;
						}
						System.out.println("finish time-comsuming operation");
					}finally{
						n2.cleanup();
					}
				}finally{
					n1.cleanup();
				}
			}
		}catch(InterruptedException e){
			System.out.println("Exiting via InterruptException");
		}
	};
	
}


