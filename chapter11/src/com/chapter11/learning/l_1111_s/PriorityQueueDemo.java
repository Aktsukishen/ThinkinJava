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
 * ���ȶ��У�
 * ��offer��add�Ĺ����У�Ԫ�ػ��ڶ����б�����
 * Ĭ�ϵ�����ʹ�ö����ڶ����е���Ȼ���򣬵�����ͨ���ṩ�Լ���Comparator���޸�
 * ��offer(),peek(),remove()ʱ�����ö������ȼ���ߵ�Ԫ��
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
		//����Ƚ���
		priorityQueue=new PriorityQueue<>(ints.size(), Collections.reverseOrder());
		//��������
		priorityQueue.addAll(ints);
		QueueDemo.printQ(priorityQueue);
		
		String fact="EDACATION SHOULD��ESCHEW OBFUCSTIION";
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
