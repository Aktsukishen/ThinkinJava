package com.chapter21.learning.l_210501_s;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Toast{
	public enum Status{DRY,BUTTED,JAMMED}
	private Status status=Status.DRY;
	private final int id;
	public Toast(int idn){
		this.id=idn;
	}
	public void butter(){
		status=Status.BUTTED;
	}
	public void jam(){
		status=Status.JAMMED;
	}
	public Status getStatus(){
		return status;
	}
	public int getId(){
		return id;
	}
	public String toString(){
		return "Toast "+id+":"+status;
	}
}

class ToastQueue extends LinkedBlockingQueue<Toast>{}

class Toaster implements Runnable{
	private ToastQueue toastQueue;
	private int count=0;
	private Random rand=new Random(47);
	public Toaster(ToastQueue tq){
		this.toastQueue=tq;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				TimeUnit.MILLISECONDS.sleep(100+rand.nextInt(500));
				Toast t=new Toast(count++);
				System.out.println(t);
				toastQueue.put(t);
			}
		}catch(InterruptedException e){
			System.out.println("Toaster interrupted");
		}
		System.out.println("Toast Off");
	}
}

class Butterer implements Runnable{
	private ToastQueue dryQueue,butterQueue;
	public Butterer(ToastQueue dry,ToastQueue buttered){
		dryQueue=dry;
		butterQueue=buttered;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				Toast t=dryQueue.take();//如果队列为空 那么此时会被挂起阻塞，直至队列中有元素进入，而且取元素时按FIFO的原则进行
				t.butter();
				System.out.println(t);
				butterQueue.put(t);
			}
		}catch(InterruptedException e){
			System.out.println("Buttered interrupted");
		}
	}
}

class Jammer implements Runnable{
	private ToastQueue butteredQueue,finishQueue;
	public Jammer(ToastQueue butteredQueue,ToastQueue finishQueue){
		this.butteredQueue=butteredQueue;
		this.finishQueue=finishQueue;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				Toast t=butteredQueue.take();
				t.jam();
				System.out.println(t);
				finishQueue.put(t);
			}
		}catch(InterruptedException e){
			System.out.println("Jammer interrupt");
		}
		System.out.println("Jammer off");
	}
}

class Eater implements Runnable{
	private ToastQueue finishedQueue;
	private int counter=0;
	public Eater(ToastQueue finishQueue){
		this.finishedQueue=finishQueue;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				Toast t=finishedQueue.take();
				if(t.getId()!=counter++ || t.getStatus()!=Toast.Status.JAMMED){
					System.out.println(">>>> Error:"+t);
					System.exit(1);
				}else{
					System.out.println("Chomp! "+t);
				}
			}
		}catch(InterruptedException e){
			System.out.println("Eater interrupted");
		}
		System.out.println("Eat off");
	}
}

public class ToastOMatic {

	public static void main(String[] args) throws InterruptedException {
		ToastQueue dryQueue=new ToastQueue(),
				butterQueue=new ToastQueue(),
				finishQueue=new ToastQueue();
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue,butterQueue));
		exec.execute(new Jammer(butterQueue,finishQueue));
		exec.execute(new Eater(finishQueue));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}

}
