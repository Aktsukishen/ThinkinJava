package com.chapter11.learning.l_1110_s;

import java.util.HashMap;
import java.util.Map;

import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.Hamster;
import typeinfo.pets.Pet;

public class PetMap {

	public static void main(String[] args) {
		Map<String,Pet> petMap=new HashMap<String,Pet>();
		petMap.put("My cat", new Cat("Molly") );
		petMap.put("My Dog", new Dog("Ginger"));
		petMap.put("My Hamster", new Hamster("Bosco"));
		System.out.println(petMap);
		Pet dog=petMap.get("My Dog");
		System.out.println(dog);
		System.out.println(petMap.containsKey("My Dog"));
		System.out.println(petMap.containsValue(dog));
	}

}
