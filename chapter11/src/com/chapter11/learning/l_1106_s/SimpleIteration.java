package com.chapter11.learning.l_1106_s;

import java.util.Iterator;
import java.util.List;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

public class SimpleIteration {

	public static void main(String[] args) {
		List<Pet> pets=Pets.arrayList(12);
		Iterator<Pet> it=pets.iterator();
		while(it.hasNext()){
			Pet p=it.next();
			System.out.print(p.id()+":"+p+" ");
		}
		System.out.println();
		for(Pet p:pets){
			System.out.print(p.id()+":"+p+" ");
		}
		System.out.println();
		it=pets.iterator();
		for(int i=0;i<6;i++){
			it.next();
			it.remove();//移除当前元素 在调用此方法之前必选先调用next()
		}
		System.out.println(pets);
	}

}
