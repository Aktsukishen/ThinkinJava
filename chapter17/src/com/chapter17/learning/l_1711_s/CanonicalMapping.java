package com.chapter17.learning.l_1711_s;

import java.util.WeakHashMap;

class Element{
	private String ident;
	public Element(String id){
		this.ident=id;
	}
	public String toString(){
		return ident;
	}
	public int hashCode(){
		return ident.hashCode();
	}
	public boolean equals(Object o){
		return o instanceof Element
			&& ident.equals(((Element)o).ident);
	}
	protected void finalize(){
		System.out.println("Finalizing:"+getClass().getSimpleName()+" "+ident);
	}
}

class Key extends Element{
	public Key(String id){
		super(id);
	}
}

class Value extends Element{
	public Value(String id){
		super(id);
	}
}

public class CanonicalMapping {

	public static void main(String[] args) {
		int size=100000;
		Key[] keys=new Key[size];
		WeakHashMap<Key,Value> map=new WeakHashMap<Key,Value>();
		for(int i=0;i<size;i++){
			Key k=new Key(Integer.toString(i));
			Value value=new Value(Integer.toString(i));
			if(i%3==0) keys[i]=k;
			map.put(k, value);
		}
		System.gc();
	}

}
