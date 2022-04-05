package gui1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Example06{
public static void main(String args[]){
	JFrame f=new JFrame("点我跳转");
	Container contentPane=f.getContentPane();
	contentPane.setLayout(new GridLayout(1,2));
	Icon icon=new ImageIcon("C:\\Users\\Administrator\\Desktop\\ps作业\\素材\\4-2修正图片颜色.jpg");
	JLabel label2=new JLabel("a",icon,JLabel.CENTER);
	label2.setHorizontalTextPosition(JLabel.CENTER);
	contentPane.setLayout(new FlowLayout( FlowLayout.CENTER,10,10));
	JButton bb=new JButton("图片");
	bb.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			JFrame bf=new JFrame("新窗体");
			Icon icon=new ImageIcon("C:\\Users\\Administrator\\Desktop\\ps作业\\素材\\17-1反相：打造负片效果.jpg");
			JLabel label2=new JLabel(icon);
			JPanel jp1=new JPanel();
			jp1.add(label2);
		//	bf.getContentPane().add(label2);
			bf.add(jp1);
			bf.setSize(500,600);
			bf.show();
		}});
	contentPane.add(label2);
	contentPane.add(bb);
	f.pack();
	f.show();
	}
}