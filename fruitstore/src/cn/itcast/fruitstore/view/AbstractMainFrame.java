package cn.itcast.fruitstore.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cn.itcast.fruitstore.tools.GUITools;
public abstract class AbstractMainFrame extends JFrame{
	private JLabel titleLabel=new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\ps��ҵ\\20-2���쵰��ķ�ɫ��Ч��.jpg"));
	Icon ic1=new ImageIcon("lib\\����ϵͳ-1.jpg");
	private JButton btn=new JButton(ic1);
	public AbstractMainFrame(){
		this.init();
		this.addComponent();
		this.addListener();
	}
	private void init(){
		this.setTitle("ˮ�����л�ӭ����");
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
	//���ù���Ա���淽��
	public abstract void showAdminDialog();
}
