package com.chapter17.learning.l_1710_s;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

import com.chapter17.learning.l_1702_s.CountingIntegerList;

/**
 * 
 * 最佳的做法可能是将ArrayList作为默认首选，只有需要额外的功能或者程序的性能优于经常从表中插入和删除而变差时才会选用LinkedList
 * 如果使用的是固定数量的元素，那么既可以选择使用背后有数组支持的List Arrays.asList(),也可以选择真正的数组
 * 
 * @author Administrator
 *
 */
public class ListPerformance {

	static  Random rand=new Random();
	static int reps=1000;
	static List<Test<List<Integer>>> tests=new ArrayList<Test<List<Integer>>>();
	static List<Test<LinkedList<Integer>>> qTests=new ArrayList<Test<LinkedList<Integer>>>();
	static{
		tests.add(new Test<List<Integer>>("add"){

			@Override
			int test(List<Integer> list, TestParam tp) {
				int loops=tp.loops;
				int size=tp.size;
				for(int i=0;i<loops;i++){
					list.clear();
					for(int j=0;j<size;j++){
						list.add(j);
					}
				}
				return loops*size;
			}
		});
		
		tests.add(new Test<List<Integer>>("get"){

			@Override
			int test(List<Integer> list, TestParam tp) {
				int loops=tp.loops;
				int size=tp.size;
				for(int i=0;i<loops;i++){
					list.get(rand.nextInt(size));
				}
				return loops;
			}
		});
		
		tests.add(new Test<List<Integer>>("set"){

			@Override
			int test(List<Integer> list, TestParam tp) {
				int loops=tp.loops;
				int size=list.size();
				for (int i = 0; i < loops; i++) {
					list.set(rand.nextInt(size), 47);
				}
				return loops;
			}
			
		});
		
		tests.add(new Test<List<Integer>>("iteradd"){

			@Override
			int test(List<Integer> list, TestParam tp) {
				final int LOOPS=1000000;
				int half=list.size()/2;
				ListIterator<Integer> it=list.listIterator(half);
				for(int i=0;i<LOOPS;i++)
					it.add(47);
				return LOOPS;
			}
			
		});
		
		tests.add(new Test<List<Integer>>("insert"){

			@Override
			int test(List<Integer> list, TestParam tp) {
				int loops=tp.loops;
				int size=list.size();
				for(int i=0;i<loops;i++){
					list.add(5,47);
				}
				return loops;
			}
			
		});
		
		tests.add(new Test<List<Integer>>("remove"){

			@Override
			int test(List<Integer> list, TestParam tp) {
				int loops=tp.loops;
				int size=tp.size;
				for(int i=0;i<loops;i++){
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while(list.size()>5){
						list.remove(5);
					}
				}
				return loops*size;
			}
			
		});
		
	}
	
	//Tests for queue behavior
	static{
		
		qTests.add(new Test<LinkedList<Integer>>("addFirst"){

			@Override
			int test(LinkedList<Integer> list, TestParam tp) {
				int loops=tp.loops;
				int size=tp.size;
				for(int i=0;i<loops;i++){
					list.clear();
					for(int j=0;j<size;j++){
						list.addFirst(47);
					}
				}
				return loops*size;
			}
			
		});
		
		qTests.add(new Test<LinkedList<Integer>>("addLast"){

			@Override
			int test(LinkedList<Integer> list, TestParam tp) {
				int loops=tp.loops;
				int size=tp.size;
				for(int i=0;i<loops;i++){
					list.clear();
					for(int j=0;j<size;j++){
						list.addLast(47);
					}
				}
				return loops*size;
			}
			
		});
		
		qTests.add(new Test<LinkedList<Integer>>("rmFirst"){

			@Override
			int test(LinkedList<Integer> list, TestParam tp) {
				int loops=tp.loops;
				int size=tp.size;
				for(int i=0;i<loops;i++){
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while(list.size()>0){
						list.removeFirst();
					}
				}
				return loops*size;
			}
			
		});
		
		qTests.add(new Test<LinkedList<Integer>>("rmLast"){

			@Override
			int test(LinkedList<Integer> list, TestParam tp) {
				int loops=tp.loops;
				int size=tp.size;
				for(int i=0;i<loops;i++){
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while(list.size()>0){
						list.removeLast();
					}
				}
				return loops*size;
			}
			
		});
	}
	
	static class ListTester extends Tester<List<Integer>>{
		public ListTester(List<Integer> container,List<Test<List<Integer>>> tests){
			super(container,tests);
		}
		@Override
		protected List<Integer> initialize(int size){
			container.clear();
			container.addAll(new CountingIntegerList(size));
			return container;
		}
		//Convenience method:
		public static void run(List<Integer> list,List<Test<List<Integer>>> tests){
			new ListTester(list, tests).timedTest();
		}
	}
	
	public static void main(String[] args) {
		if(args.length>0)
			Tester.defaultParams=TestParam.array(args);
		ListTester.run(new ArrayList<Integer>(), tests);
		ListTester.run(new LinkedList<Integer>(), tests);
		ListTester.run(new Vector<Integer>(), tests);
		Tester.fieldWidth=12;
		Tester<LinkedList<Integer>> qTest=new Tester<LinkedList<Integer>>(new LinkedList<Integer>(), qTests);
		qTest.setHeadLine("Queue tests");
		qTest.timedTest();
	}

}
