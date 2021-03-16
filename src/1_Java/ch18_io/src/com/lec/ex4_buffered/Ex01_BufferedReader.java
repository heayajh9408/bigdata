package com.lec.ex4_buffered;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_BufferedReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/1.txt");
			br = new BufferedReader(reader);
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
}