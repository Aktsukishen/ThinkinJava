package com.chapter21.learning.l_210203_s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.chapter21.learning.l_210202_s.LiftOff;

/**
 * 
 * 不是一次性创建所有线程 
 * 先看有无可用线程 没有的话创建线程
 * @author li.shensong
 *
 */
public class CachedThreadPool {

	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}

}
