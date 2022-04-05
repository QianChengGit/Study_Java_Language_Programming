package ch84;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MYJDialog {
	public static void main(String[] args) {
		JFrame f = new JFrame("DialogDemo");
		JButton btn1 = new JButton("模态对话框");
		JButton btn2 = new JButton("非模态对话框");
		
		f.setSize(300, 300);
		f.setLocation(400, 600);
		f.setLayout(new FlowLayout());
		f.add(btn1);
		f.add(btn2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		final JLabel label = new JLabel();
		final JButton btn3 = new JButton("确定");
		final JDialog dialog = new JDialog(f,"Dialog");
		
		dialog.setSize(220, 150);
		dialog.setLocation(450, 700);
		dialog.setLayout(new FlowLayout());
		dialog.add(btn3);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置对话框为模态
				dialog.setModal(true);
				if(dialog.getComponents().length == 1){
					dialog.add(label);
				}
				label.setText("模式对话框，点击确定按钮关闭");
				dialog.setVisible(true);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//设置对话框为模态
				dialog.setModal(false);
				if(dialog.getComponents().length == 1){
					dialog.add(label);
				}
				label.setText("非模式对话框，点击确定按钮关闭");
				dialog.setVisible(true);
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				
			}
		});
	}
}
