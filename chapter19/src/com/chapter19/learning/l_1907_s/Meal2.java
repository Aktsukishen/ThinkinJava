package com.chapter19.learning.l_1907_s;

import com.chapter19.learning.l_1906_s.Enums;

public enum Meal2 {
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCource.class),
	DESERT(Food.Desert.class),
	COFFEE(Food.Coffee.class);
	private Food[] values;
	private Meal2(Class<? extends Food> kind){
		values=kind.getEnumConstants();
	}
	public interface Food{
		enum Appetizer implements Food{
			SALAD,SOUP,SPRING_ROLLS;
		}
		enum MainCource implements Food{
			LASAGNE,BURRITO,PAD_THAI,
			LENTILS,HUMMOUS,VINDALOO;
		}
		enum Desert implements Food{
			TIRAMISU,GELATO,BALCK_FOREST_CAKE,
			FRUIT,CREME_CARAMEL;
		}
		enum Coffee  implements Food{
			BLACK_COFFEE,DECAF_COFFEE,ESPRESSO,
			LATTE,CAPPSUCCINO,TEA,HERB_TEA;
		}
	}
	public Food randomSelection(){
		return Enums.random(values);
	}
}
