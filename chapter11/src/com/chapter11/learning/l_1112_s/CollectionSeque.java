package com.chapter11.learning.l_1112_s;

import java.util.AbstractCollection;
import java.util.Iterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * 
 * ʹ�ü̳�
 * ��ʵ�̳�AbstractCollection���ջ���Ҫ����Iterator<T>��ʵ����
 * @author Administrator
 *
 */
public class CollectionSeque extends AbstractCollection<Pet>{
	private Pet[] pets=Pets.createArray(8);
	
	public static void main(String[] args) {
		CollectionSeque cs=new CollectionSeque();
		InterfaceVsIterator.display(cs);
		InterfaceVsIterator.display(cs.iterator());
	}

	@Override
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
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

	@Override
	public int size() {
		return 0;
	}

}
