package com.chapter19.learning.l_1907_s;

import com.chapter19.learning.l_1906_s.Enums;

public enum Course {
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCource.class),
	DESERT(Food.Desert.class),
	COFFEE(Food.Coffee.class);
	private Food[] values;
	private Course(Class<? extends Food> kind){
		values=kind.getEnumConstants();
	}
	public Food randomSelection(){
		return Enums.random(values);
	}
}
