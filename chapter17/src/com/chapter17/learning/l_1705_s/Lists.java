package com.chapter17.learning.l_1705_s;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.chapter17.learning.l_1702_s.Countries;

public class Lists {
	
	private static boolean b;
	private static  String s;
	private static int i;
	private static Iterator<String> it;
	private static ListIterator<String> lit;
	
	public static void basicTest(List<String> a){
		a.add(1, "x");
		System.out.println("add 1:"+a);
		a.add("y");
		System.out.println("add y:"+a);
		a.addAll(Countries.names(25));
		System.out.println("add all:"+a);
		a.addAll(3, Countries.names(25));
		System.out.println("add all at 3:"+a);
		b=a.contains("1");
		System.out.println("contains:"+b);
		b=a.containsAll(Countries.names(25));
		System.out.println("contains all:"+b);
		s=a.get(1);
		System.out.println("get :"+s);
		i=a.indexOf("1");
		System.out.println("index 1:"+i);
		b=a.isEmpty();
		System.out.println("isEmpty:"+b);
		it=a.iterator();
		while(it.hasNext()){
			System.out.print("it.next:"+it.next()+" ");
		}
		System.out.println();
		lit=a.listIterator();
		while(lit.hasNext()){
			System.out.print("lit.next:"+lit.next()+" ");
		}
		System.out.println();
		while(lit.hasPrevious()){
			System.out.print("lit.pre:"+lit.previous());
		}
		System.out.println();
		lit=a.listIterator(3);//指定位置开始迭代
		i=a.lastIndexOf("1");
		System.out.println("lastIndex:"+i);
		a.remove(1);
		a.remove("3");
		a.set(1, "y");
		System.out.println("set:"+a);
		a.retainAll(Countries.names(25));
		System.out.println("retainAll:"+a);
		a.removeAll(Countries.names(25));
		System.out.println("removeAll:"+a);
		i=a.size();
		a.clear();
		System.out.println("a.clear:"+a);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	public static void iterMotion(List<String> a){
		ListIterator<String> it=a.listIterator();
		b=it.hasNext();
		b=it.hasPrevious();
		s=it.next();
		i=it.nextIndex();
		s=it.previous();
		i=it.previousIndex();
	}
	
	//next() 处进行添加或者删除
	public  static void iterManitpulation(List<String> a){
		System.out.println("iterManipulation："+a);
		ListIterator<String> it=a.listIterator();
		it.add("47");
		System.out.println("it add："+a);
		it.next();
		it.remove();
		System.out.println("it remove:"+a);
		it.next();
		it.set("47");
		System.out.println("it next:"+a);
		System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYY");
	}
	
	public static void testVisual(List<String>a ){
		System.out.println("testVivual:"+a);
		List<String> b=Countries.names(3);
		System.out.println("b="+b);
		a.addAll(b);
		System.out.println("a="+a);
		ListIterator<String> x=a.listIterator(a.size()/2);//指向指定位置之前
		x.add("one");
		System.out.println("after add:"+a);
		System.out.println(x.next());
		x.remove();
		System.out.println("after remove:"+x.next());
		x.set("47");
		System.out.println("after set:"+a);
		x=a.listIterator(a.size());
		while(x.hasPrevious()){
			System.out.print(x.previous()+" ");
		}
		System.out.println();
		System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
	}
	
	public static void testLinkedList(){
		System.out.println("testLinkedList");
		LinkedList<String> ll=new LinkedList<String>();
		ll.addAll(Countries.names(3));
		System.out.println(ll);
		ll.addFirst("one");
		ll.addFirst("two");
		System.out.println(ll);
		System.out.println(ll.getFirst());
		System.out.println(ll.removeFirst());
		System.out.println(ll.removeLast());
		System.out.println(ll);
		System.out.println("111111111111111111111111111");
	}
	
	public static void main(String[]args){
		basicTest(new LinkedList<>(Countries.names(25)));
		basicTest(new ArrayList<>(Countries.names(25)));
		iterManitpulation(new LinkedList<String>(Countries.names(25)));
		iterManitpulation(new ArrayList<String>(Countries.names(25)));
		testVisual(new LinkedList<>(Countries.names(3)));
		testLinkedList();
	}
}
