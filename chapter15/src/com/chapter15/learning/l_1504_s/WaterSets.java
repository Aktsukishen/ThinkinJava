package com.chapter15.learning.l_1504_s;

import java.util.EnumSet;
import java.util.Set;

import static com.chapter15.learning.l_1504_s.WaterColors.*;

public class WaterSets {

	public static void main(String[]args){
		Set<WaterColors> set1=EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
		Set<WaterColors> set2=EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
		System.out.println(set1);
		System.out.println(set2);
		System.out.println("union:"+Sets.union(set1, set2));
		System.out.println("intersection:"+Sets.intersection(set1, set2));
		System.out.println("diff:"+Sets.diff(set1, set2));
		System.out.println("complement:"+Sets.complement(set1, set2));
	}
	
}
