package com.chapter21.learning.l_210701_s;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Horse implements Runnable{
	private static int counter=0;
	private final int id=counter++;
	private  int strides=0;
	private static Random rand=new Random(47);
	private  CyclicBarrier barrier;
	public Horse(CyclicBarrier b){
		barrier=b;
	}
	public synchronized int getStides(){
		return strides;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				synchronized (this) {
					strides+=rand.nextInt(3);//跑几步
				}
				barrier.await();//等着下一次出发的命令
			}
		}catch(InterruptedException e){
			
		}catch(BrokenBarrierException e){
			throw new RuntimeException(e);
		}
	}
	public String toString(){
		return "Horse "+id+" ";
	}
	public String tracks(){
		StringBuilder s=new StringBuilder();
		for(int i=0;i<getStides();i++)
			s.append("*");
		s.append(id);
		return s.toString();
	}
}


public class HorseRace {
	static final int FINISH_LINE=75;
	private List<Horse> horses=new ArrayList<Horse>();
	private ExecutorService exec=Executors.newCachedThreadPool();
	private CyclicBarrier barrier;
	public HorseRace(int nHorses,final int pause){
		barrier=new CyclicBarrier(nHorses, new Runnable(){
			public void run(){
				StringBuilder s=new StringBuilder();
				for(int i=0;i<FINISH_LINE;i++){
					s.append("=");
				}
				System.out.println(s);
				for(Horse horse:horses){
					System.out.println(horse.tracks());
				}
				for(Horse horse:horses){
					if(horse.getStides()>=FINISH_LINE){
						System.out.println(horse+" won!");
						exec.shutdownNow();
						return;
					}
				}
				try{
					TimeUnit.MILLISECONDS.sleep(pause);
				}catch(InterruptedException e){
					System.out.println("barrier-action sleep interrupted");
				}
			}
		});
		for(int i=0;i<nHorses;i++){
			Horse horse=new Horse(barrier);
			horses.add(horse);
			exec.execute(horse);
		}
	}

	public static void main(String[] args) {
		int nHorses=7;
		int pause=200;
		if(args.length>0){
			int n=new Integer(args[0]);
			nHorses=n>0?n:nHorses;
		}
		if(args.length>1){
			int p=new Integer(args[1]);
			pause=p>0?p:pause;
		}
		new HorseRace(nHorses,pause);
	}

}
