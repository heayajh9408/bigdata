package com.lec.ex5_printwriter;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex01 {
	public static void main(String[] args) {
		PrintWriter printWriter = null;
		OutputStream os = null;
		Writer writer = null;
		try {
//			os = new FileOutputStream("txtFile/out.txt");
//			printWriter = new PrintWriter(os);
//			writer = new FileWriter("txtFile/out.txt");
//			printWriter = new PrintWriter(writer); // ��Ʈ����ü����
			printWriter = new PrintWriter("txtFile/out.txt");
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			printWriter.println("�ȳ��ϼ���\r\n�ݰ����ϴ�");
			System.out.print("�����ڵ� �ȵ� ����\n");
			printWriter.print("���� �� �� ����\r\n");
			System.out.printf("%5s %3d %3d %5.1f\n", "ȫ�浿", 99, 98, 98.5);
			printWriter.printf("%5s %3d %3d %5.1f\r\n", "ȫ�浿", 99, 98, 98.5);
			System.out.printf("%5s %3d %3d %5.1f\n", "��浿", 100, 100, 100.0);
			printWriter.printf("%5s %3d %3d %5.1f\r\n", "��浿", 100, 100, 100.0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (printWriter != null)
					printWriter.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}