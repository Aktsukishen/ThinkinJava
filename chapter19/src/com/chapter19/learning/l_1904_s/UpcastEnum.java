package com.chapter19.learning.l_1904_s;

enum Search{
	HITHER,YON
}

public class UpcastEnum {

	public static void main(String[] args) {
		Search[] vals=Search.values();
		Enum e=Search.HITHER;//Upcast
		//e.values();//No values() in enum
		for(Enum en:e.getClass().getEnumConstants()){//getEnumConstants()是Class类的方法
			System.out.println(en);
		}
	}

}
