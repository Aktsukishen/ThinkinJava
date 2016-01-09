package com.chapter18.learning.l_1812_s;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Shape implements Serializable{
	public static  final int RED=1,BLUE=2,GREEN=3;
	private int xPos,yPos,dimension;
	private static Random random=new Random(47);
	private static int counter=0;
	public abstract void setColor(int newColor);
	public abstract int  getColor();
	public Shape(int xVal,int yVal,int dim){
		xPos=xVal;
		yPos=yVal;
		dimension=dim;
	}
	public String toString(){
		return getClass()+"color["+getColor()+"] xPos["+xPos+"] yPos["+yPos+"] dim["+dimension+"]\n";
	}
	public static Shape randomFactory(){
		int xVal=random.nextInt();
		int yVal=random.nextInt();
		int dim=random.nextInt();
		switch(counter++%3){
		default:
		case 0:return new Circle(xVal,yVal,dim);
		case 1:return new Square(xVal,yVal,dim);
		case 2:return new Line(xVal,yVal,dim);
		}
	}
}

class Circle extends Shape{
	private static int color=RED;
	public Circle(int xVal,int yVal,int dim){
		super(xVal,yVal,dim);
	}
	public void setColor(int newColor){
		color=newColor;
	}
	public int getColor(){
		return color;
	}
}

class Square extends Shape{
	private static int color;
	public Square(int xVal,int yVal,int dim){
		super(xVal,yVal,dim);
		color=RED;
	}
	public void setColor(int newColor){
		this.color=newColor;
	}
	public int getColor(){
		return this.color;
	}
}

class Line extends Shape{
	private static int color=RED;
	public static void seralizeStaticState(ObjectOutputStream os) throws IOException{
		os.writeInt(color);
	}
	public static void deserializeStaticState(ObjectInputStream in) throws IOException{
		color=in.readInt();
	}
	public Line(int xVal,int yVal, int dim){
		super(xVal,yVal,dim);
	}
	public void setColor(int newColor){
		color=newColor;
	}
	public int getColor(){
		return color;
	}
}

public class StoreCADState {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Class<? extends Shape>> shapeTypes=new ArrayList<Class<? extends Shape>>();
		shapeTypes.add(Circle.class);
		shapeTypes.add(Square.class);
		shapeTypes.add(Line.class);
		
		List<Shape> shapes=new ArrayList<Shape>();
		for(int i=0;i<10;i++){
			shapes.add(Shape.randomFactory());
		}
		
		for(int i=0;i<10;i++){
			((Shape)shapes.get(i)).setColor(Shape.GREEN);
		}
		
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("resource/StoreCADState.txt"));
		out.writeObject(shapeTypes);
		Line.seralizeStaticState(out);
		out.writeObject(shapes);
		System.out.println("Before store");
		System.out.println(shapes);
		out.close();
	}

}
