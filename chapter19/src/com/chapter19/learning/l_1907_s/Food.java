package com.chapter19.learning.l_1907_s;

/**
 * 对于enum而言，实现接口是使其子类化的唯一办法，所有嵌入在Food中的每个enum都实现了Food接口。
 * @author li.shensong
 *
 */
public interface Food {
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
