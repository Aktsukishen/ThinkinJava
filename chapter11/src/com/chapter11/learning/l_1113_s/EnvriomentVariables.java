package com.chapter11.learning.l_1113_s;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Map.KeySet() ��������Key�ļ���
 * Map.EntrySet() ���ظ�map�����ж���ļ���
 * @author Administrator
 *
 */
public class EnvriomentVariables {

	public static void main(String[] args) {
		for(Map.Entry<String,String> entry:System.getenv().entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("one", "1");
		System.out.println(map.put("one", "11"));
		map.put("two", "2");
		for(String key:map.keySet()){
			System.out.println(key+":"+map.get(key));
		}
		for(Map.Entry<String, String> entry:map.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

}
