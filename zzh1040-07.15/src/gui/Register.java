package gui;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
public class Register extends JFrame{
	JFrame f1 = new JFrame("������ע�ᴰ��");
	JPanel p1 = new JPanel();
	JLabel l = new JLabel("��    ���� ");
	JLabel l2 = new JLabel("ѧ    �ţ� ");
	JLabel l3 = new JLabel("��    �� ");
	JLabel l4 = new JLabel("�������ڣ� ");
	JLabel l5 = new JLabel("��ͥסַ�� ");
	JLabel l6 = new JLabel("��ϵ�绰�� ");
	JLabel l7 = new JLabel("��    �룺 ");
	JLabel l8 = new JLabel("ȷ�����룺 ");
	JTextField t1 = new JTextField(25);
	JTextField t2 = new JTextField(25);
	JComboBox t3 = new JComboBox();
	JTextField t4 = new JTextField(25);
	JComboBox t5 = new JComboBox();
	JTextField t6 = new JTextField(25);
	JPasswordField t7 = new JPasswordField(25);
	JPasswordField t8 = new JPasswordField(25);
	JButton b1 = new JButton("����");
	JButton b2 = new JButton("�ύ");
	JButton b3 = new JButton("ȷ��");
	JButton b4 = new JButton("ȡ��");
	final JDialog jd = new JDialog(f1, "�ύ", true);
	final JLabel label = new JLabel();
	public Register() {
		f1.setLayout(null);//ȥ��JFrameĬ�ϲ��ֹ�����
		f1.setBounds(600, 400, 400, 400);//����JFrame(x, y, width, height)
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
		
		p1.setBackground(Color.PINK);
		p1.setLayout(null);//ȥ��JPanelĬ�ϲ��ֹ�����
		p1.setBounds(0, 0, 385, 355);//����JPanel(x, y, width, height)
		
		l.setForeground(Color.BLUE);//������ǩ
        l.setFont(new Font("����",Font.ITALIC,20));
		l.setBounds(20, 10, 150, 40);
		p1.add(l);
		
		l2.setForeground(Color.BLUE);//ѧ�ű�ǩ
        l2.setFont(new Font("����",Font.ITALIC,20));
		l2.setBounds(20, 40, 150, 40);
		p1.add(l2);
		
		l3.setForeground(Color.BLUE);//�Ա��ǩ
        l3.setFont(new Font("����",Font.ITALIC,20));
		l3.setBounds(20, 70, 150, 40);
		p1.add(l3);
		
		l4.setForeground(Color.BLUE);//�������ڱ�ǩ
        l4.setFont(new Font("����",Font.ITALIC,20));
		l4.setBounds(20, 100, 150, 40);
		p1.add(l4);
		
		l5.setForeground(Color.BLUE);//��ͥסַ��ǩ
        l5.setFont(new Font("����",Font.ITALIC,20));
		l5.setBounds(20, 130, 150, 40);
		p1.add(l5);
		
		l6.setForeground(Color.BLUE);//��ϵ�绰��ǩ
        l6.setFont(new Font("����",Font.ITALIC,20));
		l6.setBounds(20, 160, 150, 40);
		p1.add(l6);
		
		l7.setForeground(Color.BLUE);//�����ǩ
        l7.setFont(new Font("����",Font.ITALIC,20));
		l7.setBounds(20, 190, 150, 40);
		p1.add(l7);
		
		l8.setForeground(Color.BLUE);//ȷ�������ǩ
        l8.setFont(new Font("����",Font.ITALIC,20));
		l8.setBounds(20, 220, 150, 40);
		p1.add(l8);
		
		t1.setBounds(140, 20, 200, 25);//�����ı���
		p1.add(t1);
		
		t2.setBounds(140, 50, 200, 25);//ѧ���ı���
		p1.add(t2);
		
		t3.setBounds(140, 80, 90, 25);//�Ա���Ͽ�
		t3.addItem("��ѡ���Ա�");
		t3.addItem("��");
		t3.addItem("Ů");
		p1.add(t3);
		
		t4.setBounds(140, 110, 200, 25);//���������ı���
		p1.add(t4);
		
		t5.setBounds(140, 140, 90, 25);//��ͥסַ��Ͽ�
		t5.addItem("��ѡ�����");
		t5.addItem("����");
		t5.addItem("�Ϻ�");
		t5.addItem("���");
		t5.addItem("�Ͼ�");
		t5.addItem("����");
		t5.addItem("�Ĵ�");
		p1.add(t5);
		
		t6.setBounds(140, 170, 200, 25);//��ϵ�绰�ı���
		p1.add(t6);
		
		t7.setBounds(140, 200, 200, 25);//�����ı���
		p1.add(t7);
		
		t8.setBounds(140, 230, 200, 25);//ȷ�������ı���
		p1.add(t8);
		
		
		b1.setBounds(110, 280, 70, 30);//���ذ�ť
		p1.add(b1);
		
		b2.setBounds(210, 280, 70, 30);//�ύ��ť
		p1.add(b2);
		
		jd.setLayout(new FlowLayout());
		jd.add(b3);
		jd.add(b4);
		
		f1.add(p1);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//LoginScreen test = new LoginScreen();
				f1.dispose();
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			//	JOptionPane.showMessageDialog(new JFrame(),"���ע����Ϣ�����ȷ���ύ��");
				jd.setSize(200, 120);
				jd.setLocation(1000, 500);
				if(jd.getComponents().length == 1){
					jd.add(label);
				}
				label.setText("���ע����Ϣ�����ȷ���ύ��");
				jd.setVisible(true);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��        ����"+t1.getText());
				System.out.println("ѧ        �ţ�"+t2.getText());
				System.out.println("��        ��"+t3.getSelectedItem());
				System.out.println("�������ڣ�"+t4.getText());
				System.out.println("��ͥסַ��"+t5.getSelectedItem());
				System.out.println("��ϵ�绰��"+t6.getText());
				System.out.println("��        �룺"+t7.getText());
				System.out.println("ȷ�����룺"+t8.getText());
				//UserData userData = new UserData(t1.getText(),t2.getText(),
						//(String)t3.getSelectedItem(),t4.getText(),
						//(String)t5.getSelectedItem(),t6.getText(),t7.getText());
				//System.out.println(userData.getName());
				
				Example02 jdbcShooter = new Example02(t1.getText(),t2.getText(),
						(String)t3.getSelectedItem(),t4.getText(),
						(String)t5.getSelectedItem(),t6.getText(),t7.getText());
				try {
					jdbcShooter.JDBCshooter();
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				//
				jd.dispose();
			}
		});
		
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jd.dispose();
			}
		});
	}
	public static void main(String[] args) {
		new Register();
	}
}

