package com.lec.ex08robot;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public class RobotOrder {
	public void action(Robot robot) {
		if (robot instanceof DanceRobot) {
			DanceRobot dRobot = (DanceRobot) robot;
			dRobot.dance();
		} else if (robot instanceof SingRobot) {
			// ((SingRobot)robot).sing();
			SingRobot sRobot = (SingRobot) robot;
			sRobot.sing();
		} else if (robot instanceof DrawRobot) {
			// ((DrawRobot)robot).draw();
			DrawRobot dRobot = (DrawRobot) robot;
			dRobot.draw();
		}
	}
}
