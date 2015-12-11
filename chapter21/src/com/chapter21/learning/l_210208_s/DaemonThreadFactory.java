package com.chapter21.learning.l_210208_s;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable task) {
		Thread t=new Thread(task);
		t.setDaemon(true);
		return t;
	}

}
