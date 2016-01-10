package com.chapter20.learning.l_2005_s;

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

public class AtUnitExample1 {

	public String methodOne(){
		return "This is methodOne";
	}
	
	public int methodTwo(){
		System.out.println("This is methodTwo");
		return 2;
	}
	
	@Test boolean methodTest(){
		return methodOne().equals("This is methodOne");
	}
	
	@Test boolean failureTest(){
		return false;
	}
	
}
