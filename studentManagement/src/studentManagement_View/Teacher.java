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
		jf = new JFrame("教师界面");
		jp = new JPanel();
		menuBar = new JMenuBar();
		menu01 = new JMenu("退    出");
		menu02 = new JMenu("信息维护");
		menu03 = new JMenu("信息查询");
		menu04 = new JMenu("毕业论文");
		menu05 = new JMenu("网上选课");
		menu06 = new JMenu("公用信息");
		
		menuBar.add(menu01);
		menuBar.add(menu02);
		menuBar.add(menu03);
		menuBar.add(menu04);
		menuBar.add(menu05);
		menuBar.add(menu06);
		menuBar.setBackground(Color.cyan);
		//关闭菜单
		JMenuItem item01 = new JMenuItem("关闭");
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
		//信息维护菜单
		JMenuItem item02 = new JMenuItem("个人信息");
		JMenuItem item03 = new JMenuItem("密码修改");
		item02.setBackground(Color.GREEN);
		item03.setBackground(Color.GREEN);
		menu02.add(item02);
		menu02.add(item03);
		item02.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Student_Message("teacher", number).setVisible(true);
				System.out.println("显示个人信息");
			}
		});
		item03.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdatePassword("teacher",number).setVisible(true);
				System.out.println("密码修改");
			}
		});
		
		//信息查询菜单
		JMenuItem item04 = new JMenuItem("学生个人课表");
		JMenuItem item05 = new JMenuItem("学生考试查询");
		JMenuItem item06 = new JMenuItem("学生成绩查询");
		JMenuItem item07 = new JMenuItem("学生补考查询");
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
				System.out.println("课表查询");
			}
		});
		item05.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("考试查询");
			}
		});
		item06.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("成绩查询");
				TeacherDialog teacherDialog = new TeacherDialog("scores");
				teacherDialog.setVisible(true);
			}
		});
		item07.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("补考查询");
			}
		});
		//毕业论文菜单
		JMenuItem item08 = new JMenuItem("毕业论文");
		item08.setBackground(Color.GREEN);
		menu04.add(item08);
		item08.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("毕业论文");
			}
		});
		//网上选课菜单
		JMenuItem item09 = new JMenuItem("公共选修课");
		JMenuItem item10 = new JMenuItem("选修及退选课程");
		JMenuItem item11 = new JMenuItem("重修补考选课");
		JMenuItem item12 = new JMenuItem("学生选课确认");
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
				System.out.println("公共选修课");
			}
		});
		item10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("选修及退选课程");
			}
		});
		item11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("重修补考选课");
			}
		});
		item12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("学生选课确认");
			}
		});
		//教务公告菜单
		JMenuItem item13 = new JMenuItem("教务公告");
		item13.setBackground(Color.GREEN);
		menu06.add(item13);
		item13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("教务公告");
			}
		});
		
		ImageIcon imageIcon = new ImageIcon("lib\\17-1反相：打造负片效果.jpg");
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
