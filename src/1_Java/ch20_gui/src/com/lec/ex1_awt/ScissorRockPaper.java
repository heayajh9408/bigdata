package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScissorRockPaper extends Frame implements ActionListener {
	private Panel panel;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private List list;

	public ScissorRockPaper(String title) {
		super(title);
		setLayout(new BorderLayout());
		panel = new Panel(new FlowLayout());
		btn1 = new Button("����");
		btn2 = new Button("����");
		btn3 = new Button("��");
		btn4 = new Button("����");
		list = new List();
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		add(btn4, BorderLayout.SOUTH);
		setSize(new Dimension(400, 200));
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int computer = (int) (Math.random() * 3);// 0����,1����,2��
		if (e.getSource() == btn1) {// ����
			switch (computer) {
			case 0:
				list.add("���. �츮 �� ����");
				break;
			case 1:
				list.add("��ǻ�Ͱ� �̱�. ����� ����, ��ǻ�ʹ� ����");
				break;
			case 2:
				list.add("����� �̱�. ����� ����, ��ǻ�ʹ� ��");
				break;
			}
		} else if (e.getSource() == btn2) {// ����
			switch (computer) {
			case 0:
				list.add("����� �̱�. ����� ����, ��ǻ�ʹ� ����");
				break;
			case 1:
				list.add("���. ��Ű� ��ǻ�� ��� ����");
				break;
			case 2:
				list.add("��ǻ�Ͱ� �̱�. ����� ����, ��ǻ�ʹ� ��");
				break;
			}
		} else if (e.getSource() == btn3) {// ��
			switch (computer) {
			case 0:
				list.add("��ǻ�Ͱ� �̱�. ����� ��, ��ǻ�ʹ� ����");
				break;
			case 1:
				list.add("����� �̱�. ��� ��, ��ǻ�ʹ� ����");
				break;
			case 2:
				list.add("���. ��Ű� ��ǻ�� ��� ��");
				break;
			}
		} else if (e.getSource() == btn4) {// ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new ScissorRockPaper("���������� ����");
	}

}
