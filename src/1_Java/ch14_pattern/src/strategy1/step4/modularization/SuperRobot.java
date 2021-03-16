package strategy1.step4.modularization;

/*
 * 2020.12.10~ Lim JaeHyun
 */
import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyYes;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.KnifeLazer;
import strategy1.step4.component.MissileImpl;
import strategy1.step4.component.MissileYes;

// 날수있음.미사일쏨.레이저검
public class SuperRobot extends Robot {
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;

	public SuperRobot() {
		// 부품들 생성
		fly = new FlyYes();
		missile = new MissileYes();
		knife = new KnifeLazer();
//		setFly(new FlyYes());
//		setMissile(new MissileYes());
//		setKnife(new KnifeLazer());
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