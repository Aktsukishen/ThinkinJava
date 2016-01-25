package com.chapter17.learning.l_1709_s;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.chapter17.learning.l_1702_s.Countries;

public class SlowMap<K, V> extends AbstractMap<K, V>{

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set=new HashSet<Map.Entry<K,V>>();
		Iterator<K> ki=keys.iterator();
		Iterator<V> vi=values.iterator();
		while(ki.hasNext()){
			set.add(new MapEntry<K, V>(ki.next(),vi.next()));
		}
		return set;
	}
	
	private List<K> keys=new ArrayList<K>();
	private List<V> values=new ArrayList<V>();
	@Override
	public V put(K key,V value){
		V oldValue=get(key);
		if(!keys.contains(key)){
			keys.add(key);
			values.add(value);
		}else{
			values.set(keys.indexOf(key), value);
		}
		return oldValue;
	}
	@Override
	public V get(Object key){
		if(!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}
	
	public static void main(String[]args){
		SlowMap<String,String> m=new SlowMap<>();
		m.putAll(Countries.capitals(15));
		System.out.println(m);
		System.out.println(m.get("ANGOLA"));
		System.out.println(m.entrySet());
	}
}
