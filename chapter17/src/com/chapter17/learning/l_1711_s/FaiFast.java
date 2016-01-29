package com.chapter17.learning.l_1711_s;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class FaiFast {
	public static void main(String[]args){
		Collection<String> c=new ArrayList<String>();
		Iterator<String> it=c.iterator();
		c.add("one");
		try {
			it.next();
		} catch (ConcurrentModificationException e) {
			System.out.println("exception");
		}
	}
}
