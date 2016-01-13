package com.chapter11.learning.l_1109_s;
import java.util.Set;
import java.util.TreeSet;

import com.chapter18.learning.l_1807_s.TextFile;

public class UniqueWords {

	public static void main(String[] args) {
		Set<String> words=new TreeSet<String>(new TextFile("src/com/chapter11/learning/l_1109_s/SetOperations.java","\\W+"));
		System.out.println(words);
	}

}
