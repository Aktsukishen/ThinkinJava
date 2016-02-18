package com.chapter19.learning.l_1910_s;

import java.text.DateFormat;
import java.util.Date;

/**
 * 
 * 枚举类应该看成是一个复写的子类
 * 其编译之后为 static final
 * @author li.shensong
 *
 */
public enum ConstantSpecificMethod {
	DATE_TIME{
		String getInfo(){
			return DateFormat.getDateInstance().format(new Date());
		};
	},
	CLASSPATH{
		String getInfo(){
			return System.getenv("CLASSPATH");
		};
	},
	VERSION{
		String getInfo(){
			return System.getProperty("java.version");
		}
	};
	abstract String getInfo();
	public static void main(String[]args){
		for(ConstantSpecificMethod csm:ConstantSpecificMethod.values()){
			System.err.println(csm.getInfo());
		};
	}
}
