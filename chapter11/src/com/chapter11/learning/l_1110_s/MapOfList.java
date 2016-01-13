package com.chapter11.learning.l_1110_s;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import typeinfo.pets.Cat;
import typeinfo.pets.Cymric;
import typeinfo.pets.Dog;
import typeinfo.pets.Mutt;
import typeinfo.pets.Person;
import typeinfo.pets.Pet;
import typeinfo.pets.Pug;
import typeinfo.pets.Rat;

/**
 * 
 * Map.keySet() 返回所有Key的集合 Set<T>，继承自Collection，其实现Iterator接口， 能够foreach进行遍历
 * Map.vaules 返回所有值的集合
 * @author Administrator
 *
 */
public class MapOfList {

	public static Map<Person, List<? extends Pet>>
		petPeople=new HashMap<Person,List<? extends Pet>>();
	static{
		petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"),new Mutt("Spot")));
		petPeople.put(new Person("Kate"), Arrays.asList(new Cat("Shackleton"),new Cat("Elsie May"),new Dog("Margrett")));
		petPeople.put(new Person("Marily"), 
				Arrays.asList(new Pug("Louie aka Louis Snorkelstein Dupree"),
							  new Cat("Stanford aka Stingky el Negro"),
							  new Cat("Pinkola")	
						));
		petPeople.put(new Person("Luke"), Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
		petPeople.put(new Person("Isaac"), Arrays.asList(new Rat("Freckly")));
	}
	public static void main(String[] args) {
		System.out.println("People:"+petPeople.keySet());
		System.out.println("Pets:"+petPeople.values());
		for(Person person:petPeople.keySet()){
			System.out.print(person+" has ");
			for(Pet pet:petPeople.get(person)){
				System.out.print(" "+pet);
			}
			System.out.println();
		}
	}

}
