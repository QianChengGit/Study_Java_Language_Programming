package layout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class NoLayout {
	public static void main(String[] args) {
		JFrame f = new JFrame("hello");
		f.setLayout(null);
		f.setSize(300,150);
		f.setLocation(500, 500);
		JButton btn1 = new JButton("press");
		JButton btn2 = new JButton("pop");
		btn1.setBounds(40, 30, 100, 30);
		btn2.setBounds(140, 30, 100, 30);
		f.add(btn1);
		f.add(btn2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
