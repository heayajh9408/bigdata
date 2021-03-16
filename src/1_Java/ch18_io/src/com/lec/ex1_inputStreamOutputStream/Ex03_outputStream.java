package com.lec.ex1_inputStreamOutputStream;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/out.txt"); // 1.���Ͽ���(��Ʈ����ü����)
			byte[] bs = { 'H', 'e', 'l', 'l', 'o', '\r', '\n', 'J', 'A', 'V', 'A' };
			for (int i = 0; i < bs.length; i++) {
				os.write(bs[i]); // 2.���Ͽ� ������ ����(�ݺ�)
			}
			System.out.println("����");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close(); // 3.���� �ݱ�
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}