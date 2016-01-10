package com.chapter20.learning.l_2001_s;

public class Testable {
	
	public void execute(){
		System.out.println("Executing....");
	}
	
	@Test void testExecute(){
		execute();
	}
}
