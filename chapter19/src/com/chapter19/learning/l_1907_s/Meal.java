package com.chapter19.learning.l_1907_s;

public class Meal {
	public static void main(String[]args){
		for(int i=0;i<5;i++){
			for(Course course:Course.values()){
				Food food=course.randomSelection();
				System.out.println(food);
			}
			System.out.println("---");
		}
	}
}
