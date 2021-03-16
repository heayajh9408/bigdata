package com.lec.ex1_inputStreamOutputStream;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1.파일을연다(스트림객체생성) 2. 데이터를읽는다(1byte단위로 반복) 3.파일을닫는다
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is = null; // try-catch절 전에 스트림 변수 선언
		try {
			is = new FileInputStream("txtFile/1.txt"); // 1단계:파일열기
			// 2. 데이터읽기(1byte단위로 반복)
			while (true) {
				int i = is.read(); // 1byte 읽기
				if (i == -1)
					break;
				// System.out.println((char)i +" -아스키코드 : "+i);
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			// 3. 파일 닫기
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
			}
		} // try-catch-finally
	}// main
}