package myAPP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Test {
	JFrame f = new JFrame("�����ĵ�¼����");
	JPanel p = new JPanel();
	JLabel l = new JLabel("ѧ  �� �� ");
	JLabel l2 = new JLabel("��  �� �� ");
	JLabel l3 = new JLabel("��֤�� �� ");
	JTextField t1 = new JTextField(25);
	JPasswordField t2 = new JPasswordField(25);
	JTextField t3 = new JTextField(25);
	JButton b1 = new JButton("��¼");
	JButton b2 = new JButton("ע��");
	JButton b3 = new JButton("�˳�");
	
	public Test() {
		
		f.setLayout(null);//ȥ��JFrameĬ�ϲ��ֹ�����
		f.setBounds(600, 400, 380, 350);//����JFrame(x, y, width, height)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		p.setBackground(Color.PINK);
		p.setLayout(null);//ȥ��JPanelĬ�ϲ��ֹ�����
		p.setBounds(0, 0, 380, 350);//����JPanel(x, y, width, height)
		
		l.setForeground(Color.BLUE);//��ǩһ
        l.setFont(new Font("����",Font.ITALIC,20));
		l.setBounds(20, 10, 100, 50);
		p.add(l);
		
		l2.setForeground(Color.BLUE);//��ǩ��
        l2.setFont(new Font("����",Font.ITALIC,20));
		l2.setBounds(20, 70, 100, 50);
		p.add(l2);
		
		l3.setForeground(Color.BLUE);//��ǩ��
        l3.setFont(new Font("����",Font.ITALIC,20));
		l3.setBounds(20, 130, 100, 50);
		p.add(l3);
		
		t1.setBounds(120, 20, 200, 30);//�˺��ı���
		p.add(t1);
		
		t2.setBounds(120, 80, 200, 30);//�����ı���
		p.add(t2);
		
		t3.setBounds(120, 140, 90, 30);//��֤���ı���
		p.add(t3);
		
		b1.setBounds(20, 230, 70, 30);//��¼��ť
		p.add(b1);
		
		b2.setBounds(145, 230, 70, 30);//��¼��ť
		p.add(b2);
		
		b3.setBounds(270, 230, 70, 30);//��¼��ť
		p.add(b3);
		
		final VerificationCode vc = new VerificationCode();//��֤��
		vc.setBounds(220, 140, 100, 46);
		p.add(vc);
		
		f.add(p);
		
		b1.addActionListener(new ActionListener() {//��¼��ť����
			@Override
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().equals("�����") && t2.getText().equals("zzh123456") && t3.getText().equals(vc.getSt())){//
					System.out.println("ok!");
					ChatWindow chatWindow = new ChatWindow();
					f.dispose();
				}
				
			}
		});
		
		b2.addActionListener(new ActionListener() {//ע�ᰴť����
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ע��");
				Register register = new Register();
				f.dispose();
			}
		});
		
		b3.addActionListener(new ActionListener() {//�˳���ť����
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
