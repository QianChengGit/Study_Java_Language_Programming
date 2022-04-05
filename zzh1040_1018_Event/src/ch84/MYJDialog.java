package ch84;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MYJDialog {
	public static void main(String[] args) {
		JFrame f = new JFrame("DialogDemo");
		JButton btn1 = new JButton("ģ̬�Ի���");
		JButton btn2 = new JButton("��ģ̬�Ի���");
		
		f.setSize(300, 300);
		f.setLocation(400, 600);
		f.setLayout(new FlowLayout());
		f.add(btn1);
		f.add(btn2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		final JLabel label = new JLabel();
		final JButton btn3 = new JButton("ȷ��");
		final JDialog dialog = new JDialog(f,"Dialog");
		
		dialog.setSize(220, 150);
		dialog.setLocation(450, 700);
		dialog.setLayout(new FlowLayout());
		dialog.add(btn3);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//���öԻ���Ϊģ̬
				dialog.setModal(true);
				if(dialog.getComponents().length == 1){
					dialog.add(label);
				}
				label.setText("ģʽ�Ի��򣬵��ȷ����ť�ر�");
				dialog.setVisible(true);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//���öԻ���Ϊģ̬
				dialog.setModal(false);
				if(dialog.getComponents().length == 1){
					dialog.add(label);
				}
				label.setText("��ģʽ�Ի��򣬵��ȷ����ť�ر�");
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
