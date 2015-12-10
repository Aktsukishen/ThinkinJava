package com.chapter21.learning.l_2103_s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.chapter21.learning.l_2102_s.LiftOff;

/**
 * 
 * 单线程执行器
 * @author li.shensong
 *
 */
public class SingleThreadExecutor {

	public static void main(String[] args) {
		ExecutorService exec=Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}

}
