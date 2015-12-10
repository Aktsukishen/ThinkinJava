package com.chapter21.learning.l_2104_s;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult implements Callable<String>{

	private int id;
	public TaskWithResult(int id) {
		this.id=id;
	}
	
	@Override
	public String call()  {
		System.out.println("Thread:"+Thread.currentThread().getName());
		return "result of TaskWithResult "+id;
	}
	
}

/**
 * 
 * 具有返回结果的线程
 * 
 *调用ExecutorService.sumbit(Callable<T>)将会另起一个线程执行并返回Future<T>
 * @author Administrator
 *
 */
public class CallableDemo {

	public static void main(String[] args) {
		ExecutorService exec=Executors.newFixedThreadPool(5);
		ArrayList<Future<String>> result=new ArrayList<Future<String>>();
		
		for(int i=0;i<10;i++){
			result.add(exec.submit(new TaskWithResult(i)));
		}
		
		for(int i=0;i<result.size();){
			Future<String> fs=result.get(i);
			try {
				if(fs.isDone()){
					System.out.println(fs.get());
					result.remove(i);
				}else{
					i=(i+1)%result.size();
				}
				
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			} catch (ExecutionException e) {
				System.out.println(e);
			}finally{
				exec.shutdown();
			}
		}
	}

}
