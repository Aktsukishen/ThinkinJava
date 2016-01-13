package com.chapter11.learning.l_1108_s;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack=new Stack<String>();
		for(String s:"My dog has fleas".split(" ")){
			stack.push(s);
		}
		while(!stack.empty()){
			System.out.println(stack.pop()+" ");
		}
	}

}
