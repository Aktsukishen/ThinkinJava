package com.chapter17.learning.l_1710_s;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 只有需要一个排好序的Set时才使用TreeSet
 * @author Administrator
 *
 */
public class SetPerformance {

	static List<Test<Set<Integer>>> tests=new ArrayList<Test<Set<Integer>>>();
	
	static {
		tests.add(new Test<Set<Integer>>("add"){

			@Override
			int test(Set<Integer> set, TestParam tp) {
				int loops=tp.loops;
				int size=tp.size;
				for(int i=0;i<loops;i++){
					set.clear();
					for(int j=0;j<size;j++)
						set.add(j);
				}
				return loops*size;
			}
			
		});
		tests.add(new Test<Set<Integer>>("contains"){

			@Override
			int test(Set<Integer> set, TestParam tp) {
				int loops=tp.loops;
				int size=tp.size;
				for(int i=0;i<loops;i++){
					for(int j=0;j<size;j++)
						set.contains(j);
				}
				return loops*size;
			}
		});
		tests.add(new Test<Set<Integer>>("iterate"){

			@Override
			int test(Set<Integer> set, TestParam tp) {
				int loops=tp.loops;
				int size=tp.size;
				for(int i=0;i<loops;i++){
					Iterator<Integer> it=set.iterator();
					while(it.hasNext()) it.next();
				}
				return loops*size;
			}
		});
	}
	
	public static void main(String[] args) {
		Tester.fieldWidth=10;
		Tester.run(new TreeSet<Integer>(), tests);
		Tester.run(new HashSet<Integer>(), tests);
		Tester.run(new LinkedHashSet<Integer>(), tests);
	}

}
