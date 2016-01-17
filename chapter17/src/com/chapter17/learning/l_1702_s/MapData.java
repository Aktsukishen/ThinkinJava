package com.chapter17.learning.l_1702_s;

import java.util.LinkedHashMap;

import com.chapter15.learning.l_1503_s.Generator;

public class MapData<K,V> extends LinkedHashMap<K,V> {
	//A single Pair Generator
	public MapData(Generator<Pair<K,V>>gen, int quantity){
		for(int i=0;i<quantity;i++){
			Pair<K,V> pair=gen.next();
			put(pair.key,pair.value);
		}
	}
	
	//Two seperate Generator
	public MapData(Generator<K> genK,Generator<V> genV,int quantity){
		for(int i=0;i<quantity;i++){
			put(genK.next(),genV.next());
		}
	}
	
	//A key Generator and a single value;
	public MapData(Generator<K> genK,V value,int quantity){
		for(int i=0;i<quantity;i++){
			put(genK.next(),value);
		}
	}
	
	//A Iterable and a value Generator
	public MapData(Iterable<K> genK,Generator<V> genV){
		for(K key:genK){
			put(key,genV.next());
		}
	}
	
	//A Iterable and a value value
	public MapData(Iterable<K> genK,V value){
		for(K key:genK){
			put(key,value);
		}
	}

	
	//Generic convenience methods:
	public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> gen,int quantity){
		return new MapData<K,V>(gen,quantity);
	}
	
	public static <K,V> MapData<K,V> map(Generator<K> genK,Generator<V> genV,int quantity){
		return new MapData<K,V>(genK,genV,quantity);
	}
	
	public static <K,V> MapData<K,V> map(Generator<K> genK,V value,int quantity){
		return new MapData<>(genK,value,quantity);
	}
	
	public static <K,V> MapData<K,V> map(Iterable<K> genK,Generator<V> genV){
		return new MapData<>(genK,genV);
	}
	
	public static <K,V> MapData<K,V> map(Iterable<K> genK,V value){
		return new MapData<>(genK, value);
	}
	
	public static void main(String[] args) {

	}

}
