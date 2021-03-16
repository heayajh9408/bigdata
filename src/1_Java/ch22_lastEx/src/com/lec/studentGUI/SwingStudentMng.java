package com.lec.studentGUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingStudentMng extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtSNo, txtSName, txtScore;
	private Vector<String> mNames; // �޺��ڽ��� �� ��������Ʈ�� ���� vector
	private JComboBox<String> comMname;
	private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch;
	private JButton btnInput, btnUpdate;
	private JButton btnStudentOut, btnExpelOut, btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	StudentSwingDao dao = StudentSwingDao.getInstance();

	public SwingStudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane(); // ȭ�鱸��
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel(new FlowLayout());
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		mNames = dao.getMNamelist();
		comMname = new JComboBox<String>(mNames);
		txtScore = new JTextField(10);
		btnSNoSearch = new JButton("�й��˻�");
		btnSNameSearch = new JButton("�̸��˻�");
		btnMNameSearch = new JButton("�����˻�");
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpelOut = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(600, 400));
		setLocation(200, 150);
		setVisible(true);
		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSNoSearch) { // �й� �˻�
			String sNo = txtSNo.getText().trim();
			if (sNo.equals("")) {
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("�й��� �Է� �� �й� �˻��� �ϼ���");
				return;
			} // if - �й��� �Է����� ���� ���
			StudentSwingDto dto = dao.sNogetStudent(sNo);
			if (dto != null) { // �ش� �й��� DB�� �˻��� ���
				txtSName.setText(dto.getsName());
				comMname.setSelectedItem(dto.getmName());
				// txtScore.setText(""+dto.getScore()); // score���� ��Ʈ������ �ٲ㼭 txtField�� ����
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText(sNo + " �˻� �Ϸ�");
			} else { // �ش� �й��� DB�� ���� ���
				txtSName.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
				txtPool.setText(sNo + "�� ��ȿ���� �ʴ� �й��Դϴ�");
			} // if
		} else if (e.getSource() == btnSNameSearch) { // �̸� �˻�
			String sName = txtSName.getText().trim();
			if (sName.length() == 0) {
				txtSNo.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("�̸��� �Է��ϰ� �˻��ؾ���");
				return;
			} // if - �̸��� �Է����� ���� ���
			ArrayList<StudentSwingDto> students = dao.sNamegetStudent(sName);
			if (students.size() > 1) {
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtPool.append("\t����������������������������������������������������\n");
				for (StudentSwingDto student : students) {
					txtPool.append("\t" + student.toString() + "\n");
					txtSNo.setText(student.getsNo());
					comMname.setSelectedItem(student.getmName());
					// txtScore.setText(""+student.getScore());
					txtScore.setText(String.valueOf(student.getScore()));
				} // for
			} else if (students.size() == 1) {
				txtSNo.setText(students.get(0).getsNo());
				comMname.setSelectedItem(students.get(0).getmName());
				// txtScore.setText(""+students.get(0).getScore());
				txtScore.setText(String.valueOf(students.get(0).getScore()));
			} else {
				txtSNo.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
				txtPool.setText("�ش� �̸��� �л��� �����ϴ�");
			} // if
		} else if (e.getSource() == btnMNameSearch) {// �����˻�
			txtSNo.setText("");
			txtSName.setText("");
			txtScore.setText("");
			String mName = comMname.getSelectedItem().toString();
			if (mName.equals("")) {
				txtPool.setText("������ �����ϰ� �˻��ؾ���");
				return;
			}
			ArrayList<StudentSwingDto> students = dao.mNamegetStudent(mName);
			if (students.size() != 0) {
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtPool.append("\t����������������������������������������������������\n");
				for (StudentSwingDto student : students) {
					txtPool.append("\t" + student.toString() + "\n");
				} // for
			} else {
				txtPool.setText("�ش� �а��� �л��� �����ϴ�");
			} // if
		} else if (e.getSource() == btnInput) {// �л��Է�
			String sName = txtSName.getText().trim();
			String mName = comMname.getSelectedItem().toString();
			if (sName.equals("") || mName.equals("")) {
				txtPool.setText("�л��Է½� �й�, �̸�, ������ �Է��ؾ���");
				return;
			}
			txtPool.setText("");
			int score = 0;
			try {
				score = Integer.parseInt(txtScore.getText().trim());
				if (score < 0 || score > 100) {
					txtPool.append("��ȿ�� ������ �ƴϸ� 0�� ó��\n");
					score = 0;
				}
			} catch (NumberFormatException e1) {
				txtPool.append("������ �Է� �� �ϰų� ���ڷ� �Է��ϸ� 0�� ó��\n");
			} // try-catch (score �Է�)
//			StudentSwingDto newStudent = new StudentSwingDto(0, sName, mName, score);
//			int result = dao.insertStudent(newStudent);
			int result = dao.insertStudent(sName, mName, score);
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.append(sName + " �л� �Է� ����");
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			} // if
		} else if (e.getSource() == btnUpdate) { // �л�����
			String sNo = txtSNo.getText().trim();
			String sName = txtSName.getText().trim();
			String mName = comMname.getSelectedItem().toString();
			if (sNo.equals("") || sName.equals("") || mName.equals("")) {
				txtPool.setText("�л������� �й�, �̸�, ������ �Է��ؾ���");
				return;
			}
			txtPool.setText("");
			int score = 0;
			try {
				score = Integer.parseInt(txtScore.getText().trim());
				if (score < 0 || score > 100) {
					txtPool.append("��ȿ�� ������ �ƴϸ� 0�� ó��");
					score = 0;
				}
			} catch (NumberFormatException e1) {
				txtPool.append("������ �Է� �� �ϰų� ���ڷ� �Է��ϸ� 0�� ó��");
			} // try-catch (score �Է�)
			StudentSwingDto student = new StudentSwingDto(sNo, sName, mName, score);
			int result = dao.updateStudent(student);
//			result = dao.updateStudent(sNo, sName, mName, score);
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.append(sName + " �л� �Է� ����");
			} // if
		} else if (e.getSource() == btnStudentOut) { // �л����(����������)
			txtSNo.setText("");
			txtSName.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			ArrayList<StudentSwingDto> students = dao.getStudents();
			if (students.size() != 0) {
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtPool.append("\t����������������������������������������������������\n");
				for (StudentSwingDto student : students) {
					txtPool.append("\t" + student.toString() + "\n");
				} // for
			} else {
				txtPool.setText("�л��� �����ϴ�");
			} // if
		} else if (e.getSource() == btnExpelOut) { // �����ڸ� ���
			txtSNo.setText("");
			txtSName.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			ArrayList<StudentSwingDto> students = dao.getStudentsExpel();
			if (students.size() != 0) {
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtPool.append("\t����������������������������������������������������\n");
				for (StudentSwingDto student : students) {
					txtPool.append("\t" + student.toString() + "\n");
				} // for
			} else {
				txtPool.setText("�����ڰ� �����ϴ�");
			} // if
		} else if (e.getSource() == btnExpel) { // ����ó��
			String sNo = txtSNo.getText().trim();
			if (sNo.length() == 0) {
				txtPool.setText("�й��� �Է��ϰ� ����ó���ؾ���");
				return;
			}
			int result = dao.sNoExpel(sNo);
			if (result == StudentSwingDao.SUCCESS) {
				txtPool.setText(sNo + " �л� ���� ó�� �Ϸ�");
			} // if
		} else if (e.getSource() == btnExit) { // �����ư
			setVisible(false);
			dispose();
			System.exit(0);
		} // if - e.getSource()
	}// actionPerformed

	public static void main(String[] args) {
		new SwingStudentMng("�л����");
	}// main
}// class