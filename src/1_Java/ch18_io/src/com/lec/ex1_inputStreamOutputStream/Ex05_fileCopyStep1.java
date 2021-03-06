package com.lec.ex1_inputStreamOutputStream;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 1. 스트림객체생성(inputStream, outputStream) 2.읽고쓰기(반복) 3.스트림닫기
public class Ex05_fileCopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("txtFile/js.jpg"); // 입력
			os = new FileOutputStream("txtFile/jinsol.jpg"); // 출력
			int cnt = 0;
			while (true) {
				++cnt;
				int i = is.read(); // 1byte
				if (i == -1)
					break;
				os.write(i);
			}
			System.out.println(cnt + "번 반복문 실행 후 파일 복사 성공");

		} catch (FileNotFoundException e) {
			System.out.println("파일이나 폴더 못 찾음" + e.getMessage());
		} catch (IOException e) {
			System.out.println("읽고 쓸 때 예외남 " + e.getMessage());
		} finally {
			try {
				if (is != null)
					is.close();
				if (os != null)
					os.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}