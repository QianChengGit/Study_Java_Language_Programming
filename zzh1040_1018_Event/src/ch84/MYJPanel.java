package ch84;
import java.awt.*;
import javax.swing.*;
public class MYJPanel extends JFrame{
	public MYJPanel() {
		this.setTitle("PanelDemo");
		JScrollPane scorllPane = new JScrollPane();
		scorllPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scorllPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JPanel panel = new JPanel();
		panel.add(new JButton("按钮1"));
		panel.add(new JButton("按钮2"));
		panel.add(new JButton("按钮3"));
		panel.add(new JButton("按钮4"));
		scorllPane.setViewportView(panel);
		this.add(scorllPane, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 250);
		this.setLocation(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MYJPanel();
	}
}
