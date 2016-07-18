package com.chapter21.learning.l_2102_t;

public class FibonacciRunnable implements Runnable{
	private int n;
	StringBuilder sb = new StringBuilder();
	public FibonacciRunnable(int n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		int temp ;
		int a1 = 1;
		int a2 = 1;
		
		for(int i = 1; i <= n ; i ++){
			if(i==1){
				sb.append(1+" ");
				a1 = 1;
				continue;
			}
			if(i==2){
				sb.append(1+" ");
				a2 = 1;
				continue;
			}else if(n>2){
				temp = a1 + a2;
				a1 = a2;
				a2 = temp;
				sb.append(a2 + " ");
			}
			
		}
		System.out.println("Fibonacci " + n + " result:" + sb.toString());
	}

}
