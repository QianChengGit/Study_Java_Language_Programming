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
				// TODO �Զ����ɵķ������
				System.out.println("windowOpened---������¼�");
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("windowIconified---����ͼ�껯�¼�");
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("windowDeiconified---����ȡ��ͼ�껯�¼�");
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("windowDeactivated---����ͣ���¼�");
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("windowClosing---�������ڹر��¼�");
				((Window) e.getComponent()).dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("windowClosed---����ر��¼�");
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("windowActivated---���弤���¼�");
			}
		});
		
		Button but = new Button("Button");
		but.setBounds(50, 20, 70, 50);
		p.add(but);
		but.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("mouseReleased-���ſ��¼�");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("mousePressed-��갴���¼�");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("mouseExited-����Ƴ���ť�����¼�");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("mouseEntered-�����밴ť�����¼�");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("mouseClicked-�����ɵ����¼�");
				if(e.getButton()==e.BUTTON1){
					System.out.println("�������¼�");
				}
				if(e.getButton()==e.BUTTON3){
					System.out.println("����һ��¼�");
				}
				if(e.getButton()==e.BUTTON2){
					System.out.println("����м������¼�");
				}
			}
		});
		
		TextField tf = new TextField(30);
		tf.setBounds(150, 20, 200, 50);
		p.add(tf);
		tf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("0");
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO �Զ����ɵķ������
				System.out.println("1");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO �Զ����ɵķ������
				int KeyCode = e.getKeyCode();//������������Ӧ������ֵ
				String s = KeyEvent.getKeyText(KeyCode);//���ذ������ַ�������
				System.out.print("���������Ϊ��"+s+",");
				System.out.println("��Ӧ��KeyCodeΪ��"+KeyCode);
			}
		});
		Paint paint = new Paint();
		paint.setBounds(150, 100,100, 40);
		p.add(paint);
		f.add(p);
		
	}

}
