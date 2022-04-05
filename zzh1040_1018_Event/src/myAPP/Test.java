package myAPP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Test {
	JFrame f = new JFrame("张泽宏的登录窗口");
	JPanel p = new JPanel();
	JLabel l = new JLabel("学  号 ： ");
	JLabel l2 = new JLabel("密  码 ： ");
	JLabel l3 = new JLabel("验证码 ： ");
	JTextField t1 = new JTextField(25);
	JPasswordField t2 = new JPasswordField(25);
	JTextField t3 = new JTextField(25);
	JButton b1 = new JButton("登录");
	JButton b2 = new JButton("注册");
	JButton b3 = new JButton("退出");
	
	public Test() {
		
		f.setLayout(null);//去除JFrame默认布局管理器
		f.setBounds(600, 400, 380, 350);//设置JFrame(x, y, width, height)
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		p.setBackground(Color.PINK);
		p.setLayout(null);//去除JPanel默认布局管理器
		p.setBounds(0, 0, 380, 350);//设置JPanel(x, y, width, height)
		
		l.setForeground(Color.BLUE);//标签一
        l.setFont(new Font("黑体",Font.ITALIC,20));
		l.setBounds(20, 10, 100, 50);
		p.add(l);
		
		l2.setForeground(Color.BLUE);//标签二
        l2.setFont(new Font("黑体",Font.ITALIC,20));
		l2.setBounds(20, 70, 100, 50);
		p.add(l2);
		
		l3.setForeground(Color.BLUE);//标签三
        l3.setFont(new Font("黑体",Font.ITALIC,20));
		l3.setBounds(20, 130, 100, 50);
		p.add(l3);
		
		t1.setBounds(120, 20, 200, 30);//账号文本框
		p.add(t1);
		
		t2.setBounds(120, 80, 200, 30);//密码文本框
		p.add(t2);
		
		t3.setBounds(120, 140, 90, 30);//验证码文本框
		p.add(t3);
		
		b1.setBounds(20, 230, 70, 30);//登录按钮
		p.add(b1);
		
		b2.setBounds(145, 230, 70, 30);//登录按钮
		p.add(b2);
		
		b3.setBounds(270, 230, 70, 30);//登录按钮
		p.add(b3);
		
		final VerificationCode vc = new VerificationCode();//验证码
		vc.setBounds(220, 140, 100, 46);
		p.add(vc);
		
		f.add(p);
		
		b1.addActionListener(new ActionListener() {//登录按钮监听
			@Override
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().equals("张泽宏") && t2.getText().equals("zzh123456") && t3.getText().equals(vc.getSt())){//
					System.out.println("ok!");
					ChatWindow chatWindow = new ChatWindow();
					f.dispose();
				}
				
			}
		});
		
		b2.addActionListener(new ActionListener() {//注册按钮监听
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("注册");
				Register register = new Register();
				f.dispose();
			}
		});
		
		b3.addActionListener(new ActionListener() {//退出按钮监听
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
