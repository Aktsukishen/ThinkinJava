package com.chapter17.learning.l_1709_s;

/**
 * 
 * 如果需要使用自己的类作为HashMap的键，必须同时重载hashCode()和equals();
 * @author li.shensong
 *
 */
public class Groundhog2 extends Groundhog{

	public Groundhog2(int i) {
		super(i);
	}
	@Override
	public int hashCode(){
		return number;
	}
	public boolean equals(Object o){
		return o instanceof Groundhog2 && number==((Groundhog2)o).number;
	}
	
	public static void main(String[]args) throws Exception{
		SpringDetector.detectSpring(Groundhog2.class);
	}
}
