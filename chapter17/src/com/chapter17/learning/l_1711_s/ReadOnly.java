package com.chapter17.learning.l_1711_s;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.chapter17.learning.l_1702_s.Countries;

/**
 * 
 * unmodifiableCollection()
 * 返回不可修改的容器
 * 
 * 可以将可修改的容器至于自己管控的类当中，设置private访问权限
 * 然后暴露给外界一个unmodifiable的容器
 * 这样就能实现只能在内部自己进行容器的修改，外部不可修改
 * @author li.shensong
 *
 */
public class ReadOnly {

	static Collection<String> data=new ArrayList<String>(Countries.names(6));
	public static void main(String[] args) {
		Collection<String> c=Collections.unmodifiableCollection(data);
		System.out.println(c);
//		c.add("one");
		
		List<String> a=Collections.unmodifiableList(new ArrayList<String>(data));
		ListIterator<String> lit=a.listIterator();
		System.out.println(lit.next());
//		lit.add("one");
		
		Set<String> b=(Set<String>) Collections.unmodifiableSet(new HashSet<String>(data));
		System.out.println(b);
//		b.add("one");
		
		//For a sortedSet:
		Set<String> ss=(Set<String>) Collections.unmodifiableSortedSet(new TreeSet<String>());
		
		Map<String,String> m=Collections.unmodifiableMap(new HashMap<>(Countries.capitals(6)));
		System.out.println(m);
//		m.put("Ralph","Howdy!");
		
	}

}
