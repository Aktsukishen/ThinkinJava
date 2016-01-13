package com.chapter11.learning.l_1106_s;

import java.util.List;
import java.util.ListIterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * 
 * ListIterator 支持双向的List迭代器
 * @author li.shensong
 *
 */
public class ListIteration {

	public static void main(String[] args) {
		List<Pet> pets=Pets.arrayList(8);
		ListIterator<Pet> it=pets.listIterator();
		while(it.hasNext()){
			System.out.print(it.next()+", "+it.nextIndex()+", "+it.previousIndex()+";");
		}
		System.out.println();
		while(it.hasPrevious()){
			System.out.print(it.previous().id()+" ");
		}
		System.out.println();
		System.out.println(pets);
		//从指定位置开始的迭代器
		it=pets.listIterator(3);
		while(it.hasNext()){
			it.next();
			it.set(Pets.randomPet());
		}
		System.out.println(pets); 
	}

}
