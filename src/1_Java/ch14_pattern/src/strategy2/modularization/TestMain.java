package strategy2.modularization;

/*
 * 2020.12.11~ Lim JaeHyun
 */
import strategy2.component.FuelHybrid;
import strategy2.component.Km20;

public class TestMain {
	public static void main(String[] args) {
		Car genesis = new Genesis();
		Sonata sonata = new Sonata();
		Accent accent = new Accent();
		Car[] cars = { genesis, sonata, accent };
		for (Car car : cars) {
			car.shape();
			car.drive();
			car.isEngine();
			car.isKm();
			car.isFuel();
		} // for
		System.out.println("소나타의 연료를 하이브리드로, 연비를 20km/l");
		sonata.setFuel(new FuelHybrid()); // 연료 업그레이드
		sonata.setKm(new Km20());// 연비 업그레이드
		for (Car car : cars) {
			car.shape();
			car.drive();
			car.isEngine();
			car.isKm();
			car.isFuel();
		} // for
	}// main
}// class