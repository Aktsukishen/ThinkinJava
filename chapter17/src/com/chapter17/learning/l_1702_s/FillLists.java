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
 * �������
 * list:
 * nCopies ����ָ��ͬһ�������n������
 * fill ���ʹ����ͬ����ȥ���
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
