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
		try { // true추가시 : 파일에 append, 없으면 덮어씀
			os = new FileOutputStream("txtFile/out.txt", true); // 1. 스트림객체생성
			String str = "모두 다 안녕이 필요한 시국\r\n";
			byte[] bs = str.getBytes(); // 스트링을 바이트배열로
			os.write(bs); // 2. 파일쓰기
		} catch (FileNotFoundException e) {
			System.out.println("파일못찾음 " + e.getMessage());
		} catch (IOException e) {
			System.out.println("파일 쓰기오류 " + e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (Exception ignore) {
			}
		}
	}
}