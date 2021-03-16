package strategy2.component;

/*
 * 2020.12.11~ Lim JaeHyun
 */
public class FuelGasoline implements FuelImpl {

	@Override
	public void fuel() {
		System.out.println("휘발유 차량입니다");
	}

}