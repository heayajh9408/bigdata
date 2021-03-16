package strategy1.step4.component;

/*
 * 2020.12.10~ Lim JaeHyun
 */
public class MissileYes implements MissileImpl {

	@Override
	public void missile() {
		System.out.println("미사일을 쏠 수 있습니다");
	}
}