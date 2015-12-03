package com.chapter05.learning.l_0505_s;

class Book{
	boolean checkOut=false;
	Book(boolean checkout){
		this.checkOut=checkout;
	}
	void checkIn(){
		checkOut=false;
	}
	@Override
	protected void finalize(){
		if(checkOut){
			System.out.println("Error:checkout");
		}
	}
}

class Medicine{
	
	public void test(){
		finalize();
	}
	@Override
	protected void finalize(){
			System.out.println("Medicine finalize()");
	}
}

public class TerminationCondition {

	public static void main(String[] args) {
		Book novel=new Book(true);
		novel.checkIn();
		new Book(true);
		Medicine med=new Medicine();
		med.test();
//		System.gc();
	}

}
