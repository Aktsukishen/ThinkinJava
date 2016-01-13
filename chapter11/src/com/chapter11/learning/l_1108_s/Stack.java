package com.chapter11.learning.l_1108_s;

import java.util.LinkedList;

public class Stack<T> {
	private LinkedList<T> storage=new LinkedList<T>();
	public void push(T v){
		storage.addFirst(v);
	}
	public T peek(){//peek 瞥一眼 当然只能看第一个元素咯
		return storage.peek();
	}
	public T pop(){
		return storage.poll();
	}
	public boolean empty(){
		return storage.isEmpty();
	}
	public String toString(){
		return storage.toString();
	}
}
