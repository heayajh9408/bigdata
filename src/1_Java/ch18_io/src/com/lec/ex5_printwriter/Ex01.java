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
//			printWriter = new PrintWriter(writer); // 스트림객체생성
			printWriter = new PrintWriter("txtFile/out.txt");
			System.out.println("안녕하세요\n반갑습니다");
			printWriter.println("안녕하세요\r\n반갑습니다");
			System.out.print("개행자동 안될 예정\n");
			printWriter.print("개행 안 될 예정\r\n");
			System.out.printf("%5s %3d %3d %5.1f\n", "홍길동", 99, 98, 98.5);
			printWriter.printf("%5s %3d %3d %5.1f\r\n", "홍길동", 99, 98, 98.5);
			System.out.printf("%5s %3d %3d %5.1f\n", "김길동", 100, 100, 100.0);
			printWriter.printf("%5s %3d %3d %5.1f\r\n", "김길동", 100, 100, 100.0);
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