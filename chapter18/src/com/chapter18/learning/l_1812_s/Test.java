package com.chapter18.learning.l_1812_s;

public class Test {
	public static void main(String[]args){
		String[] mValues="PLAY_RECORD|1||CJPL|WMDTEST04".split("\\|");
		String positionCode = mValues[0];
        String type = mValues[1];
        String videoClipCode = mValues[2];
        String itemCode = mValues[3];
        String categoryCode = mValues[4];
       System.out.println(categoryCode);
	
        
	}
}
