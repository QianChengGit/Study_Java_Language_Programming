package ch84;

import java.awt.FlowLayout;

import javax.swing.*;

public class MYJFrame extends JFrame{
	public MYJFrame() {
		this.setTitle("JFrameTest");
		this.setSize(400,300);
		this.setLocation(400, 400);//设置窗体位置
	//	this.setBounds(400, 400,400, 300);//设置窗体大小和位置
		JButton bt = new JButton("按钮");
		this.setLayout(new FlowLayout());//设置窗体的布局管理器（流式布局管理器）
		this.add(bt);
		//设置单击关闭按钮时的默认操作
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MYJFrame();
	}
}
