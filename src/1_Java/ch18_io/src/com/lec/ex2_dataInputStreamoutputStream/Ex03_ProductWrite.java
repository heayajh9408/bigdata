package com.lec.ex2_dataInputStreamoutputStream;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_ProductWrite {
	public static void main(String[] args) {
		// n�� �Է��Ҷ����� ����Է�(���Ǹ�, ����, ������)�޾� ���Ͽ� ����
		Scanner scanner = new Scanner(System.in);
		String answer;
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txtFile/product.dat", true);
			dos = new DataOutputStream(fos);
			while (true) {
				System.out.print("��� �� �ֳ���(Y/N)?");
				answer = scanner.next();
				if (answer.equalsIgnoreCase("n")) {
					break;
				} else if (answer.equalsIgnoreCase("y")) {
					System.out.print("�Է��� ����� ���Ǹ��� ? ");
					dos.writeUTF(scanner.next());
					System.out.print("�Է��� ��� ������ ������ ?");
					dos.writeInt(scanner.nextInt());
					System.out.print("�Է��� ��� ������ ������? ");
					dos.writeInt(scanner.nextInt());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}