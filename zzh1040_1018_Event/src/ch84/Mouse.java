package ch84;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;


public class Mouse{
	public static void main(String[] args) {
		final Frame f = new Frame("Event");
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(400, 300);
		f.setLayout(new FlowLayout());
		f.setSize(400, 300);
		f.setLocation(300, 200);
		f.setVisible(true);
		f.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("windowOpened---窗体打开事件");
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("windowIconified---窗体图标化事件");
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("windowDeiconified---窗体取消图标化事件");
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("windowDeactivated---窗体停用事件");
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("windowClosing---窗体正在关闭事件");
				((Window) e.getComponent()).dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("windowClosed---窗体关闭事件");
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("windowActivated---窗体激活事件");
			}
		});
		
		Button but = new Button("Button");
		but.setBounds(50, 20, 70, 50);
		p.add(but);
		but.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("mouseReleased-鼠标放开事件");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("mousePressed-鼠标按下事件");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("mouseExited-鼠标移出按钮区域事件");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("mouseEntered-鼠标进入按钮区域事件");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("mouseClicked-鼠标完成单击事件");
				if(e.getButton()==e.BUTTON1){
					System.out.println("鼠标左击事件");
				}
				if(e.getButton()==e.BUTTON3){
					System.out.println("鼠标右击事件");
				}
				if(e.getButton()==e.BUTTON2){
					System.out.println("鼠标中键单击事件");
				}
			}
		});
		
		TextField tf = new TextField(30);
		tf.setBounds(150, 20, 200, 50);
		p.add(tf);
		tf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("0");
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO 自动生成的方法存根
				System.out.println("1");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO 自动生成的方法存根
				int KeyCode = e.getKeyCode();//返回所按键对应的整数值
				String s = KeyEvent.getKeyText(KeyCode);//返回按键的字符串描述
				System.out.print("输入的内容为："+s+",");
				System.out.println("对应的KeyCode为："+KeyCode);
			}
		});
		Paint paint = new Paint();
		paint.setBounds(150, 100,100, 40);
		p.add(paint);
		f.add(p);
		
	}

}
