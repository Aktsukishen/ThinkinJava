package com.chapter17.learning.l_1707_s;

import java.util.LinkedList;

/**
 *
 * 双向队列：
 * 其实LinkedList()本身就是双向的，只是名字稍微内向点
 * @author li.shensong
 *
 * @param <T>
 */
public class Deque<T> {
	private LinkedList<T> deque=new LinkedList<T>();
	public void addFirst(T e){
		deque.addFirst(e);
	}
	public void addLast(T e){
		deque.addLast(e);
	}
	public T getFirst(){
		return deque.getFirst();
	}
	public T getLast(){
		return deque.getLast();
	}
	public T removeFirst(){
		return deque.removeFirst();
	}
	public T removeLast(){
		return deque.removeLast();
	}
	public int size(){
		return deque.size();
	}
	public String toString(){
		return deque.toString();
	}
}
