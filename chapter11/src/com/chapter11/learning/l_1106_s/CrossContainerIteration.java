package com.chapter11.learning.l_1106_s;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * 
 * 继承自Collection的类型都实现了迭代器
 * 传入容器类的迭代器 获取容器内的元素
 * @author li.shensong
 *
 */
public class CrossContainerIteration {

	//显示不同容器的元素
	public static void display(Iterator<Pet> it){
		while(it.hasNext()){
			Pet p=it.next();
			System.out.print(p.id()+":"+p+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<Pet> pets=Pets.arrayList(8);
		LinkedList<Pet> petsLL=new LinkedList<>(pets);
		HashSet<Pet> petsHS=new HashSet<Pet>(pets);
		TreeSet<Pet> petsTS=new TreeSet<Pet>(pets);
		display(pets.iterator());
		display(petsLL.iterator());
		display(petsHS.iterator());
		display(petsTS.iterator());
	}

}
