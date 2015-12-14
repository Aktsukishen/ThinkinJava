package com.chapter21.learning.l_210301_s;

public class SerialNumberGenerator {
	private  static volatile int serialNumber=0;
	public static synchronized int nextSerialNumber(){
		return serialNumber++;//自增不是原子性的，也就是说可能同时有几个线程进行此操作
	}
}	
