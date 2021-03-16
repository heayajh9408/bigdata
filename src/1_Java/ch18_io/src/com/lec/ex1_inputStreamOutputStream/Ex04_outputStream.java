package com.lec.ex1_inputStreamOutputStream;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try { // true�߰��� : ���Ͽ� append, ������ ���
			os = new FileOutputStream("txtFile/out.txt", true); // 1. ��Ʈ����ü����
			String str = "��� �� �ȳ��� �ʿ��� �ñ�\r\n";
			byte[] bs = str.getBytes(); // ��Ʈ���� ����Ʈ�迭��
			os.write(bs); // 2. ���Ͼ���
		} catch (FileNotFoundException e) {
			System.out.println("���ϸ�ã�� " + e.getMessage());
		} catch (IOException e) {
			System.out.println("���� ������� " + e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (Exception ignore) {
			}
		}
	}
}