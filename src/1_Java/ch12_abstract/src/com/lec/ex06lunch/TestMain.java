package com.lec.ex06lunch;

/*
 * 2020.12.08~ Lim JaeHyun
 */
import com.lec.cons.PriceTable;

public class TestMain {
	public static void main(String[] args) {
		Child1 child1 = new Child1(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.SOUP, PriceTable.BANANA,
				PriceTable.MILK, PriceTable.ALMOND);
		Child2 child2 = new Child2(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.SOUP, PriceTable.BANANA,
				PriceTable.MILK, PriceTable.ALMOND);
		System.out.println("child1�� �Ĵ� : " + child1.calcuate());
		System.out.println("child2�� �Ĵ� : " + child2.calcuate());
	}
}