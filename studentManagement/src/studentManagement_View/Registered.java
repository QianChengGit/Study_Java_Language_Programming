package studentManagement_View;
import javax.swing.*;

import studentManagement_App.Test;
import studentManagement_Data.Data;
import studentManagement_Service.AdministratorDao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Registered extends JFrame{
	JFrame jf=new JFrame("用户注册");
	ImageIcon background = new ImageIcon("lib\\17-1反相：打造负片效果.jpg");
    JLabel label = new JLabel(background);
	JLabel lb0 = new JLabel("     欢迎进入注册系统");
    JLabel lb1 = new JLabel("学号:");
    JLabel lb2 = new JLabel("密码:");
    JLabel lb3 = new JLabel("姓名:");
    JLabel lb4 = new JLabel("性别:");
    JLabel lb5 = new JLabel("学院:");
    JLabel lb6 = new JLabel("专业:");
    JLabel lb7 = new JLabel("班级:");
    protected JTextField jt1 = new JTextField(25);
    protected JPasswordField jt2 = new JPasswordField(25);
    protected JTextField jt3 = new JTextField(4);
    protected JComboBox<String> jt4 = new JComboBox<String>();
    protected JComboBox<String> jt5 = new JComboBox<String>();
    protected JTextField jt6 = new JTextField(4);
    protected JTextField jt7 = new JTextField(4);
    Icon ic1=new ImageIcon("lib\\返回-1.jpg");
    Icon ic2=new ImageIcon("lib\\提交-1.jpg");
    JButton btn1 = new JButton(ic1);
    JButton btn2 = new JButton(ic2);
    
    private JPanel jp01 =new JPanel();
    private ButtonGroup group; 
    private String state = "没有选择人员";//登录状态
	public Registered(){
		//设置图片标签坐标及大小
		 label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		 /*
         * 主界面获得容器JPanel
         */
        
        jf.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        JPanel jp = (JPanel) jf.getContentPane();
        
        /*
         * JPanel对象才可以调用setOpaque(false);设置是否透明
         */
        
        jp.setOpaque(false);
        JPanel jpanel = new JPanel();
        jpanel.setOpaque(false);
        
        /*
         * 去除JPanel默认布局方式,以实现各个控件自己的定位
         */
        
        jpanel.setLayout(null);
        
        group = new ButtonGroup();//实例化单选按钮组
        addJRadioButton("学生注册");
        addJRadioButton("教师注册");
        addJRadioButton("管理员注册");
		
		
		lb0.setForeground(Color.CYAN);
        lb0.setFont(new Font("黑体",Font.ITALIC,30));
        lb0.setBounds(300, 30, 400, 30);
        lb1.setForeground(Color.yellow);
        lb1.setFont(new Font("黑体",Font.PLAIN,20));
        lb1.setBounds(350, 100, 120,30);
        lb2.setForeground(Color.yellow);
        lb2.setFont(new Font("黑体",Font.PLAIN,20));
        lb2.setBounds(350, 150, 120, 30);
        lb3.setForeground(Color.yellow);
        lb3.setFont(new Font("黑体",Font.PLAIN,20));
        lb3.setBounds(350, 200, 120, 30);
        lb4.setForeground(Color.yellow);
        lb4.setFont(new Font("黑体",Font.PLAIN,20));
        lb4.setBounds(350, 250, 120,30);
        lb5.setForeground(Color.yellow);
        lb5.setFont(new Font("黑体",Font.PLAIN,20));
        lb5.setBounds(350, 300, 120,30);
        lb6.setForeground(Color.yellow);
        lb6.setFont(new Font("黑体",Font.PLAIN,20));
        lb6.setBounds(350, 350, 120,30);
        lb7.setForeground(Color.yellow);
        lb7.setFont(new Font("黑体",Font.PLAIN,20));
        lb7.setBounds(350, 400, 120,30);
       
        jt1.setBackground(Color.lightGray);
        jt1.setForeground(Color.red);
        jt1.setBounds(400, 100, 220, 30);
        jt2.setBackground(Color.lightGray);
        jt2.setForeground(Color.red);
        jt2.setBounds(400, 150, 220, 30);
        jt3.setBackground(Color.lightGray);
        jt3.setForeground(Color.red);
        jt3.setBounds(400, 200, 220, 30);
        jt4.setBackground(Color.lightGray);
        jt4.setForeground(Color.red);
        jt4.setBounds(400, 250, 150, 30);
        jt4.addItem("<--请选择性别-->");
        jt4.addItem("男");
        jt4.addItem("女");
        jt5.setBackground(Color.lightGray);
        jt5.setForeground(Color.red);
        jt5.setBounds(400, 300, 150, 30);
        jt5.addItem("<--请选择学院-->");
        jt5.addItem("电气与信息工程学院");
        jt5.addItem("纺织工程学院");
        jt5.addItem("外国语学院");
        jt5.addItem("材料与环保学院");
        jt5.addItem("建筑工程学院");
        jt5.addItem("机械工程学院");
        jt5.addItem("服装学院");
        jt5.addItem("艺术学院");
        jt5.addItem("经济管理学院");
        jt6.setBackground(Color.lightGray);
        jt6.setForeground(Color.red);
        jt6.setBounds(400, 350, 220, 30);
        jt7.setBackground(Color.lightGray);
        jt7.setForeground(Color.red);
        jt7.setBounds(400, 400, 220, 30);
		btn1.setBounds(410, 500, 80, 40);
		btn2.setBounds(530, 500, 80, 40);
		
        jpanel.add(lb0);
        jpanel.add(lb1);
        jpanel.add(lb2);
        jpanel.add(lb3);
        jpanel.add(lb4);
        jpanel.add(lb5);
        jpanel.add(lb6);
        jpanel.add(lb7);
        jpanel.add(jt1);
        jpanel.add(jt2);
        jpanel.add(jt3);
        jpanel.add(jt4);
        jpanel.add(jt5);
        jpanel.add(jt6);
        jpanel.add(jt7);
        jpanel.add(btn1);
        jpanel.add(btn2);
        
        jp01.setBounds(320,440 ,400 , 40);
        jp01.setOpaque(false);
        jf.add(jp01);
        jf.add(jpanel);
		jf.setSize(1000,600);//设置窗口大小background.getIconWidth(),background.getIconHeight()
		jf.setBounds(460, 260, 1000, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//为窗口关闭组件注册监听器
		jf.setVisible(true);//将窗口设置为显示状态
		//返回按钮事件处理
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					//跳转首界面
					Test test=new Test();
					test.init();
					//注销当前页面
					jf.dispose();
			}
		});
		//提交按钮事件处理
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//将注册信息写入数据库
				if(state.equals("学生注册")){
					
					@SuppressWarnings("deprecation")
					Data teacherData = new Data(jt1.getText(),jt2.getText(),jt3.getText()
							,(String)jt4.getSelectedItem(),(String)jt5.getSelectedItem(),jt6.getText(),jt7.getText(),state);
					AdministratorDao administratorDao = new AdministratorDao();
					administratorDao.addTeacher(teacherData,"student");
					JOptionPane.showMessageDialog(new JFrame(),"注册成功！");
					//跳转首界面
					Test test=new Test();
					test.init();
					//注销当前页面
					jf.dispose();
				}else if(state.equals("教师注册")){
					
					@SuppressWarnings("deprecation")
					Data teacherData = new Data(jt1.getText(),jt2.getText(),jt3.getText()
							,(String)jt4.getSelectedItem(),(String)jt5.getSelectedItem(),jt6.getText(),jt7.getText(),state);
					AdministratorDao administratorDao = new AdministratorDao();
					administratorDao.addTeacher(teacherData,"teacher");
					JOptionPane.showMessageDialog(new JFrame(),"注册成功！");
					//跳转首界面
					Test test=new Test();
					test.init();
					//注销当前页面
					jf.dispose();
				}else if(state.equals("管理员注册")){
					
					@SuppressWarnings("deprecation")
					Data teacherData = new Data(jt1.getText(),jt2.getText(),jt3.getText()
							,(String)jt4.getSelectedItem(),(String)jt5.getSelectedItem(),jt6.getText(),jt7.getText(),state);
					AdministratorDao administratorDao = new AdministratorDao();
					administratorDao.addTeacher(teacherData,"administrator");
					JOptionPane.showMessageDialog(new JFrame(),"注册成功！");
					//跳转首界面
					Test test=new Test();
					test.init();
					//注销当前页面
					jf.dispose();
				}else if(state.equals("没有选择人员")){
					JOptionPane.showMessageDialog(new JFrame(),"请选择注册人员！");
				}
			}
		});
		
	}
	
	//单选框
    private void addJRadioButton(final String text){
    	JRadioButton radioButton = new JRadioButton(text);
    	radioButton.setContentAreaFilled(false);
    	radioButton.setForeground(Color.CYAN);
    	radioButton.setFont(new Font("微软雅黑", 0, 20));
    	group.add(radioButton);
    	jp01.add(radioButton);
    	radioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if("学生注册".equals(text)){
					state = "学生注册";
					
				}else if("教师注册".equals(text)){
					state = "教师注册";
					
				}else if("管理员注册".equals(text)){
					state = "管理员注册";	
				}
			}
		});
    }
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Registered re=new Registered();
		
	}
	
}

