package com.chapter15.learning.l_1507_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Frob{}
class Fnorkle{}
class Quark<Q>{}
class Praticle<POSTION,MOMENTUM>{}

/**
 * 
 * 在运行时并不能取得类型参数的具体类型
 * 在泛型代码内部，无法获得任何有关泛型参数类型的信息
 * @author Administrator
 *
 */
public class LostInformation {
	public static void main(String[]args){
		List<Frob> list=new ArrayList<Frob>();
		Map<Frob,Fnorkle> map=new HashMap<Frob,Fnorkle>();
		Quark<Fnorkle> quark=new Quark<Fnorkle>();
		Praticle<Long,Double> p=new Praticle<Long,Double>();
		System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
	}
}
