package com.lec.ex4_buffered;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

// 키보드로부터 파일이름을 받아 해당파일 출력
public class Ex02_BufferedReaderKeyboard {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		Reader reader = null;
		BufferedReader br = null;
		System.out.print("읽어올 파일 이름은?");
		try { // txtFile/1.txt
			String filename = keyboard.readLine();
			File file = new File(filename);// 입력한 파일이름의 파일객체
			if (file.exists()) {
				reader = new FileReader(file);
				br = new BufferedReader(reader);
				while (true) {
					String line = br.readLine();
					if (line == null)
						break;
					System.out.println(line);
				}
			} else {
				System.out.println("입력하신 파일이 존재하지 않습니다");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				if (reader != null)
					reader.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}