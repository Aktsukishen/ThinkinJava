package com.chapter18.learning.l_1812_s;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 
 * Class �����л��ͷ����л��Ĺ����в�������static������״̬ 
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
