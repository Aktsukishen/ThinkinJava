package com.chapter17.learning.l_1702_s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringAddress{
	private String s;
	public StringAddress(String s){
		this.s=s;
	}
	public String toString(){
		return super.toString()+" "+s;
	}
}

/**
 * 
 * 填充容器
 * list:
 * nCopies 创建指向同一个对象的n个引用
 * fill 填充使用相同对象去填充
 * @author Administrator
 *
 */
public class FillLists {

	public static void main(String[] args) {
		List<StringAddress> list=new ArrayList(Collections.nCopies(4, new StringAddress("Hello")));
		System.out.println(list);
		Collections.fill(list, new StringAddress("World!"));
		System.out.println(list);
	}

}
