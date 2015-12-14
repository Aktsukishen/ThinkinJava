package com.chapter21.learning.l_210301_s;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 外界调用线程的cancle方法来中断线程
 * Future.cancle(true)只能中断抛出InterruptedException的线程
 * @author Administrator
 *
 */
public class Interrupting {
	
	private static ExecutorService exec=Executors.newCachedThreadPool();
	
	static void test(Runnable r) throws InterruptedException{
		Future<?> f=exec.submit(r);
		TimeUnit.SECONDS.sleep(10);
		System.out.println("Interrupting "+r.getClass().getName());
		f.cancel(true);
		System.out.println("Interrupt sent to "+r.getClass().getName());
	}

	public static void main(String[] args) throws Exception{
//		test(new SleepBlocked());
//		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Aborting with System.exit(0)");
		System.exit(0);
	}

}

/**
 * 抛出InterruptedException
 * @author Administrator
 *
 */
class SleepBlocked implements Runnable{
	public void run(){
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("SleepBlocked interrupted");
		}
		System.out.println("SleepBlocked.run exit()");
	}
}

/**
 * 中断IO操作失败
 * @author Administrator
 *
 */
class IOBlocked implements Runnable{
	private InputStream in;
	public IOBlocked(InputStream in){
		this.in=in;
	}
	public void run(){
		try{
			System.out.println("Wating for read():");
			in.read();
		}catch(IOException e){
			if(Thread.currentThread().isInterrupted()){
				System.out.println("IOBlocked interrupted");
			}else{
				System.out.println("not interrupted");
			}
		}
		System.out.println("Exiting IOBlocked.run()");
	}
}

/**
 * 
 * 中断获取锁的线程 失败
 * @author Administrator
 *
 */
class SynchronizedBlocked implements Runnable{
	public synchronized void f(){
		while(true) Thread.yield();
	}
	
	public SynchronizedBlocked(){
		new Thread(){
			public void run(){
				f();//一直获得对象锁
			}
		}.start();
	}
	
	public void run(){
		System.out.println("Try call f()");
		f();
		System.out.println("Exiting SynchronizedBlocked.run");
	}
}