package layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
class Cardlayout extends Frame implements ActionListener{
	
	Frame f = new Frame("�����Ĵ��壡");//Ϊ��������
	Panel cardPanel = new Panel();//����Panel�����ÿ�Ƭ
	Panel controlpaPanel = new Panel();//����Panel�����ð�ť
	Button nextbutton,preButton;//������������ť
	CardLayout cardLayout = new CardLayout();//���忨Ƭ���ֶ���
	//���幹�췽�������ÿ�Ƭ���ֹ�����������
	public Cardlayout() {
		f.setSize(500,400);//���ô��ڴ�С
		f.setBounds(460, 260, 500, 400);
		f.setVisible(true);//����������Ϊ��ʾ״̬
		f.addWindowListener(new MyWindowListener());//Ϊ�������ע�������
		cardPanel.setLayout(cardLayout);//ʹ���cardPanel��������CardLayout���ֹ�����
		//��cardPanel�����������3���ı���ǩ
		
		
		cardPanel.add(new Label("��1������",Label.CENTER));
		cardPanel.add(new Label("��2������",Label.CENTER));
		cardPanel.add(new Label("��3������",Label.CENTER));
		cardPanel.add(new Label("������ɫͼƬ",Label.CENTER));
		//����������ť����
		nextbutton = new Button("��һ�ſ�Ƭ");
		preButton = new Button("��һ�ſ�Ƭ");
		//Ϊ������ť����ע�������
		nextbutton.addActionListener(this);
		preButton.addActionListener(this);
		//����ť��ӵ�controlpaPanel�����
		controlpaPanel.add(preButton);
		controlpaPanel.add(nextbutton);
		//��cardPanel�������ڴ��ڱ߽粼�ֵ��м䣬����Ĭ��Ϊ�߽粼��
		f.add(cardPanel, BorderLayout.CENTER);
		//��controlpaPanel�������ڴ��ڱ߽粼�ֵ�����������Ĭ��Ϊ�߽粼��
		f.add(controlpaPanel, BorderLayout.SOUTH);
	}
private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}
	//�÷���ʵ�ְ�ť�ļ������������Դ������д���
	public void actionPerformed(ActionEvent e) {
		//����û�����nextbutton��ִ�е����
		if(e.getSource() == nextbutton){
			//�л�����е����������ǰ���Ϊ���һ�����������ʾ��һ�����
			cardLayout.next(cardPanel);
			System.out.println("����ǰ���Ϊ���һ�����������ʾ��һ�����");
		}
		//����û�����preButton��ִ�е����
		if(e.getSource() == preButton){
			//�л�����е����������ǰ���Ϊ��һ�����������ʾ���һ�����
			cardLayout.previous(cardPanel);
			System.out.println("����ǰ���Ϊ��һ�����������ʾ���һ�����");
		}
	}
}
//�̳�WindowAdapter�࣬��дwindowClosing����
class MyWindowListener extends WindowAdapter{
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

public class CardLayout01 {
	public static void main(String[] args) {
		Cardlayout cardlayout=new Cardlayout();
	}
}
