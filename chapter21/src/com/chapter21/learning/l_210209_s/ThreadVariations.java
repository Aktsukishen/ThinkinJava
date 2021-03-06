package com.chapter21.learning.l_210209_s;

import java.util.concurrent.TimeUnit;

//直接使用内部具体线程
class InnerThread1{
	private int countDown=5;
	private Inner inner;
	
	public InnerThread1(String name){
		inner=new Inner(name);
	}
	
	private class Inner extends Thread{
		Inner(String name){
			super(name);
			start();
		}
		
		public void run(){
			try{
				while(true){
					System.out.println(this);
					if(--countDown==0) return;
					sleep(10);
				}
			}catch(InterruptedException e){
				System.out.println("interrupted");
			}
		}
		
		public String toString(){
			return getName()+"("+countDown+")";
		}
	}
}

//使用内部匿名线程
class InnerThread2{
	private int countDown=5;
	private Thread t;
	public InnerThread2(String name){
		t=new Thread(name){
			public void run(){
				try{
					while(true){
						System.out.println(this);
						if(--countDown==0) return;
						sleep(10);
					}
				}catch(InterruptedException e){
					System.out.println("sleep() interrupted");
				}
			}
			public String toString(){
				return getName()+"("+countDown+")";
			}
		};
		t.start();
	}
}

//使用内部接口实现类
class InnerRunnable1{
	private int countDown=5;
	private Inner inner;
	public InnerRunnable1(String name){
		inner=new Inner(name);
	}
	private class Inner implements Runnable{
		Thread t;
		Inner(String name){
			t=new Thread(this,name);
			t.start();
		}
		
		@Override
		public void run() {
			try{
				while(true){
					System.out.println(this);
					if(--countDown==0) return;
					TimeUnit.MILLISECONDS.sleep(10);
				}
			}catch(InterruptedException e){
				System.out.println("sleep() interrupted");
			}
		}
		
		public String toString(){
			return t.getName()+"("+countDown+")";
		}
	}
}

//使用内部匿名接口实现类
class InnerRunnable2{
	private int countDown=5;
	private Thread t;
	public InnerRunnable2(String name){
		t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try{
					while(true){
						System.out.println(this);
						if(--countDown==0) return;
						TimeUnit.MILLISECONDS.sleep(10);
					}
				}catch(InterruptedException e){
					System.out.println("sleep() interrupted");
				}
				
			}
			
			public String toString(){
				return Thread.currentThread().getName()+"("+countDown+")";
			}
		});
		t.start();
	}
}

class ThreadMethod{
	private int countDown=5;
	private Thread t;
	private String name;
	public ThreadMethod(String name){ this.name=name;}
	public void runTask(){
		if(t==null){
			t=new Thread(name){
				public void run(){
					try{
						while(true){
							System.out.println(this);
							if(--countDown==0) return;
							TimeUnit.MILLISECONDS.sleep(10);
						}
					}catch(InterruptedException e){
						System.out.println("sleep() interrupted");
					}
				}
			};
			t.start();
		}
	}
}


public class ThreadVariations {

	public static void main(String[] args) {
		new InnerThread1("InnerThread1");
		new InnerThread2("InnerThread2");
		new InnerRunnable1("InnerRunnable1");
		new InnerRunnable2("InnerRunnable2");
		new ThreadMethod("ThreadMethod").runTask();
	}

}
