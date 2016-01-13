package com.chapter11.learning.l_1105_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import typeinfo.pets.Cymric;
import typeinfo.pets.Hamster;
import typeinfo.pets.Mouse;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

public class ListFeatures {

	public static void main(String[] args) {
		Random rand=new Random(47);
		List<Pet> pets=Pets.arrayList(7);
		System.out.println("1:"+pets);
		Hamster h=new Hamster();
		//末尾追加
		pets.add(h);
		System.out.println("2:"+pets);
		//是否包含 依赖于对象的equals（）方法
		System.out.println("3:"+pets.contains(h));
		//移除
		pets.remove(h);
		Pet p=pets.get(2);
		System.out.println("4: "+p+" "+pets.indexOf(p));
		Pet cymric=new Cymric();
		//对象不在数列中 返回-1
		System.out.println("5: "+pets.indexOf(cymric));
		System.out.println("6: "+pets.remove(cymric));
		//Must be the exact object
		System.out.println("7: "+pets.remove(p));
		System.out.println("8:"+pets);
		
		//add 在指定索引位置放入元素，之前改索引处和该索引之后的元素都往后移动
		pets.add(3, new Mouse());
		System.out.println("9:"+pets);
		
		//截取元素 区间[)
		List<Pet> sub=pets.subList(1, 4);
		System.out.println("sublist:"+sub);
		System.out.println("10: "+pets.containsAll(sub));
		//排序
		Collections.sort(sub);
		System.out.println("sorted sub:"+sub);
		//Order is not important in containsAll()
		System.out.println("11: "+pets.containsAll(sub));
		
		//重排
		Collections.shuffle(sub,rand);
		System.out.println("shuffled sublist: "+sub);
		System.out.println("12: "+pets.containsAll(sub));
		
		List<Pet> copy=new ArrayList<Pet>(pets);
		sub=Arrays.asList(pets.get(1),pets.get(4));
		System.out.println("copy:"+copy+" sub:"+sub);
		//交集
		copy.retainAll(sub);
		System.out.println("13: "+copy);
		
		copy=new ArrayList<Pet>(pets);
		copy.remove(2);
		System.out.println("14: "+copy);
		copy.removeAll(sub);
		System.out.println("15: "+copy);
		//替换
		copy.set(1, new Mouse());
		System.out.println("16: "+copy);
		copy.addAll(2, sub);
		System.out.println("17: "+copy);
		System.out.println("18: "+copy.isEmpty());
		pets.clear();
		System.out.println("19: "+pets);
		System.out.println("20: "+pets.isEmpty());
		pets.addAll(Pets.arrayList(4));
		System.out.println("21: "+pets);
		Object[] o=pets.toArray();
		System.out.println("22: "+o[3]);
		//如果参数数组太小，会自动创建合适大小的尺寸
		Pet[] pa=pets.toArray(new Pet[0]);//不会报错
		System.out.println("23:"+pa[3].id());
	}

}
