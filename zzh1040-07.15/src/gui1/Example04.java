package gui1;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
class Cardlayout1 extends Frame implements ActionListener{
	Frame f = new Frame("�����Ĵ��壡");//Ϊ��������
	Panel cardPanel = new Panel();//����Panel�����ÿ�Ƭ
	Panel controlpaPanel = new Panel();//����Panel�����ð�ť
	Button nextbutton1,preButton1,button1;//������������ť
	CardLayout cardLayout = new CardLayout();//���忨Ƭ���ֶ���
	//���幹�췽�������ÿ�Ƭ���ֹ�����������
	public Cardlayout1() {
	f.setSize(1000,600);//���ô��ڴ�С
	f.setBounds(460, 260, 1000, 600);
	f.addWindowListener(new My());//Ϊ�������ע�������
	f.setVisible(true);//����������Ϊ��ʾ״̬
	cardPanel.setLayout(cardLayout);//ʹ���cardPanel��������CardLayout���ֹ�����
		//��cardPanel�����������3���ı���ǩ
	Panel jp1=new ImgPanel(Toolkit.getDefaultToolkit().createImage("C:\\Users\\Administrator\\Desktop\\ps��ҵ\\�ز�\\4-2����ͼƬ��ɫ.jpg"));
	Panel jp2=new ImgPanel(Toolkit.getDefaultToolkit().createImage("C:\\Users\\Administrator\\Desktop\\ps��ҵ\\�ز�\\17-1���ࣺ���츺ƬЧ��.jpg"));
	Panel jp3=new ImgPanel(Toolkit.getDefaultToolkit().createImage("C:\\Users\\Administrator\\Desktop\\ps��ҵ\\�ز�\\1-1���ȶԱȶȣ�͸���Ļ���Ч��.jpg"));
	cardPanel.add(jp1);
	cardPanel.add(jp2);
	cardPanel.add(jp3);
		
		//����������ť����
	nextbutton1 = new Button("��һ�ſ�Ƭ");
	preButton1 = new Button("��һ�ſ�Ƭ");
	button1=new Button("����");
		//Ϊ������ť����ע�������
	nextbutton1.addActionListener(this);
	preButton1.addActionListener(this);
	button1.addActionListener(this);
		//����ť��ӵ�controlpaPanel�����
	controlpaPanel.add(preButton1);
	controlpaPanel.add(nextbutton1);
	controlpaPanel.add(button1);
		//��cardPanel�������ڴ��ڱ߽粼�ֵ��м䣬����Ĭ��Ϊ�߽粼��
	f.add(cardPanel, BorderLayout.CENTER);
		//��controlpaPanel�������ڴ��ڱ߽粼�ֵ�����������Ĭ��Ϊ�߽粼��
	f.add(controlpaPanel, BorderLayout.SOUTH);
	button1.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����ɵ����¼�");
				if(e.getButton()==e.BUTTON1){
					System.out.println("�������¼�");
					//��ת�׽���
					Example example=new Example();
					example.init();
					//ע����ǰҳ��
					f.dispose();
					
				}
				if(e.getButton()==e.BUTTON2){
					System.out.println("����м������¼�");
				}
				if(e.getButton() == e.BUTTON3){
					System.out.println("����һ��¼�");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��갴���¼�");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���ſ��¼�");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����밴ť�����¼�");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("����Ƴ���ť�����¼�");
			}
     	
     });	
}
//�÷���ʵ�ְ�ť�ļ������������Դ������д���
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//����û�����nextbutton��ִ�е����
		if(e.getSource() == nextbutton1){
			//�л�����е����������ǰ���Ϊ���һ�����������ʾ��һ�����
			cardLayout.next(cardPanel);
			System.out.println("����ǰ���Ϊ���һ�����������ʾ��һ�����");
		}
		//����û�����preButton��ִ�е����
		if(e.getSource() == preButton1){
			//�л�����е����������ǰ���Ϊ��һ�����������ʾ���һ�����
			cardLayout.previous(cardPanel);
			System.out.println("����ǰ���Ϊ��һ�����������ʾ���һ�����");
		}
		
	}
}

//�̳�WindowAdapter�࣬��дwindowClosing����
class My extends WindowAdapter{
	//ʵ����windowClosing����
	/* ��������������ϽǵĹرհ�ť��
	 * ��ᴥ�����������windowClosing()������
	 * �Ӷ��رմ���
	 */
	public void windowClosing(WindowEvent e){
				//Cardlayout.this.dispose();
				Window window = (Window) e.getComponent();
				System.out.println("���ڹر�");
				window.dispose();//�رմ���
				
	}		
}

public class Example04{
	public static void main(String[] args) {
		Cardlayout1 cardlayout1=new Cardlayout1();
		
	}
	
}