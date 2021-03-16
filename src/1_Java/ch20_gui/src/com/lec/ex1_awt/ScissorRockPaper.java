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
		btn1 = new Button("가위");
		btn2 = new Button("바위");
		btn3 = new Button("보");
		btn4 = new Button("종료");
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
		int computer = (int) (Math.random() * 3);// 0가위,1바위,2보
		if (e.getSource() == btn1) {// 가위
			switch (computer) {
			case 0:
				list.add("비김. 우리 다 가위");
				break;
			case 1:
				list.add("컴퓨터가 이김. 당신은 가위, 컴퓨터는 바위");
				break;
			case 2:
				list.add("당신이 이김. 당신은 가위, 컴퓨터는 보");
				break;
			}
		} else if (e.getSource() == btn2) {// 바위
			switch (computer) {
			case 0:
				list.add("당신이 이김. 당신이 바위, 컴퓨터는 가위");
				break;
			case 1:
				list.add("비김. 당신과 컴퓨터 모두 바위");
				break;
			case 2:
				list.add("컴퓨터가 이김. 당신은 바위, 컴퓨터는 보");
				break;
			}
		} else if (e.getSource() == btn3) {// 보
			switch (computer) {
			case 0:
				list.add("컴퓨터가 이김. 당신이 보, 컴퓨터는 가위");
				break;
			case 1:
				list.add("당신이 이김. 당신 보, 컴퓨터는 바위");
				break;
			case 2:
				list.add("비김. 당신과 컴퓨터 모두 보");
				break;
			}
		} else if (e.getSource() == btn4) {// 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new ScissorRockPaper("가위바위보 게임");
	}

}
