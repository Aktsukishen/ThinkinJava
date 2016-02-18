package com.chapter19.learning.l_1902_s;

/**
 * 
 * 覆盖枚举的toString()方法
 * @author li.shensong
 *
 */
public enum SpaceShip {
	SCOUT,CARGO,TRANSPORT,CRUISER,BATTLESHIP,MOTHERSHIP;
	public String toString(){
	  String id=name();
	  String lower=id.substring(1).toLowerCase();
	  return id.charAt(0)+lower;
	}
	public static void main(String[]args){
		for(SpaceShip s:values()){
			System.out.println(s);
		}
	}
}
