package gui;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
public class Register extends JFrame{
	JFrame f1 = new JFrame("张泽宏的注册窗口");
	JPanel p1 = new JPanel();
	JLabel l = new JLabel("姓    名： ");
	JLabel l2 = new JLabel("学    号： ");
	JLabel l3 = new JLabel("性    别： ");
	JLabel l4 = new JLabel("出生日期： ");
	JLabel l5 = new JLabel("家庭住址： ");
	JLabel l6 = new JLabel("联系电话： ");
	JLabel l7 = new JLabel("密    码： ");
	JLabel l8 = new JLabel("确认密码： ");
	JTextField t1 = new JTextField(25);
	JTextField t2 = new JTextField(25);
	JComboBox t3 = new JComboBox();
	JTextField t4 = new JTextField(25);
	JComboBox t5 = new JComboBox();
	JTextField t6 = new JTextField(25);
	JPasswordField t7 = new JPasswordField(25);
	JPasswordField t8 = new JPasswordField(25);
	JButton b1 = new JButton("返回");
	JButton b2 = new JButton("提交");
	JButton b3 = new JButton("确认");
	JButton b4 = new JButton("取消");
	final JDialog jd = new JDialog(f1, "提交", true);
	final JLabel label = new JLabel();
	public Register() {
		f1.setLayout(null);//去除JFrame默认布局管理器
		f1.setBounds(600, 400, 400, 400);//设置JFrame(x, y, width, height)
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
		
		p1.setBackground(Color.PINK);
		p1.setLayout(null);//去除JPanel默认布局管理器
		p1.setBounds(0, 0, 385, 355);//设置JPanel(x, y, width, height)
		
		l.setForeground(Color.BLUE);//姓名标签
        l.setFont(new Font("黑体",Font.ITALIC,20));
		l.setBounds(20, 10, 150, 40);
		p1.add(l);
		
		l2.setForeground(Color.BLUE);//学号标签
        l2.setFont(new Font("黑体",Font.ITALIC,20));
		l2.setBounds(20, 40, 150, 40);
		p1.add(l2);
		
		l3.setForeground(Color.BLUE);//性别标签
        l3.setFont(new Font("黑体",Font.ITALIC,20));
		l3.setBounds(20, 70, 150, 40);
		p1.add(l3);
		
		l4.setForeground(Color.BLUE);//出生日期标签
        l4.setFont(new Font("黑体",Font.ITALIC,20));
		l4.setBounds(20, 100, 150, 40);
		p1.add(l4);
		
		l5.setForeground(Color.BLUE);//家庭住址标签
        l5.setFont(new Font("黑体",Font.ITALIC,20));
		l5.setBounds(20, 130, 150, 40);
		p1.add(l5);
		
		l6.setForeground(Color.BLUE);//联系电话标签
        l6.setFont(new Font("黑体",Font.ITALIC,20));
		l6.setBounds(20, 160, 150, 40);
		p1.add(l6);
		
		l7.setForeground(Color.BLUE);//密码标签
        l7.setFont(new Font("黑体",Font.ITALIC,20));
		l7.setBounds(20, 190, 150, 40);
		p1.add(l7);
		
		l8.setForeground(Color.BLUE);//确认密码标签
        l8.setFont(new Font("黑体",Font.ITALIC,20));
		l8.setBounds(20, 220, 150, 40);
		p1.add(l8);
		
		t1.setBounds(140, 20, 200, 25);//姓名文本框
		p1.add(t1);
		
		t2.setBounds(140, 50, 200, 25);//学号文本框
		p1.add(t2);
		
		t3.setBounds(140, 80, 90, 25);//性别组合框
		t3.addItem("请选择性别");
		t3.addItem("男");
		t3.addItem("女");
		p1.add(t3);
		
		t4.setBounds(140, 110, 200, 25);//出生日期文本框
		p1.add(t4);
		
		t5.setBounds(140, 140, 90, 25);//家庭住址组合框
		t5.addItem("请选择城市");
		t5.addItem("北京");
		t5.addItem("上海");
		t5.addItem("天津");
		t5.addItem("南京");
		t5.addItem("重庆");
		t5.addItem("四川");
		p1.add(t5);
		
		t6.setBounds(140, 170, 200, 25);//联系电话文本框
		p1.add(t6);
		
		t7.setBounds(140, 200, 200, 25);//密码文本框
		p1.add(t7);
		
		t8.setBounds(140, 230, 200, 25);//确认密码文本框
		p1.add(t8);
		
		
		b1.setBounds(110, 280, 70, 30);//返回按钮
		p1.add(b1);
		
		b2.setBounds(210, 280, 70, 30);//提交按钮
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
			//	JOptionPane.showMessageDialog(new JFrame(),"检查注册信息无误后确定提交！");
				jd.setSize(200, 120);
				jd.setLocation(1000, 500);
				if(jd.getComponents().length == 1){
					jd.add(label);
				}
				label.setText("检查注册信息无误后确定提交！");
				jd.setVisible(true);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("姓        名："+t1.getText());
				System.out.println("学        号："+t2.getText());
				System.out.println("性        别："+t3.getSelectedItem());
				System.out.println("出生日期："+t4.getText());
				System.out.println("家庭住址："+t5.getSelectedItem());
				System.out.println("联系电话："+t6.getText());
				System.out.println("密        码："+t7.getText());
				System.out.println("确认密码："+t8.getText());
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
					// TODO 自动生成的 catch 块
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

