package ch84;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MYJComboBox extends JFrame{
	private JComboBox comboBox;
	private JTextField field;
	public MYJComboBox() {
		JPanel panel = new JPanel();
		comboBox = new JComboBox();
		//为组合框添加选项
		comboBox.addItem("请选择城市");
		comboBox.addItem("北京");
		comboBox.addItem("上海");
		comboBox.addItem("天津");
		comboBox.addItem("南京");
		comboBox.addItem("重庆");
		comboBox.addItem("四川");
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox.getSelectedItem();
				if("请选择城市".equals(item)){
					field.setText("");
				}else{
					field.setText("您选择的城市是："+item);
				}
				
			}
		});
		field = new JTextField(20);
		panel.add(comboBox);
		panel.add(field);
		this.add(panel, BorderLayout.NORTH);
		this.setSize(350, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MYJComboBox();
	}
}
