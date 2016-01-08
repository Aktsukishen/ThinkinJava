package com.chapter18.learning.l_1812_s;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class Blip1 implements Externalizable {

	Blip1(){
		System.out.println("Blip1 Consructor");
	}
	
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		System.out.println("Blip1.readExternal");
	}

	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		System.out.println("Blip1.writeExternal");
	}

}

class Blip2 implements Externalizable{
	Blip2(){
		System.out.println("Blip2 Consructor");
	}
	
}
