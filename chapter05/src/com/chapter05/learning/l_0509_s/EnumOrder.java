package com.chapter05.learning.l_0509_s;

/**
 * 
 * ͨ��ö�����͵�values���Ի�ð��ն���ʱ���˳������ĳ���
 * ��Щö�ٳ���������ordinal()��������������ʱ��˳��
 * @author Administrator
 *
 */
public class EnumOrder {

	public static void main(String[] args) {
		for(Speciness s:Speciness.values()){
			System.out.println(s+",ordinal "+s.ordinal());
		}
	}

}
