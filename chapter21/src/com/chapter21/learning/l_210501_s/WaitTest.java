package com.chapter21.learning.l_210501_s;

import java.util.concurrent.TimeUnit;

public class WaitTest {

	public static void main(String[] args) throws InterruptedException {
		Object sysncObject=new Object();
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("wait Start:"+System.currentTimeMillis());
					synchronized (sysncObject) {
						sysncObject.wait();//只能在锁对象上调用wait方法，否则会报错
					}
					System.out.println("wait End:  "+System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		TimeUnit.SECONDS.sleep(5);
		synchronized (sysncObject) {
			System.out.println("NotifyAll");
			sysncObject.notifyAll();
		}
	}

}
