package com.chapter15.learning.l_1502_s;

public class LinkedStack<T> {

	class Node<U>{
		U item;
		Node<U> next;
		Node(){ item=null;next=null;}
		Node(U item,Node<U> next){
			this.item=item;
			this.next=next;
		}
	}
	
	private Node<T> top=new Node<T>();
	
	public void push(T item){
		top=new Node<T>(item,top);
	}
	
	public T pop(){
		T result=top.item;
        top=top.next;
		return result;
	}
	
	public static void main(String[]args){
		LinkedStack<String> lss=new LinkedStack<String>();
		for(String s: "Phasers on stun!".split(" ")){
			lss.push(s);
		}
		String s;
		while((s=lss.pop())!=null){
			System.out.println(s);
		}
	}
}
