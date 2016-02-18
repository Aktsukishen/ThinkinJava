package com.chapter19.learning.l_1901_s;

enum Shrubbery{
	GROUND,CRAWLING,HANGING
}

/**
 * 
 * @author li.shensong
 *
 */
public class EnumClass {

	public static void main(String[] args) {
		for(Shrubbery s:Shrubbery.values()){
			//ordinal 在枚举中申明的顺序
			System.out.println(s+" ordinal:"+s.ordinal());
			//枚举类实现Comparable接口
			System.out.println(s.compareTo(Shrubbery.CRAWLING)+"");
			System.out.println(s.equals(Shrubbery.CRAWLING)+"");
			System.out.println(s==Shrubbery.CRAWLING);
			System.out.println(s.getDeclaringClass());
			System.out.println(s.name());
			System.out.println("=========");
		}
	}

}
