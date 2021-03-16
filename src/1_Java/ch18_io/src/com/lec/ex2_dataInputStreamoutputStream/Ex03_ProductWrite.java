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
		// n를 입력할때까지 재고입력(물건명, 가격, 재고수량)받아 파일에 저장
		Scanner scanner = new Scanner(System.in);
		String answer;
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txtFile/product.dat", true);
			dos = new DataOutputStream(fos);
			while (true) {
				System.out.print("재고가 더 있나요(Y/N)?");
				answer = scanner.next();
				if (answer.equalsIgnoreCase("n")) {
					break;
				} else if (answer.equalsIgnoreCase("y")) {
					System.out.print("입력할 재고의 물건명은 ? ");
					dos.writeUTF(scanner.next());
					System.out.print("입력할 재고 물건의 가격은 ?");
					dos.writeInt(scanner.nextInt());
					System.out.print("입력할 재고 물건의 수량은? ");
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