package com.chapter17.learning.l_1703_s;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.chapter17.learning.l_1702_s.Countries;

/**
 * 
 * Collectionͨ�÷���
 * @author Administrator
 *
 */
public class CollectionMethods {

	public static void main(String[]args){
		Collection<String> c=new ArrayList<String>();
		c.addAll(Countries.names(6));
		c.add("ten");
		c.add("eleven");
		System.out.println(c);
		//Make an array from the list
		Object[] array=c.toArray();
		//Make a String array from the list
		String[] str=c.toArray(new String[0]);
		System.out.println("Collection.max(c):"+Collections.max(c));//�������ȡ����Comparable�ӿ�ʵ��
		System.out.println("Collection.min(c):"+Collections.min(c));
		//Add a Collection to another collection
		Collection<String> c2=new ArrayList<String>();
		c2.addAll(Countries.names(6));
		c.addAll(c2);
		System.out.println(c);
		c.remove(Countries.DATA[0][0]);//ֻɾ��һ����Ԫ�ص�ʵ��
		System.out.println(c);
		c.remove(Countries.DATA[1][0]);
		System.out.println(c);
		c.removeAll(c2);
		System.out.println(c);//ɾ������Ԫ�ص�ʵ��
	    c.addAll(c2);	
	    System.out.println(c);
	    String val=Countries.DATA[3][0];
	    System.out.println("c.contains("+val+"):"+c.contains(val));
	    System.out.println("c.containsAll(c2):"+c.containsAll(c2));
	    Collection<String> c3=((List<String>)c).subList(3, 5);
	    System.out.println(c2);
	    c2.retainAll(c3);//�󽻼�
	    System.out.println(c2);
	    c2.removeAll(c3);
	    System.out.println("c2.isEmpty():"+c2.isEmpty());
	    c=new ArrayList<String>();
	    c.addAll(Countries.names(6));
	    System.out.println(c);
	    c.clear();
	    System.out.println("after clear:"+c);
	}
}
