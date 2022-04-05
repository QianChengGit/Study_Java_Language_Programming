package ch84;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MYJRadionButton extends JFrame{
	private ButtonGroup group;//��ѡ��ť�����
	private JPanel panel;
	private JPanel pallet;
	public MYJRadionButton() {
		pallet = new JPanel();
		this.add(pallet,BorderLayout.CENTER);
		panel = new JPanel();
		group = new ButtonGroup();
		//����addJRadionButton()����
		addJRadionButton("��");
		addJRadionButton("��");
		addJRadionButton("��");
		this.add(panel, BorderLayout.SOUTH);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void addJRadionButton(final String text) {
		JRadioButton radionButton = new JRadioButton(text);
		group.add(radionButton);
		panel.add(radionButton);
		radionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = null;
				if("��".equals(text)){
					color = Color.GRAY;
				}else if("��".equals(text)){
					color = Color.PINK;
				}else if("��".equals(text)){
					color = Color.YELLOW;
				}else{
					color = Color.WHITE;
				}
				pallet.setBackground(color);
			}
		});
		
	}
	public static void main(String[] args) {
		new MYJRadionButton();
	}
}
