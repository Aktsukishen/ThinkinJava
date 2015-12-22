package com.chapter21.learning.l_210701_s;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Pool<T> {
	private int size;
	private List<T> items=new ArrayList<T>();
	private volatile boolean[] checkedOut;
	private Semaphore avaiable;
	public Pool(Class<T> classObject,int size){
		this.size=size;
		checkedOut=new boolean[size];
		avaiable=new Semaphore(size, true);
		for(int i=0;i<size;i++){
			try{
				items.add(classObject.newInstance());
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
	}
	public T checkOut() throws InterruptedException{
		avaiable.acquire();
		return getItem();
	}
	public void checkIn(T x){
		if(releaseItem(x)){
			avaiable.release();
		}
	}
	
	private synchronized T getItem(){
		for(int i=0;i<size;i++){
			if(!checkedOut[i]){
				checkedOut[i]=true;
				return items.get(i);
			}
		}
		return null;
	}
	
	private synchronized boolean releaseItem(T item){
		int index=items.indexOf(item);
		if(index==-1) return false;
		if(checkedOut[index]){
			checkedOut[index]=false;
			return true;
		}
		return false;
	}
}
