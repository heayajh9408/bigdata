package strategy2.component;

/*
 * 2020.12.11~ Lim JaeHyun
 */
public class FuelHybrid implements FuelImpl {

	@Override
	public void fuel() {
		System.out.println("하이브리드 차량입니다");
	}

}