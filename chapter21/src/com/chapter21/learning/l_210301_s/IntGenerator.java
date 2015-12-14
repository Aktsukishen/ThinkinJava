package com.chapter21.learning.l_210301_s;

/**
 * 
 * 整数生产者
 * @author li.shensong
 *
 */
public abstract class IntGenerator {
	private volatile boolean cancled = false;

	public abstract int next();

	public void cancle() {
		cancled = true;
	}
	
	public boolean isCancled(){ 
		return cancled;
	}
}
