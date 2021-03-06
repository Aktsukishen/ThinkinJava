package com.chapter21.learning.l_210301_s;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CloseResource {
	
	public static void main(String[] args) throws Exception{
		ExecutorService exec=Executors.newCachedThreadPool();
		ServerSocket server=new ServerSocket(8080);
		InputStream socketInput=new Socket("localhost", 8080).getInputStream();
		exec.execute(new IOBlocked(socketInput));
		exec.execute(new IOBlocked(System.in));
		TimeUnit.SECONDS.sleep(2);
		System.out.println("Shutting down all threads");
		exec.shutdownNow();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Close socketInputStream");
		socketInput.close();
		TimeUnit.SECONDS.sleep(5);
		System.in.close();
		System.out.println("Close the System.in");
	}

}
