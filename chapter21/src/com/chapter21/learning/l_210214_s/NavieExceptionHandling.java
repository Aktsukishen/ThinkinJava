package com.chapter21.learning.l_210214_s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程异常捕获
 * @author li.shensong
 *
 */
public class NavieExceptionHandling {

	public static void main(String[] args) {
		try{
			ExecutorService exec=Executors.newCachedThreadPool();
			exec.execute(new ExceptionThread());
		}catch(RuntimeException e){
			System.out.println("catch exception");
		}
		
	}

}
