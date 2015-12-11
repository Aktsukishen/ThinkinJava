package com.chapter21.learning.l_210211_s;


class Sleeper extends Thread{
	private int duration;
	public Sleeper(String name,int sleepTime){
		super(name);
		duration=sleepTime;
		start();
	}
	public void run(){
		try{
			sleep(duration);
		}catch(InterruptedException e){
			System.out.println(getName()+" was interrupted. isInterrupted():"+isInterrupted());
			return;
		}
		System.out.println(getName()+" has awaked");
	}
}

class Joiner extends Thread{
	private Sleeper sleeper;
	public Joiner(String name,Sleeper sleeper){
		super(name);
		this.sleeper=sleeper;
		start();
	}
	public void run(){
		try{
			sleeper.join();
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}
		System.out.println(getName()+" join completed");
	}
}

/**
 * 线程的插入执行： 在线程t1中执行t2.join(),那么t1将会暂停执行，相当于在t1线程中插入t2线程，等待t2线程执行完成，t1线程再继续往下执行
 * 如果t2在执行的过程中被中断了，那么t1将立即执行；
 * 如果t1在等待t2执行完的过程中被中断了，那么t2执行完后不再继续执行t1
 * @author li.shensong
 *
 */
public class Joining {

	public static void main(String[] args){
		Sleeper sleepy=new Sleeper("Sleepy", 1500),
				grumpy=new Sleeper("Grumpy", 1500);
		Joiner dopey=new Joiner("Dopey", sleepy),
				doc=new Joiner("Doc", grumpy);
		grumpy.interrupt();
	}

}
