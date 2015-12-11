package com.chapter21.learning.l_210214_s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 线程抛出的异常在其他线程不好捕获
 * @author li.shensong
 *
 */
public class ExceptionThread implements Runnable{

	public void run(){
		throw new RuntimeException();
	}
	
	public static void main(String[]args){
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute( new ExceptionThread());
	}
}
