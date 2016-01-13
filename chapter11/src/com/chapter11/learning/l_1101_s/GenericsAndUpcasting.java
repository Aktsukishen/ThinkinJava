package com.chapter11.learning.l_1101_s;

import java.util.ArrayList;

class GranySmith extends Apple{};
class Gala extends Apple{};
class Fuji extends Apple{};
class Braeburn extends Apple{};

public class GenericsAndUpcasting {

	public static void main(String[] args) {
		ArrayList<Apple> apples=new ArrayList<Apple>();
		apples.add(new GranySmith());
		apples.add(new Gala());
		apples.add(new Fuji());
		apples.add(new Braeburn());
		for(Apple c:apples){
			System.out.println(c);
		}
	}

}
