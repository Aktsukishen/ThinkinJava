package com.chapter17.learning.l_1709_s;

/**
 * 
 * @author li.shensong
 *
 */
public class StringHashDemo {

	public static void main(String[] args) {
		String[] hellos="Hello Hello".split(" ");
		System.out.println(hellos[0].hashCode());
		System.out.println(hellos[1].hashCode());
	}

}
