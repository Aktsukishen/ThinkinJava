package com.chapter19.learning.l_1902_s;

/**
 * 
 * 在定义枚举类的方法之前必须先申明其实例
 * 枚举类的构造器必须是包访问权限或者是private权限
 * @author li.shensong
 *
 */
public enum OzWitch {
	//Instances must be defined first,before methods:
	WEST("Miss Gulch,aka the Wicked Witch of the West"),
	NORTH("Glinda,the Good Witch of the North"),
	EAST("Wicked Witch of the East,wearer of the Ruby Slippers,crushed by Dorothy's house"),
	SOUTH("Good by inference,but missing")
	;
	private String description;
	//Constructor must be package or private access:
	private OzWitch(String description){
		this.description=description;
	}
	public String getDescription(){
		return this.description;
	}
	public static void main(String[]args){
		for(OzWitch witch:OzWitch.values()){
			System.out.println(witch+" "+witch.getDescription());
		}
	}
}
