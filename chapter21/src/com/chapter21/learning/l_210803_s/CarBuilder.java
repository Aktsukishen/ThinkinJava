package com.chapter21.learning.l_210803_s;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Car{
	private final int id;
	private boolean engine=false,driveTrain=false,wheels=false;
	public Car(int idn){
		this.id=idn;
	}
	public Car(){
		this.id=-1;
	}
	public synchronized int getId(){
		return id;
	}
	public synchronized void addEgine(){
		this.engine=true;
	}
	public synchronized void addDriveTrain(){
		this.driveTrain=true;
	}
	public synchronized void addWheels(){
		this.wheels=true;
	}
	public synchronized String toString(){
		return "Car "+id+" ["+" engine:"+engine+" drivenTrain:"+driveTrain+" wheels:"+wheels+" ]";
	}
}

class CarQueue extends LinkedBlockingQueue<Car>{}

class ChassisBuilder implements Runnable{
	private  CarQueue carQueue;
	private int counter=0;
	public ChassisBuilder(CarQueue cq){
		this.carQueue=cq;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				TimeUnit.MILLISECONDS.sleep(500);
				Car car=new Car(counter++);
				System.out.println("ChassisBuilder created "+car);
				this.carQueue.put(car);
			}
		}catch(InterruptedException e){
			System.out.println("Interrupted:ChassisBuilder");
		}
		System.out.println("ChassisBuilder Off");
	}
}

class Assembler implements Runnable{
	private CarQueue chassisQueue,finishQueue;
	private Car car;
	private CyclicBarrier barrier=new CyclicBarrier(4);
	private RobotPool robotPool;
	public Assembler(CarQueue cq,CarQueue fq,RobotPool rp){
		this.chassisQueue=cq;
		this.finishQueue=fq;
		this.robotPool=rp;
	}
	public Car car(){ return car;}
	public CyclicBarrier barrier(){ return barrier;}
	public void run(){
		try{
			while(!Thread.interrupted()){
				//阻塞直至其可用
				car=chassisQueue.take();
				
				robotPool.hire(EngineRobot.class, this);
				robotPool.hire(DriveTrainRobot.class, this);
				robotPool.hire(WheelRobot.class, this);
				
				barrier.await();
				finishQueue.add(car);
			}
		}catch(InterruptedException e){
			System.out.println("Exiting Assembler via interrupt");
		}catch (BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Assembler off");
	}
}

class Reporter implements Runnable{
	private CarQueue carQueue;
	public Reporter(CarQueue cq){
		carQueue=cq;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				System.out.println(carQueue.take());
			}
		}catch(InterruptedException e){
			System.out.println("Exiting Reporter via interrupt");
		}
		System.out.println("Reporter off");
	}
}

abstract class Robot implements Runnable{
	private RobotPool pool;
	public Robot(RobotPool rp){
		this.pool=rp;
	}
	protected Assembler assembler;
	public Robot assignAssembler(Assembler assembler){
		this.assembler=assembler;
		return this;
	}
	public boolean engage=false;
	public synchronized void engage(){
		engage=true;
		notifyAll();
	}
	abstract protected void performService();
	public void run(){
		try{
			powerDown();
			while(!Thread.interrupted()){
				performService();
				assembler.barrier().await();
				powerDown();
			}
		}catch(InterruptedException e){
			System.out.println("Exiting "+this+" via interrupt");
		}catch(BrokenBarrierException e){
			throw new RuntimeException(e);
		}
		System.out.println(this+" off");
	}
	private synchronized void powerDown() throws InterruptedException{
		engage=false;
		assembler=null;
		pool.release(this);
		while(engage==false){
			wait();
		}
	}
	public String toString(){
		return this.getClass().getSimpleName();
	}
}

class EngineRobot extends Robot{
	public EngineRobot(RobotPool pool){
		super(pool);
	}
	protected void performService(){
		System.out.println(this+" installing engine");
		assembler.car().addEgine();
	}
}

class DriveTrainRobot extends Robot{
	public DriveTrainRobot(RobotPool pool){
		super(pool);
	}
	protected void performService(){
		System.out.println(this+" installing DriveTrain");
		assembler.car().addDriveTrain();
	}
}

class WheelRobot extends Robot{
	public WheelRobot(RobotPool pool){
		super(pool);
	}
	protected void performService(){
		System.out.println(this+" installing Wheel");
		assembler.car().addWheels();
	}
}

class RobotPool{
	private Set<Robot> pool=new HashSet<Robot>();
	public synchronized void add(Robot r){
		pool.add(r);
		notifyAll();
	}
	public synchronized void hire(Class<? extends Robot> robotType,Assembler d) throws InterruptedException{
		for(Robot r:pool){
			if(r.getClass().equals(robotType)){
				pool.remove(r);
				r.assignAssembler(d);
				r.engage();
				return;
			}
		}
		wait();
		hire(robotType,d);
	}
	public synchronized void release(Robot r){
		add(r);
	}
}

public class CarBuilder {

	public static void main(String[] args) throws InterruptedException {
		CarQueue chassisQueue=new CarQueue();
		CarQueue finishQueue=new CarQueue();
		ExecutorService  exec=Executors.newCachedThreadPool();
		RobotPool pool=new RobotPool();
		exec.execute(new EngineRobot(pool));
		exec.execute(new DriveTrainRobot(pool));
		exec.execute(new WheelRobot(pool));
		exec.execute(new Assembler(chassisQueue, finishQueue, pool));
		exec.execute(new Reporter(finishQueue));
		exec.execute(new ChassisBuilder(chassisQueue));
		TimeUnit.SECONDS.sleep(7);
		exec.shutdownNow();
	}

}
