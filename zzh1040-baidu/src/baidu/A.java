package baidu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class A {
	public static void main(String arg[]){
		JFrame f=new JFrame(); JPanel jp1=new JPanel();
		JButton jb1=new JButton("�������Ĭ��FlowLayout����");
		JButton jb2=new JButton("�������Ĭ��BorderLayout����");
		JButton jb3=new JButton("���������֮�µĲ����");
		JButton jb4=new JButton("�������Ĭ�ϲ���");
		JButton jb5=new JButton("���������֮�ϵĲ����");
		JButton jb6=new JButton("JFrame����");
		//��JFrame�����ص���嶼ǿ��ת��ΪJComponent���ͣ��Ա� ����setOpaque������
		JComponent p1=(JComponent)f.getGlassPane();
		JComponent p2=(JComponent)f.getContentPane();
		JComponent p3=(JComponent)f.getLayeredPane();
		JComponent p4=(JComponent)f.getRootPane();
		p1.setBackground(Color.red);
		p2.setBackground(Color.yellow);
		p3.setBackground(Color.blue);
		p4.setBackground(Color.green);
		p1.add(jb1);
		p2.add(jb2,BorderLayout.SOUTH);
		//Ϊ�����p3���������ť���ҷֱ�������������֮�Ϻ��������֮��
		p3.add(jb3,new Integer(-30001)); //����ťjb3���������������֮��
		p3.add(jb5,new Integer(22)); //����ťjb5���������������֮��
		jb5.setSize(200,22); jb5.setLocation(7,35);
		jb3.setSize(200,22); jb3.setLocation(7,90);
		//������p4�����һ����ťjb4
		p4.add(jb4);
		jb4.setSize(200,22); jb4.setLocation(7,60);
		//f.add(jb6,BorderLayout.NORTH);//�÷���ʵ�����ǰѰ�ťjb5��ӵ�����������ϣ���δ��jb5��ӵ�����f�ϡ�
		f.setLocation(222,222);
		f.setSize(222,222); f.setVisible(true);
		//ѭ����ʾ�������
		while(true){
			//�������Ĭ���ǲ��ɼ���͸���ġ���ʾ��������ɫ������
			try{Thread.sleep(2000); } catch (InterruptedException e) {}
			p1.setVisible(true);
			p1.setOpaque(true);
			f.repaint(); //Ӧʹ��repaint�����ػ�һ�Σ�Ҫ��Ȼ���������ϴ���ʾ�Ĳ�Ӱ
			//ʹ�������͸���������ǿɼ��ģ������Ļ��ͻ���ʾ�������Ͳ����Ŀ���������֮�ϵĲ��������ݡ���Ϊ������������֮�����໥͸���ģ���˲�����ʾ��������ɫ�������෴��������ǲ�͸���ģ���˻���ʾ�������ı�����ɫ
			try{Thread.sleep(2000); } catch (InterruptedException e) {}
			p1.setOpaque(false);
			//p1.setVisible(false); //��Ҳ���԰Ѹ��е�ע��ɾ�������Ա�۲�ɼ�����͸���Ե�����
			f.repaint();
			//ʹ�������͸������Ϊǰ���ѰѲ��������Ϊ͸������˻���ʾȫ���Ĳ��������ݣ�������������ɫ����
			try{Thread.sleep(2000); } catch (InterruptedException e) {}
			p2.setOpaque(false);
			//p2.setVisible(false);
			p3.setOpaque(true);
			f.repaint();
			//ʹ�����͸������Ϊ��������ǲ�����е�ĳһ�㣬��˸�����ͬ����ʹ�������͸�����ټ���֮ǰ�ѰѲ��������Ϊ͸���������󽫻���ʾ����͸��Ҳ�ǿɼ��ĸ��������ݼ�����ɫ�ı���ɫ��
			try{Thread.sleep(2000); } catch (InterruptedException e) {}
			p3.setOpaque(false);
			//p3.setVisible(false);
			f.repaint();
			//ʹ�������Ŀɼ��Լ�͸���Ի�ԭ��
			try{Thread.sleep(2000); } catch (InterruptedException e) {}
			p1.setVisible(false);
			p2.setOpaque(true);
			p3.setOpaque(true);
			f.repaint();
			}
		}
	}
