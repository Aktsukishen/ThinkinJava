package com.chapter15.learning.l_1509_s;

import java.awt.Color;

interface HasColor{ java.awt.Color getColor();}

class Colored<T extends HasColor>{
	T item;
	public Colored(T item){ this.item=item;}
	T getItem(){ return item;}
	java.awt.Color getColor(){ return item.getColor();}
}

class Dimension{
	public int x,y,z;
}

//error, class must be first,then interface
//class ColoredDimensionError<T extends HasColor & Dimension>{
//	
//}

class ColoredDimension<T extends Dimension & HasColor>{//∂‡÷ÿ±ﬂΩÁ
	T item;
	public ColoredDimension(T item){ this.item=item;}
	java.awt.Color getColor(){ return item.getColor();}
	int getX(){ return item.x;}
	int getY(){ return item.y;}
	int getZ(){ return item.z;}
}

interface Weight{ int weight();}

class Solid<T extends Dimension & HasColor & Weight>{
	T item;
	public Solid(T item){ this.item=item;}
	java.awt.Color getColor(){ return item.getColor();}
	int getX(){ return item.x;}
	int getY(){ return item.y;}
	int getZ(){ return item.z;}
	int weight(){ return item.weight();}
}

class Bounds extends Dimension implements HasColor,Weight{
	@Override
	public int weight() {
		return 0;
	}
	@Override
	public Color getColor() {
		return null;
	}
}

public class BasicBounds {
	public static void main(String[]args){
		Solid<Bounds> solid=new Solid<Bounds>(new Bounds());
		solid.getColor();
		solid.getY();
		solid.weight();
	}
}
