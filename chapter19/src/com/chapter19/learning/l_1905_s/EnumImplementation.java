package com.chapter19.learning.l_1905_s;

import java.util.Random;

enum CartoonCharacter implements Generator<CartoonCharacter>{
	SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
	private Random rand=new Random(47);
	public CartoonCharacter next(){
		return values()[rand.nextInt(values().length)];
	}
}


interface Generator<T>{
	public T next();
}

/**
 * 
 * 枚举类自动继承自java.lang.Enum类，因此不能再继承其他类了。使用接口实现来实现其他功能。
 * @author li.shensong
 *
 */
public class EnumImplementation {
	public static <T> void printNext(Generator<T> rg){
		System.out.println(rg.next()+" ");
	}
	
	public static void main(String[] args) {
		//Choose any instance
		CartoonCharacter cc=CartoonCharacter.BOB;
		for(int i=0;i<10;i++){
			printNext(cc.next());
		}
	}

}
