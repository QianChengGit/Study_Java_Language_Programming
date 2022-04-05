package cn.itcast.fruitstore.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cn.itcast.fruitstore.tools.GUITools;
public abstract class AbstractMainFrame extends JFrame{
	private JLabel titleLabel=new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\ps作业\\20-2打造蛋糕的粉色调效果.jpg"));
	Icon ic1=new ImageIcon("lib\\进入系统-1.jpg");
	private JButton btn=new JButton(ic1);
	public AbstractMainFrame(){
		this.init();
		this.addComponent();
		this.addListener();
	}
	private void init(){
		this.setTitle("水果超市欢迎您！");
		this.setSize(1050,790);
		GUITools.center(this);
		GUITools.setTitleImage(this, "lib\\3-2-4.jpg");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void addComponent(){
		this.add(this.titleLabel, BorderLayout.NORTH);
		JPanel btnPanel=new JPanel();
		btnPanel.setLayout(null);
		this.add(btnPanel);
		btn.setBounds(450, 10, 100, 50);
		btnPanel.add(btn);
	}
	private void addListener(){
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showAdminDialog();
			}
		});
	}
	//调用管理员界面方法
	public abstract void showAdminDialog();
}
