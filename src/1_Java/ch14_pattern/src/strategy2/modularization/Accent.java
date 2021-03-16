package strategy2.modularization;

/*
 * 2020.12.11~ Lim JaeHyun
 */
import strategy2.component.EngineLow;
import strategy2.component.FuelDiesel;
import strategy2.component.Km20;

public class Accent extends Car {
	public Accent() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}

	@Override
	public void shape() {
		System.out.print("¿¢¼¾Æ® ");
		super.shape();
	}
}
