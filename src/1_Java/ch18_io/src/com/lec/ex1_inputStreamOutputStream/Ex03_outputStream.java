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
			os = new FileOutputStream("txtFile/out.txt"); // 1.파일열기(스트림객체생성)
			byte[] bs = { 'H', 'e', 'l', 'l', 'o', '\r', '\n', 'J', 'A', 'V', 'A' };
			for (int i = 0; i < bs.length; i++) {
				os.write(bs[i]); // 2.파일에 데이터 쓰기(반복)
			}
			System.out.println("성공");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close(); // 3.파일 닫기
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}