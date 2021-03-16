package com.lec.ex2_dataInputStreamoutputStream;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null;
		try { // 보조스트림은 기본스트림을 통해서만 생성
			fos = new FileOutputStream("txtFile/dataFile.dat");
			dos = new DataOutputStream(fos);
			dos.writeUTF("홍길동"); // 스트링 값 저장
			dos.writeInt(2); // int값 저장
			dos.writeDouble(95.9);// double 값 저장
			System.out.println("저장 완료");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}