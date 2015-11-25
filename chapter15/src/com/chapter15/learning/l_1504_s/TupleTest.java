package com.chapter15.learning.l_1504_s;

import com.chapter15.learning.l_1502_s.ThreeTuple;
import com.chapter15.learning.l_1502_s.TwoTuple;

import static com.chapter15.learning.l_1504_s.Tuple.*;

import java.util.Date;

public class TupleTest {
	static TwoTuple<String, Integer> f(){
		return tuple("hi",47);
	}
	static TwoTuple f2(){ return tuple("hi",47);}
	static ThreeTuple<Date,String,Integer> g(){
		return tuple(new Date(),"hi",47);
	}
	public static void main(String[]args){
		TwoTuple<String,Integer> ttsi=f();
		TwoTuple<String,Integer> ttsi2=f2();
		System.out.println(ttsi);
		System.out.println(ttsi2);
		System.out.println(g());
	}
}
