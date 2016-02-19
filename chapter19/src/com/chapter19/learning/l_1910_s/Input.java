package com.chapter19.learning.l_1910_s;

import java.util.Random;

/**
 * 自动售货机输入类
 * @author li.shensong
 *
 */
public enum Input {
	NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),
	TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
	ABORT_TRANSACTION{
		public int amount(){
			throw new RuntimeException("ABORT.amout()");
		}
	},
	STOP{
		public int amount(){
			throw new RuntimeException("SHUT_DOWN.amount()");
		}
	};
	int value;
	Input(int value){//构造函数也可以有多个
		this.value=value;
	}
	Input(){}
	int amount(){
		return value;
	}
	static Random rand=new Random(47);
	public static Input randomSelection(){
		//Don't include STOP
		return values()[rand.nextInt(values().length-1)];
	}
}
