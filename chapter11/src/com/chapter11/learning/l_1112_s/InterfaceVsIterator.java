package com.chapter11.learning.l_1112_s;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * 
 * 使用接口Iterator和基类Collection都可以用来展示数据，达到解耦的效果
 * 对于Collection来说使用基类foreach展示数据的方式明显是更加清晰的
 * 使用接口Iterator相对而言代码稍显晦涩
 * 
 * 但是使用基类Collection，使得类实现起来变成了面向类变成，占用了继承的父类
 * 使用接口Iterator可以根据类的实际来实现接口的方法
 * 
 * @author Administrator
 *
 */
public class InterfaceVsIterator {

	public static void display(Iterator<Pet> it){
		while(it.hasNext()){
			Pet p=it.next();
			System.out.print(p.id()+":"+p+" ");
		}
		System.out.println();
	}
	
	public static void display(Collection<Pet> pets){
		for(Pet p:pets){
			System.out.print(p.id()+":"+p+" ");	
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		List<Pet> petList=Pets.arrayList(8);
		Set<Pet> petSet=new HashSet<Pet>(petList);
		Map<String,Pet> petMap=new LinkedHashMap<String,Pet>();
		String[] names=("Ralpah,Eric,Robin,Lacey,Britney,Sam,Spot,Fluffy").split(".");
		for(int i=0;i<names.length;i++){
			petMap.put(names[i], petList.get(i));
		}
		display(petList);
		display(petSet);
		display(petList.iterator());
		display(petSet.iterator());
		System.out.println(petMap);
		System.out.println(petMap.keySet());
		display(petMap.values());
		display(petMap.values().iterator());
	}

}
