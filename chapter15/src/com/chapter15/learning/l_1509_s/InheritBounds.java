package com.chapter15.learning.l_1509_s;

class HoldItem<T>{
	T item;
	HoldItem(T item){ this.item=item;}
	T getItem(){ return item;}
}

class Colored2<T extends HasColor> extends HoldItem<T>{
	Colored2(T item) {
		super(item);
	}
	java.awt.Color getColor(){ return  item.getColor();}
}

class ColoredDemision2<T extends Dimension & HasColor> extends Colored2<T>{
	ColoredDemision2(T item) {
		super(item);
	}
	int getX(){ return item.x;}
	int getY(){ return item.y;}
	int getZ(){ return item.z;}
}

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDemision2<T>{
	Solid2(T item) {
		super(item);
	}
	int getWeight(){ return item.weight();}
}

public class InheritBounds {

	public static void main(String[] args) {
		Solid2<Bounds> solid2=new Solid2<Bounds>(new Bounds());
		solid2.getX();
		solid2.getWeight();
		solid2.getColor();
	}

}
