package ch84;

import java.awt.FlowLayout;

import javax.swing.*;

public class MYJFrame extends JFrame{
	public MYJFrame() {
		this.setTitle("JFrameTest");
		this.setSize(400,300);
		this.setLocation(400, 400);//���ô���λ��
	//	this.setBounds(400, 400,400, 300);//���ô����С��λ��
		JButton bt = new JButton("��ť");
		this.setLayout(new FlowLayout());//���ô���Ĳ��ֹ���������ʽ���ֹ�������
		this.add(bt);
		//���õ����رհ�ťʱ��Ĭ�ϲ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MYJFrame();
	}
}
