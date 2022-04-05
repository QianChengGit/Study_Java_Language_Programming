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
		//Ϊ��Ͽ����ѡ��
		comboBox.addItem("��ѡ�����");
		comboBox.addItem("����");
		comboBox.addItem("�Ϻ�");
		comboBox.addItem("���");
		comboBox.addItem("�Ͼ�");
		comboBox.addItem("����");
		comboBox.addItem("�Ĵ�");
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox.getSelectedItem();
				if("��ѡ�����".equals(item)){
					field.setText("");
				}else{
					field.setText("��ѡ��ĳ����ǣ�"+item);
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
