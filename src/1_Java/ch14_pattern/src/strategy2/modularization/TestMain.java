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
		System.out.println("�ҳ�Ÿ�� ���Ḧ ���̺긮���, ���� 20km/l");
		sonata.setFuel(new FuelHybrid()); // ���� ���׷��̵�
		sonata.setKm(new Km20());// ���� ���׷��̵�
		for (Car car : cars) {
			car.shape();
			car.drive();
			car.isEngine();
			car.isKm();
			car.isFuel();
		} // for
	}// main
}// class