package com.chapter21.learning.l_210701_s;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

interface Generator<T> {
	T next();
}

class BasicGenerator<T> implements Generator<T> {
	
	//T 表明是哪个类的Class
	private Class<T> type;
	
	public BasicGenerator(Class<T> type) {
	     this.type=type;
	}
	
	@Override
	public T next() {
		try{
			return type.newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

	public static  <T> Generator<T> create(Class<T> type){
		return new BasicGenerator<>(type);
	}
	
}

class ExchangeProducer<T> implements Runnable{
	private Generator<T> generator;
	private Exchanger<List<T>> exchanger;
	private List<T> holder;
	private volatile T value;
	public ExchangeProducer(Exchanger<List<T>> exchg,Generator<T> gen,List<T> holder) {
		this.exchanger=exchg;
		this.generator=gen;
		this.holder=holder;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				for(int i=0;i<ExchangeDemo.size;i++){
					holder.add(generator.next());
				}
				holder=exchanger.exchange(holder);
			}
		}catch(Exception e){
		}
		System.out.println("Final value:"+value);
	}
}

class ExchangerConsumer<T> implements Runnable{
	private Exchanger<List<T>> exchanger;
	private List<T> holder;
	private volatile T value;
	public ExchangerConsumer(Exchanger<List<T>> ex,List<T> holder) {
		this.exchanger=ex;
		this.holder=holder;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				holder=exchanger.exchange(holder);
				for(T x:holder){
					value=x;
					holder.remove(x);
				}
			}
		}catch(InterruptedException e){
			
		}
		System.out.println("Final value: "+value);
	}
}


public class ExchangeDemo {
	static int size = 10;
	static int delay = 5;
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec=Executors.newCachedThreadPool();
		Exchanger<List<Fat>> xc=new Exchanger<List<Fat>>();
		List<Fat> produerList=new CopyOnWriteArrayList<Fat>();
		List<Fat> consumerList=new CopyOnWriteArrayList<Fat>();
		exec.execute(new ExchangeProducer<Fat>(xc,BasicGenerator.create(Fat.class),produerList));
		exec.execute(new ExchangerConsumer<Fat>(xc,consumerList));
		TimeUnit.SECONDS.sleep(delay);
		exec.shutdownNow();
	}

}
