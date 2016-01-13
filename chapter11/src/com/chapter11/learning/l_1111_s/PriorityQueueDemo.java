package com.chapter11.learning.l_1111_s;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

/**
 * 
 * 优先队列：
 * 在offer和add的过程中，元素会在队列中被排序
 * 默认的排序将使用对象在队列中的自然排序，但可以通过提供自己的Comparator来修改
 * 当offer(),peek(),remove()时都会获得队列优先级最高的元素
 * @author Administrator
 *
 */
public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>();
		Random rand=new Random(47);
		for(int i=0;i<10;i++){
			priorityQueue.offer(rand.nextInt(i+10));
		}
		QueueDemo.printQ(priorityQueue);
		
		List<Integer> ints=Arrays.asList(25,22,20,18,14,9,3);
		priorityQueue=new PriorityQueue<>(ints);
		QueueDemo.printQ(priorityQueue);
		//传入比较器
		priorityQueue=new PriorityQueue<>(ints.size(), Collections.reverseOrder());
		//传入数据
		priorityQueue.addAll(ints);
		QueueDemo.printQ(priorityQueue);
		
		String fact="EDACATION SHOULD　ESCHEW OBFUCSTIION";
		List<String> strings=Arrays.asList(fact.split(""));
		PriorityQueue<String> stringPQ=new PriorityQueue<>(strings.size(), Collections.reverseOrder());
		stringPQ.addAll(strings);
		QueueDemo.printQ(stringPQ);
		
		Set<Character> charSet=new HashSet<Character>();
		for(char c:fact.toCharArray()){
			charSet.add(c);
		}
		PriorityQueue<Character> characterPQ=new PriorityQueue<>(charSet);
		QueueDemo.printQ(characterPQ);
	}

}
