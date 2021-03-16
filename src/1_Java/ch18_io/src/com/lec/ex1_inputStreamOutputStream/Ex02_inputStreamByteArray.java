package com.lec.ex1_inputStreamOutputStream;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. ���� ����  2.�д´� 3.������ �ݴ´�
public class Ex02_inputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/1.txt");// 1�ܰ�
			byte[] bs = new byte[10];
			while (true) {
				// int i = is.read(); 1byte��
				int readByteCount = is.read(bs);
				if (readByteCount == -1)
					break;
				for (int i = 0; i < readByteCount; i++) {
					System.out.print((char) bs[i]);
				} // for
			} // while

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (is != null)
					is.close();// 3�ܰ�
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} // close() try-catch
		} // try
	}// main
}