package strategy1.step4.modularization;

/*
 * 2020.12.10~ Lim JaeHyun
 */
import strategy1.step4.component.FlyHigh;
import strategy1.step4.component.FlyYes;

public class TestMain {
	public static void main(String[] args) {
		SuperRobot superRobot = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot lowRobot = new LowRobot();
		Robot[] robots = { superRobot, standardRobot, lowRobot };
		for (Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		// LowRobot�� �� �� �ִ� �κ����� ���׷��̵� ��û
		lowRobot.setFly(new FlyYes());
		// SuperRobot ���� ��ǰ ���׷��̵�
		superRobot.setFly(new FlyHigh());
		System.out.println("���׷��̵� ��");
		for (Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
	}
}
