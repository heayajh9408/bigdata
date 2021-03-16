package strategy2.modularization;

/*
 * 2020.12.11~ Lim JaeHyun
 */
import strategy2.component.EngineImpl;
import strategy2.component.FuelImpl;
import strategy2.component.KmImpl;

public class Car {
	private EngineImpl engine;
	private KmImpl km;
	private FuelImpl fuel;

	public void shape() {
		System.out.println("door, sheet, handle가 있습니다.");
	}

	public void drive() {
		System.out.println("드라이브 할 수 있습니다.");
	}

	public void isEngine() {
		engine.engine();
	}

	public void isKm() {
		km.km();
	}

	public void isFuel() {
		fuel.fuel();
	}

	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}

	public void setKm(KmImpl km) {
		this.km = km;
	}

	public void setFuel(FuelImpl fuel) {
		this.fuel = fuel;
	}
}
