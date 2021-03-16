package com.lec.ex08employee;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		Employee[] employee = { new SalaryEmployee("홍길동", 24000000), new SalaryEmployee("강길동", 26000000),
				new SalaryEmployee("암길동", 30000000), new HourlyEmployee("정길동", 10, 6500),
				new HourlyEmployee("이길동", 15, 6500), };
		for (Employee skt : employee) {
			System.out.println("~ ~ ~ 월급명세서 ~ ~ ~");
			System.out.println("성함: " + skt.getName());
			System.out.println("월급: " + skt.computePay());
			int incentive = skt.computeIncentive();
			if (incentive != 0) {
				System.out.println("인센: " + incentive);
			}
			System.out.println("수고하셨습니다");
		}
	}
}
