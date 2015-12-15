package com.chapter21.learning.l_210301_s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * synchronized申明:即调用后续的操作需要获得对象的同步锁
 * 对于正常的没有被synchronized标记的操作则表明其不需要获得同步锁即可操作
 * @author li.shensong
 *
 */
class Task{
	public void f(){
		synchronized (this) {
			try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println("f() stop");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void g(){
			System.out.println("g() stop");
	}
}

public class SynchronizedTest {
	public static void main(String[]args) throws InterruptedException{
		ExecutorService exec=Executors.newCachedThreadPool();
		Task task=new Task();
		exec.execute(new Runnable() {
			
			@Override
			public void run() {
				task.f();
			}
		});
		TimeUnit.SECONDS.sleep(2);
		exec.execute(new Runnable(){

			@Override
			public void run() {
				task.g();
			}
			
		});
		System.out.println("Main Stop");
	}
}
