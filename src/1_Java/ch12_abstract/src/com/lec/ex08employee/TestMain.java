package com.lec.ex08employee;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		Employee[] employee = { new SalaryEmployee("ȫ�浿", 24000000), new SalaryEmployee("���浿", 26000000),
				new SalaryEmployee("�ϱ浿", 30000000), new HourlyEmployee("���浿", 10, 6500),
				new HourlyEmployee("�̱浿", 15, 6500), };
		for (Employee skt : employee) {
			System.out.println("~ ~ ~ ���޸��� ~ ~ ~");
			System.out.println("����: " + skt.getName());
			System.out.println("����: " + skt.computePay());
			int incentive = skt.computeIncentive();
			if (incentive != 0) {
				System.out.println("�μ�: " + incentive);
			}
			System.out.println("�����ϼ̽��ϴ�");
		}
	}
}
