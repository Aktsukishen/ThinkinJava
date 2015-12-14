package com.chapter21.learning.l_210301_s;

class DualSynch{
	private Object syncObject=new Object();
	public synchronized void f(){
		for(int i=0;i<5;i++){
			System.out.println("f()");
			Thread.yield();
		}
	}
	public void g(){
		synchronized (syncObject) {
			for(int i=0;i<5;i++){
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
}

/**
 * 
 * 两个不同锁的线程并不影响各自的运行
 * @author li.shensong
 *
 */
public class SyncObject {

	public static void main(String[] args) {
		final DualSynch ds=new DualSynch();
		new Thread(){
			public void run(){
				ds.f();
			}
		}.start();
		ds.g();
	}

}
