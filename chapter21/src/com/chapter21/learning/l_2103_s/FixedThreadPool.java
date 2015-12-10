package com.chapter21.learning.l_2103_s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.chapter21.learning.l_2102_s.LiftOff;

/**
 * 
 * 固定个数的线程执行器
 * 一次性创建多个线程变量  超过的等之前的线程执行完进行复用
 * @author li.shensong
 *
 */
public class FixedThreadPool {

	public static void main(String[] args) {
		ExecutorService exec=Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}

}
