package strategy1.step3;

/*
 * 2020.12.10~ Lim JaeHyun
 */
public class StandardRobot extends Robot {

	@Override
	public void actionFly() {
		System.out.println("�� �� �����ϴ�");
	}

	@Override
	public void actionMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
	}

	@Override
	public void actionKnife() {
		System.out.println("����� �ֽ��ϴ�.");
	}
}
