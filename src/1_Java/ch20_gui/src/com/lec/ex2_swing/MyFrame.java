package com.lec.ex2_swing;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener {
	private Container container;
	private JPanel jp1;
	private JPanel jp2;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAge;
	private JButton btn1;
	private JButton btn2;
	private ImageIcon icon;
	private ArrayList<Person> person;

	public MyFrame(String title) {
		super(title);
		person = new ArrayList<Person>();
		container = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jp1 = new JPanel(new GridLayout(3, 2));
		jp2 = new JPanel(new FlowLayout());
		txtName = new JTextField();
		txtPhone = new JTextField();
		txtAge = new JTextField();
		icon = new ImageIcon("D:\\bigdata\\src\\1_Java\\ch20_gui\\icon/logo.gif");
		btn1 = new JButton("입력", icon);
		btn2 = new JButton("출력", icon);
		jp1.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jp1.add(txtName);
		jp1.add(new JLabel("전화", (int) CENTER_ALIGNMENT));
		jp1.add(txtPhone);
		jp1.add(new JLabel("나이", (int) CENTER_ALIGNMENT));
		jp1.add(txtAge);
		jp2.add(btn1);
		jp2.add(btn2);
		container.add(jp1, BorderLayout.CENTER);
		container.add(jp2, BorderLayout.SOUTH);
		setVisible(true);
		setBounds(100, 100, 300, 200);
		pack();
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			String name = txtName.getText();
			String phone = txtPhone.getText();
			int age;
			try {
				age = Integer.parseInt(txtAge.getText());
			} catch (Exception ex) {
				age = -1;
			}
			if (name.equals("") || phone.equals("")) {
				System.out.println("이름과 전화번호는 꼭 입력해주세요");
				return;
			}
			if (age < 0 || age > 130) {
				System.out.println("유효한 나이를 입력해주세요");
			} else {
				person.add(new Person(name, phone, age));
				txtName.setText("");
				txtPhone.setText("");
				txtAge.setText("");
			}
		} else if (e.getSource() == btn2) {
			for (Person persons : person) {
				System.out.print(persons);
			}
			Writer writer = null;
			try {
				writer = new FileWriter("D:\\bigdata\\src\\1_Java\\ch20_gui\\icon/person.txt");
				for (Person persons : person) {
					writer.write(persons.toString());
				}
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			} finally {
				try {
					if (writer != null)
						writer.close();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}

		}

	}

	public static void main(String[] args) {
		new MyFrame("GUI 예제");
	}
}
