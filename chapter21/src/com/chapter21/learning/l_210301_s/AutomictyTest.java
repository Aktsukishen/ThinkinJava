package com.chapter21.learning.l_210301_s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AutomictyTest implements Runnable{
	private  int i;
	public int getValue(){//对于需要同步的数据，需要再每一个可能访问、修改数据的地方加上同步
		return i;
	}
	public  synchronized void eventIncrement(){
		i++;
		i++;
	}
	public void run(){
		while(true){
			eventIncrement();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();
		AutomictyTest at=new AutomictyTest();
		exec.execute(at);
		while(true){
			int val=at.getValue();
			if(val%2!=0){
				System.out.println(val);
				System.exit(0);;
			}
		}
	}

}
