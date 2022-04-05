package studentManagement_View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import studentManagement_App.Test;

public class Teacher {

	private JFrame jf;
	@SuppressWarnings("unused")
	private JPanel jp;
	private JLabel jl;
	private JMenuBar menuBar;
	private JMenu menu01;
	private JMenu menu02;
	private JMenu menu03;
	private JMenu menu04;
	private JMenu menu05;
	private JMenu menu06;

	public Teacher(final String number) {
		jf = new JFrame("��ʦ����");
		jp = new JPanel();
		menuBar = new JMenuBar();
		menu01 = new JMenu("��    ��");
		menu02 = new JMenu("��Ϣά��");
		menu03 = new JMenu("��Ϣ��ѯ");
		menu04 = new JMenu("��ҵ����");
		menu05 = new JMenu("����ѡ��");
		menu06 = new JMenu("������Ϣ");
		
		menuBar.add(menu01);
		menuBar.add(menu02);
		menuBar.add(menu03);
		menuBar.add(menu04);
		menuBar.add(menu05);
		menuBar.add(menu06);
		menuBar.setBackground(Color.cyan);
		//�رղ˵�
		JMenuItem item01 = new JMenuItem("�ر�");
		item01.setBackground(Color.GREEN);
		menu01.add(item01);
		item01.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Test test=new Test();
				test.init();
				jf.dispose();
			}
		});
		//��Ϣά���˵�
		JMenuItem item02 = new JMenuItem("������Ϣ");
		JMenuItem item03 = new JMenuItem("�����޸�");
		item02.setBackground(Color.GREEN);
		item03.setBackground(Color.GREEN);
		menu02.add(item02);
		menu02.add(item03);
		item02.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Student_Message("teacher", number).setVisible(true);
				System.out.println("��ʾ������Ϣ");
			}
		});
		item03.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdatePassword("teacher",number).setVisible(true);
				System.out.println("�����޸�");
			}
		});
		
		//��Ϣ��ѯ�˵�
		JMenuItem item04 = new JMenuItem("ѧ�����˿α�");
		JMenuItem item05 = new JMenuItem("ѧ�����Բ�ѯ");
		JMenuItem item06 = new JMenuItem("ѧ���ɼ���ѯ");
		JMenuItem item07 = new JMenuItem("ѧ��������ѯ");
		item04.setBackground(Color.GREEN);
		item05.setBackground(Color.GREEN);
		item06.setBackground(Color.GREEN);
		item07.setBackground(Color.GREEN);
		menu03.add(item04);
		menu03.add(item05);
		menu03.add(item06);
		menu03.add(item07);
		item04.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Student_ClassSchedule("classschedule").setVisible(true);
				System.out.println("�α��ѯ");
			}
		});
		item05.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("���Բ�ѯ");
			}
		});
		item06.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�ɼ���ѯ");
				TeacherDialog teacherDialog = new TeacherDialog("scores");
				teacherDialog.setVisible(true);
			}
		});
		item07.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("������ѯ");
			}
		});
		//��ҵ���Ĳ˵�
		JMenuItem item08 = new JMenuItem("��ҵ����");
		item08.setBackground(Color.GREEN);
		menu04.add(item08);
		item08.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ҵ����");
			}
		});
		//����ѡ�β˵�
		JMenuItem item09 = new JMenuItem("����ѡ�޿�");
		JMenuItem item10 = new JMenuItem("ѡ�޼���ѡ�γ�");
		JMenuItem item11 = new JMenuItem("���޲���ѡ��");
		JMenuItem item12 = new JMenuItem("ѧ��ѡ��ȷ��");
		item09.setBackground(Color.GREEN);
		item10.setBackground(Color.GREEN);
		item11.setBackground(Color.GREEN);
		item12.setBackground(Color.GREEN);
		menu05.add(item09);
		menu05.add(item10);
		menu05.add(item11);
		menu05.add(item12);
		item09.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����ѡ�޿�");
			}
		});
		item10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ѡ�޼���ѡ�γ�");
			}
		});
		item11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("���޲���ѡ��");
			}
		});
		item12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ѧ��ѡ��ȷ��");
			}
		});
		//���񹫸�˵�
		JMenuItem item13 = new JMenuItem("���񹫸�");
		item13.setBackground(Color.GREEN);
		menu06.add(item13);
		item13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("���񹫸�");
			}
		});
		
		ImageIcon imageIcon = new ImageIcon("lib\\17-1���ࣺ���츺ƬЧ��.jpg");
		jl = new JLabel(imageIcon);
		jl.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
		
		jf.getLayeredPane().add(jl, new Integer(Integer.MIN_VALUE));
        JPanel jp = (JPanel) jf.getContentPane();
        jp.setOpaque(false);
        
		jf.setJMenuBar(menuBar);
		
		jf.setBounds(460, 260, 1000, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		new Teacher("201701081002z");
	}


}
