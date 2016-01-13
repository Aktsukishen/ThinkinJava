package com.chapter11.learning.l_1107_s;

import java.util.LinkedList;

import typeinfo.pets.Hamster;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
import typeinfo.pets.Rat;

/**
 * 
 * getFirst(),element()和peek()都是返回第一个元素 前2个方法在链表为空时抛出异常，后者返回null
 * addFirst()和offer()一样，往链表头追加数据 add(),addLast()往链表后追加数据
 * remove(),removeFirst()和poll()方法都是移除第一个元素   前2个方法在链表为空时抛出异常，后者返回null
 * 
 * @author li.shensong
 *
 */
public class LinkedListFeatures {

	public static void main(String[] args) {
		LinkedList<Pet> pets=new LinkedList<Pet>(Pets.arrayList(5));
		System.out.println(pets);
		//identical:获取第一个元素，但不删除
		System.out.println("pets.getFirst():"+pets.getFirst());
		System.out.println("pets.element():"+pets.element());
		//only differs in empty-list behavior:跟前面的方法相同 只是在pets为空的时候 前面抛出异常，peek()返回null
		System.out.println("pets.peek():"+pets.peek());
		
		//identical:移除第一个元素
		System.out.println(pets);
		System.out.println("pets.remove():"+pets.remove());
		System.out.println("pets.removeFirst():"+pets.removeFirst());
		System.out.println(pets);
		//only differs in empty-list behavior:跟前面的方法相同，只是pets为空时前面的方法抛出异常，poll()返回为null
		System.out.println("pets.poll():"+pets.poll());
		System.out.println(pets);
		
		pets.addFirst(new Rat());
		System.out.println("After add first():"+pets);
		pets.offer(Pets.randomPet());
		System.out.println("After offer():"+pets);
		pets.add(Pets.randomPet());
		System.out.println("After add():"+pets);
		pets.addLast(new Hamster());
		System.out.println("After addLast():"+pets);
		System.out.println("After removeLast:"+pets.removeLast());
	}

}
