package strategy2.modularization;

/*
 * 2020.12.11~ Lim JaeHyun
 */
import strategy2.component.EngineMid;
import strategy2.component.FuelGasoline;
import strategy2.component.Km15;

public class Sonata extends Car {
	public Sonata() {
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}

	@Override
	public void shape() {
		System.out.print("¼Ò³ªÅ¸ ");
		super.shape();
	}
}