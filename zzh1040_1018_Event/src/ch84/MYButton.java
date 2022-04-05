package ch84;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MYButton extends JFrame{
	private JCheckBox italic;
	private JCheckBox bold;
	private JLabel label;
	public MYButton() {
		label = new JLabel("传智播客欢迎您！",JLabel.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		this.add(label);
		JPanel panel = new JPanel();
		italic = new JCheckBox("ITALIC");
		bold = new JCheckBox("BOLD");
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int mode = 0;
				if(bold.isSelected()){
					mode += Font.BOLD;
				}
				if(italic.isSelected())
					mode += Font.ITALIC;
				label.setFont(new Font("宋体",mode,20));
			}
		};
		italic.addActionListener(listener);
		bold.addActionListener(listener);
		panel.add(italic);
		panel.add(bold);
		this.add(panel,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 400);
		this.setSize(300, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MYButton();
	}
}
