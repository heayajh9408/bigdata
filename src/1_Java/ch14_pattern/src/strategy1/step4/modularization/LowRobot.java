package strategy1.step4.modularization;

/*
 * 2020.12.10~ Lim JaeHyun
 */
import strategy1.step4.component.*;

public class LowRobot extends Robot {
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;

	public LowRobot() {
		fly = new FlyNo();
		missile = new MissileNo();
		knife = new KnifeNo();
//		setFly(new FlyNo());
//		setMissile(new MissileNo());
//		setKnife(new KnifeNo());
	}

	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
	public void actionKnife() {
		knife.knife();
	}

	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}
}