package com.lec.ex2_dataInputStreamoutputStream;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.*;
import java.util.ArrayList;

public class Ex04_ProductList {
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();
		InputStream is = null;
		DataInputStream dis = null;
		try {
			is = new FileInputStream("txtFile/product.dat");
			dis = new DataInputStream(is);
			while (true) {
				String name = dis.readUTF();
				int price = dis.readInt();
				int ps = dis.readInt();
				products.add(new Product(name, price, ps));
			}
		} catch (IOException e) {
			System.out.println("리스트 입니다");
		} finally {
			try {
				if (dis != null)
					dis.close();
				if (is != null)
					is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		for (Product product : products) {
			System.out.println(product);
		}
	}
}
