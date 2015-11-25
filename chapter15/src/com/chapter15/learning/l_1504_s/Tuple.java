package com.chapter15.learning.l_1504_s;

import com.chapter15.learning.l_1502_s.FiveTuple;
import com.chapter15.learning.l_1502_s.FourTuple;
import com.chapter15.learning.l_1502_s.ThreeTuple;
import com.chapter15.learning.l_1502_s.TwoTuple;

public class Tuple {

	public static <A,B> TwoTuple<A,B> tuple(A a,B b){
		return new TwoTuple<A,B>(a, b);
	}
	
	public static <A,B,C> ThreeTuple<A,B,C> tuple(A a,B b,C c){
		return new ThreeTuple<A,B,C>(a, b,c);
	}
	
	public static <A,B,C,D> FourTuple<A,B,C,D> tuple(A a,B b,C c,D d){
		return new FourTuple<A,B,C,D>(a, b,c,d);
	}
	
	public static <A,B,C,D,E> FiveTuple<A,B,C,D,E> tuple(A a,B b,C c,D d,E e){
		return new FiveTuple<A,B,C,D,E>(a, b,c,d,e);
	}
	
}
