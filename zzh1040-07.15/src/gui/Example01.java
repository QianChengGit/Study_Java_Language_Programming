package gui;
import java.awt.*;
import java.awt.event.*;
public class Example01 {
	public static void main(String[] args) {
		Frame f=new Frame("张泽宏的窗体！");
		f.setSize(400,300);
		f.setLocation(300,200);
		f.setVisible(true);
		Button btn=new Button("张泽宏选择退出窗口！ O(∩_∩)O哈哈~");
		f.add(btn);
		btn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.exit(0);
			}
		});
		
	}
}
