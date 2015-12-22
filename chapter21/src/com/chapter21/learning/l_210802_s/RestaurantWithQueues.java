package com.chapter21.learning.l_210802_s;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

class Order{
	private static int counter=0;
	private final int id=counter++;
	private final Customer customer;
	private final WaitPerson waitPerson;
	private final Food food;
	public Order(Customer cust,WaitPerson wp,Food f){
		this.customer=cust;
		this.waitPerson=wp;
		this.food=f;
	}
	public Food item(){
		return food;
	}
	public Customer getCustomer(){
		return customer;
	}
	public WaitPerson getWaitPerson(){
		return waitPerson;
	}
	publlic String toString(){
		return "Order: "+id+" item:"+food+" for:"+cumstomer+" servered by:"+waitPerson;
	}
}

class Plate{
	private final Order order;
	private final Food food;
	public Plate(Order order,Food f){
		this.orde=order;
		this.food=f;
	}
	public Order getOrder(){
		return order;
	}
	public Food getFood(){
		return food;
	}
	public String toString(){
		return food.toString();
	}
}

class Customer implements Runnable{
	private static int counter=0;
	private final int id=counter++;
	private final WaitPerson waitPerson;
	private SynchronousQueue<Plate> placeSetting=new SynchronousQueue<>();
	public Customer(WaitPerson w){
		this.waitPerson=w;
	}
	public void deliver(Plate p){
		placeSetting.put(p);
	}
	public void run(){
		for(Course course:Course.values()){
			Food food=course.randomSelection();
			try{
				waitPerson.placeOrder(this,food);
				System.out.println(this+" eating "+placeSetting.take());
			}catch(InterruptedException e){
				System.out.println(this+" wating for "+course+" interrupted");
				break;
			}
		}
		System.out.println(this+ " finish meal,leaving");
	}
	public String toString(){
		return "Customer "+id;
	}
}

class WaitPerson implements Runnable{
	private static int counter=0;
	private final int id=counter++;
	private final Restaurant restaurant;
	BlockingQueue<Plate> filledOrders=new LinkedBlockingQueue<>();
	public WaitPerson(Restaurant rest){
		this.restaurant=rest;
	}
	public void placeOrder(Customer cust,Food food){
		try{
			restaurant.orders.put(new Order(cust,this,food));
		}catch(InterruptedException e){
			System.out.println(this+" placeOrder interrupted");
		}
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				Plate plate=filledOrders.take();
				System.out.println(this+" received "+plate+" delivering to"+plate.getFood().getCustomer());
				plate.getOrder().getCustomer().deliver(plate);
			}
		}catch(InterruptedException e){
			System.out.println(this+" interrupted");
		}
		System.out.println(this+" off duty");
	}
	public String toString(){
		return "WaitPerson "+id;
	}
}

class Chef implements Runnable{
	private static int counter=0;
	private final int id=counter++;
	private final Restaurant restaurant;
	private static Random rand=new Random(47);
	public Chef(Restaurant rest){
		this.restaurant=rest;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				Order order=restaurant.orders.taker();
				Food reuqestItem=order.item();
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				Plate plate=new Plate(order,requetedItem);
				order.getWaitPerson().filledOrders.put(plate);
			}
		}catch(InterruptedException e){
			System.out.println(this+" interrupted");
		}
		System.out.println(this+" off duty");
	}
	public String toString(){
		return "Chef "+id;
	}
}

class Restaurant implements Runnable{
	private List<WaitPerson> waitPersons=new ArrayList<WaitPerson>();
	private List<Chef> chefs=new ArrayList<Chef>();
	private ExecutorService exec;
	private static Random rand=new Random(47);
	BlockingQueue<Order> orders=new LinkedBlockingQueue<>();
	public Restaurant(ExecutorService exec,int nWaitPersons,int nChefs){
		this.exec=exec;
		for(int i=0;i<nWaitPersons;i++){
			WaitPerson waitPerson=new WaitPerson(this);
			waitPersons.add(waitPerson);
			exec.execute(waitPerson);
		}
		for(int i=0;i<nChefs;i++){
			Chef chef=new Chef(this);
			chefs.add(chef);
			exec.execute(chef);
		}
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				WaitPerson wp=waitPersons.get(rand.nextInt(waitPersons.size()));
				Customer c=new Customer(wp);
				exec.execute(c);
				TimeUnit.MILLISECONDS.sleep(100);
			}
		}catch(InterruptedException e){
			System.out.println("Restaurant interrupted");
		}
		System.out.println("Restaurant closing");
	}
} 

public class RestaurantWithQueues {

	public static void main(String[] args) {

	}

}
