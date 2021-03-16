package com.lec.ex1_inputStreamOutputStream;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1.����������(��Ʈ����ü����) 2. �����͸��д´�(1byte������ �ݺ�) 3.�������ݴ´�
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is = null; // try-catch�� ���� ��Ʈ�� ���� ����
		try {
			is = new FileInputStream("txtFile/1.txt"); // 1�ܰ�:���Ͽ���
			// 2. �������б�(1byte������ �ݺ�)
			while (true) {
				int i = is.read(); // 1byte �б�
				if (i == -1)
					break;
				// System.out.println((char)i +" -�ƽ�Ű�ڵ� : "+i);
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			// 3. ���� �ݱ�
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
			}
		} // try-catch-finally
	}// main
}