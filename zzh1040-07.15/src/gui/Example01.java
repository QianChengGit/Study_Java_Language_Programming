package gui;
import java.awt.*;
import java.awt.event.*;
public class Example01 {
	public static void main(String[] args) {
		Frame f=new Frame("�����Ĵ��壡");
		f.setSize(400,300);
		f.setLocation(300,200);
		f.setVisible(true);
		Button btn=new Button("�����ѡ���˳����ڣ� O(��_��)O����~");
		f.add(btn);
		btn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.exit(0);
			}
		});
		
	}
}
