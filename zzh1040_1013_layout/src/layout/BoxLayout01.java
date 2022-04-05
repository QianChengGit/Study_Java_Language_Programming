package layout;
import java.awt.Container;

import javax.swing.*;
public class BoxLayout01 {
	public static void main(String[] args) {
		JFrame jf = new JFrame("BoxLayout");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JButton jb1 = new JButton("btn1");
		JButton jb2 = new JButton("btn2");
		JButton jb3 = new JButton("btn3");
		JButton jb4 = new JButton("btn4");
		JButton jb5 = new JButton("btn5");
		JButton jb6 = new JButton("btn6");
		
		//jp1.setSize(200, 200);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
		//jp2.setSize(200, 200);
		jp2.add(jb4);
		jp2.add(jb5);
		jp2.add(jb6);
		jp2.setLayout(new BoxLayout(jp2, BoxLayout.Y_AXIS));
		jf.setSize(400, 200);
		jf.add(jp4);
		jf.add(jp2);
		jf.add(jp3);
		jf.add(jp1);
		jf.add(jp5);
		Container f = jf.getContentPane();
		f.setLayout(new BoxLayout(f, BoxLayout.X_AXIS));
		jf.setLocation(200, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
