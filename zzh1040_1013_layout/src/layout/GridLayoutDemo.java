package layout;

import java.awt.GridLayout;

import javax.swing.*;

public class GridLayoutDemo{
	public static void main(String[] args) {
		JFrame f = new JFrame("GridLayoutDemo");
		f.setLayout(new GridLayout(3, 3));
		f.setSize(300, 300);
		f.setLocation(400, 300);
		for(int i=1;i<=9;i++){
			JButton btn = new JButton("Button"+i);
			f.add(btn);
		}
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
