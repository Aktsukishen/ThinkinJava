package com.chapter15.learning.l_1502_s;

class Automobile{}

/**
 * 
 * 这个类的可重用性太差，无法持有其他类型的任何对象
 * @author li.shensong
 *
 */
public class Holder1 {
	private Automobile a;
	public Holder1(Automobile a){this.a=a;}
	private Automobile get(){ return a;}
}
