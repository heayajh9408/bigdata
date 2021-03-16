package com.lec.homework;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Homework extends JFrame implements ActionListener {
	private Container container;
	private JPanel jpup;
	private JPanel jpdown;
	private JTextArea jta;
	private JScrollPane scrollbar;
	private JTextField txtPhone;
	private JTextField txtName;
	private JTextField txtPoint;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private HashMap<String, Customer> customers;

	public Homework(String title) {
		super(title);
		customers = new HashMap<String, Customer>();
		container = getContentPane();
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel(new FlowLayout());
		jta = new JTextArea(15, 30);
		scrollbar = new JScrollPane(jta);
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField("1000", 15);
		btn1 = new JButton("가입");
		btn2 = new JButton("폰조회");
		btn3 = new JButton("출력");
		btn4 = new JButton("종료");
		jpup.add(new JLabel("폰번호", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("포인트", (int) CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		jpdown.add(btn1);
		jpdown.add(btn2);
		jpdown.add(btn3);
		jpdown.add(btn4);
		container.add(jpup);
		container.add(jpdown);
		container.add(scrollbar);
		setVisible(true);
		setBounds(100, 100, 400, 450);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			String phone = txtPhone.getText().trim();
			String name = txtName.getText().trim();
			int point = 1000;
			try {
				point = Integer.parseInt(txtPoint.getText());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			if (!phone.equals("") && !name.equals("")) {
				Customer customer = new Customer(phone, name, point);
				customers.put(phone, customer);
				jta.append(customer.toString());
				txtPhone.setText("");
				txtName.setText("");
				txtPoint.setText("");
			}
		} else if (e.getSource() == btn2) {
			String search = txtPhone.getText().trim();
			int cnt = 0;
			Iterator<String> iterator = customers.keySet().iterator();
			while (iterator.hasNext()) {
				String phone = iterator.next();
				String post = phone.substring(phone.lastIndexOf('-') + 1);
				if (post.equals(search)) {
					txtPhone.setText(customers.get(phone).getPhone());
					txtName.setText(customers.get(phone).getName());
					txtPoint.setText(String.valueOf(customers.get(phone).getPoint()));
					break;
				}
				cnt++;
			}
			if (cnt == customers.size()) {
				txtPhone.setText("없는 번호입니다");
				txtName.setText("");
				txtPoint.setText("1000");
			}
		} else if (e.getSource() == btn3) {
			Writer writer = null;
			try {
				writer = new FileWriter("D:\\bigdata\\src\\1_Java\\ch20_gui\\icon/customer.txt");
				Iterator<String> iterator = customers.keySet().iterator();
				while (iterator.hasNext()) {
					String phone = iterator.next();
					writer.write(customers.get(phone).toString());
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			} finally {
				try {
					if (writer != null)
						writer.close();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		} else if (e.getSource() == btn4) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new Homework("회원관리");
	}
}
