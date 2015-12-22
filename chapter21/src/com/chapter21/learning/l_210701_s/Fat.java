package com.chapter21.learning.l_210701_s;

public class Fat {
	private volatile double d;
	private static int counter=0;
	private final int id=counter++;
	public Fat(){
		for(int i=1;i<1000;i++){
			d+=(Math.PI+Math.E)/i;//创建代价高昂的对象
		}
	}
	public void operation(){
		System.out.println(this);
	}
	public String toString(){
		return "Fat id:"+id;
	}
}
