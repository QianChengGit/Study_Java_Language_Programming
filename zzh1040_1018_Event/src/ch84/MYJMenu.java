package ch84;
import java.awt.event.*;
import javax.swing.*;
public class MYJMenu extends JFrame{
	public MYJMenu() {
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		JMenu menu = new JMenu("����");
		menuBar.add(menu);
		//���������˵���
		JMenuItem item1 = new JMenuItem("��������");
		JMenuItem item2 = new JMenuItem("�ر�");
		//Ϊ�˵�����Ӽ�����
		item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog(MYJMenu.this,true);
				dialog.setTitle("��������");
				dialog.setSize(200, 200);
				dialog.setLocation(50, 50);
				dialog.setVisible(true);
			}
		});
		item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		menu.add(item1);
		menu.addSeparator();
		menu.add(item2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MYJMenu();
	}
}
