package strategy2.component;

/*
 * 2020.12.11~ Lim JaeHyun
 */
public class FuelDiesel implements FuelImpl {

	@Override
	public void fuel() {
		System.out.println("경유 차량입니다");
	}

}