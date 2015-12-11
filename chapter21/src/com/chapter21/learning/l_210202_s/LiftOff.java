package com.chapter21.learning.l_210202_s;

/**
 * 
 * Runnable 任务接口
 * 
 * @author li.shensong
 *
 */
public class LiftOff implements Runnable{
	protected int countDown=10;
	private static int taskCount=1;
	private final int id=taskCount++;
	public LiftOff(){}
	public LiftOff(int countDown){
		this.countDown=countDown;
	}
	
	public String status(){
		return "#"+id+"("+(countDown>0?countDown:"LiftOff!")+"),";
	}

	@Override
	public void run() {
		while(countDown-->0){
			System.out.print(status());
			//对线程调度器的一种建议：可以将CPU从一个线程转移到另外一个线程
			//它在声明：我已经执行完生命周期中最重要的一部分了，此刻正是切换到其他任务执行一段时间的大好时机
			//它不是确定性的，完全是选择性的
			Thread.yield();
		}
	}

}
