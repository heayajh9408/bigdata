package strategy1.step4.modularization;

/*
 * 2020.12.10~ Lim JaeHyun
 */
import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyNo;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.KnifeWood;
import strategy1.step4.component.MissileImpl;
import strategy1.step4.component.MissileYes;

public class StandardRobot extends Robot {
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;

	public StandardRobot() {// 날 수 X. 미사일을 쏠 수 O. 목검
		fly = new FlyNo();
		missile = new MissileYes();
		knife = new KnifeWood();
//		setFly(new FlyNo());
//		setMissile(new MissileYes());
//		setKnife(new KnifeWood());
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
