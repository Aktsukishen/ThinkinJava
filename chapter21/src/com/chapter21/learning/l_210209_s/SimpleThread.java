package com.chapter21.learning.l_210209_s;

/**
 * 
 * 通过继承直接调用线程
 * 优点：明了  缺点：占用继承类
 * 在此类中直接调用start()会调用自身的run()方法
 * @author li.shensong
 *
 */
public class SimpleThread extends Thread {
	
	private int countDown=5;
	private static int threadCount=0;
	public SimpleThread(){
		super(Integer.toString(++threadCount));
		start();
	}
	@Override
	public String toString(){
		return "#"+getName()+" ("+countDown+")";
	}
	
	public void run(){
		while(true){
			System.out.println(this);
			if(--countDown==0) return;
		}
	}

	public static void main(String[] args) {
		for(int i=0;i<5;i++)
			new SimpleThread();
	}

}
