package com.chapter18.learning.l_1812_s;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 
 * Class 在序列化和反序列化的过程中并不保存static变量的状态 
 * @author Administrator
 *
 */
public class RecoverCADState {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("Recove store");
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("resource/StoreCADState.txt"));
		List<Class<? extends Shape>> types=(List<Class<? extends Shape>>)in.readObject();
		Line.deserializeStaticState(in);
		List<Shape> outShapes=(List<Shape>) in.readObject();
		System.out.println(outShapes);
		in.close();
	}

}
