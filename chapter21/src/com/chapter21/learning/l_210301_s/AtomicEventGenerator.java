package com.chapter21.learning.l_210301_s;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEventGenerator extends IntGenerator {
	//虽然依赖Atomic类可以保证原子性
	//但通常使用synchronized或者显式的lock会更安全一些
	private AtomicInteger currentValue=new AtomicInteger(0);
	
	@Override
	public int next() {
		return currentValue.addAndGet(2);
	}

	public static void main(String[] args) {
		EventChecker.test(new AtomicEventGenerator());
	}

}
