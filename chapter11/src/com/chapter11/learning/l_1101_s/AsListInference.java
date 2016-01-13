package com.chapter11.learning.l_1101_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow{}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}

public class AsListInference {

	public static void main(String[] args) {
		List<Snow> snow1=Arrays.asList(new Crusty(),new Slush(),new Powder());
		
		//Won't complie JDK5
		//使用最新的JDK8可以通过编译
		List<Snow> snow2=Arrays.asList(new Light(),new Heavy(),new Snow());
		
		List<Snow> snow3=new ArrayList<Snow>();
		Collections.addAll(snow3, new Light(),new Heavy());
		
		List<Snow> snow4=Arrays.<Snow>asList(new Light(),new Heavy());
	}

}
