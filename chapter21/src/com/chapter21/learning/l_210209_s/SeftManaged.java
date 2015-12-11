package com.chapter21.learning.l_210209_s;

/**
 * 
 * 通过创建内部线程来调用自身的接口方法
 * 缺点：语法晦涩    优点：可以继承其他类
 * @author li.shensong
 *
 */
public class SeftManaged implements Runnable {
	private int countDown=5;
	private Thread t=new Thread(this);
	public SeftManaged() {
		t.start();
	}
	public String toString(){
		return Thread.currentThread().getName() +"("+countDown+")";
	}
	
	@Override
	public void run() {
		while(true){
			System.out.println(this);
			if(--countDown==0) return ;
		}
	}

	public static void main(String[] args) {
		for(int i=0;i<5;i++) new SeftManaged();
	}

}
