package com.chapter11.learning.l_1112_s;

import java.util.Iterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

class PetSquence{
	protected Pet[] pets=Pets.createArray(8);
}

/**
 * 
 * 只要有办法返回迭代器就可以
 * @author Administrator
 *
 */
public class NonCollectionSequence extends PetSquence{

	public Iterator<Pet> iterator(){
		return new Iterator<Pet>(){
			private int index=0;
			@Override
			public boolean hasNext() {
				return index<pets.length;
			}

			@Override
			public Pet next() {
				return pets[index++];
			}
			
		};
	}
	public static void main(String[]args){
		NonCollectionSequence nc=new NonCollectionSequence();
		InterfaceVsIterator.display(nc.iterator());
	}
	
}
