package strategy2.modularization;

/*
 * 2020.12.11~ Lim JaeHyun
 * ��� �ڵ����� �⺻������ drive�� �� �־�� �մϴ�.
 * �ڵ��� ����� door, sheet, handle�� �̷���� �ֽ��ϴ�.
 * �ְ�޿���(EngineHigh).  ���� 10Km/l(Km10). �ֹ���(FuelGasoline)
 */
import strategy2.component.*;

public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}

	@Override
	public void shape() {
		System.out.print("���׽ý� ");
		super.shape();
	}
}