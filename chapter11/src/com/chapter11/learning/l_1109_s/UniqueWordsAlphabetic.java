package com.chapter11.learning.l_1109_s;

import java.util.Set;
import java.util.TreeSet;

import com.chapter18.learning.l_1807_s.TextFile;

public class UniqueWordsAlphabetic {

	public static void main(String[] args) {
		Set<String> words=new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		words.addAll(new TextFile("src/com/chapter11/learning/l_1109_s/SetOperations.java","\\W+"));
		System.out.println(words);
	}

}
