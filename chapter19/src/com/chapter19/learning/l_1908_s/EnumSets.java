package com.chapter19.learning.l_1908_s;

import java.util.EnumSet;

public class EnumSets {

	public static void main(String[] args) {
		EnumSet<AlarmPoints>points = EnumSet.noneOf(AlarmPoints.class);
		points.add(AlarmPoints.BATHROOM);
		System.out.println("1:"+points);
		points.addAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN));
		System.out.println("2:"+points);
		points=EnumSet.allOf(AlarmPoints.class);
		points.removeAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN));
		System.out.println("3:"+points);
		points.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
		System.out.println("4:"+points);
		points=EnumSet.complementOf(points);
		System.out.println("5:"+points);
	}

}
