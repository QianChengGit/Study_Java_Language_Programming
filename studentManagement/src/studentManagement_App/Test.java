package studentManagement_App;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import studentManagement_Service.AdministratorDao;
import studentManagement_Tool.Media;
import studentManagement_Tool.VerificationCode;
import studentManagement_View.Administrator;
import studentManagement_View.Registered;
import studentManagement_View.Student;
import studentManagement_View.Teacher;
@SuppressWarnings("serial")

public class Test extends JFrame{
	JFrame jf = new JFrame("[欢迎进入张泽宏的系统]");
    JLabel lb0 = new JLabel("     欢迎进入学生管理系统");
    JLabel lb1 = new JLabel("用  户  名:");
    JLabel lb2 = new JLabel("密      码:");
    JLabel lb3 = new JLabel("验  证  码:");
    /*
     * 加载背景图片
     */
    ImageIcon background = new ImageIcon("lib\\17-1反相：打造负片效果.jpg");
    JLabel label = new JLabel(background);
    Icon ic1=new ImageIcon("lib\\换一张-1.jpg");
    Icon ic2=new ImageIcon("lib\\登录-1.jpg");
    Icon ic3=new ImageIcon("lib\\退出-1.jpg");
    Icon ic4=new ImageIcon("lib\\注册-1.jpg");
    protected JTextField jt1 = new JTextField(25);
    protected JPasswordField jt2 = new JPasswordField(25);
    protected JTextField jt3 = new JTextField(4);
    JButton btn1 = new JButton(ic2);
    JButton btn2 = new JButton(ic3);
    JButton btn3 = new JButton(ic4);
    JButton btn4 = new JButton(ic1);
    private JPanel jp01 =new JPanel();
    private ButtonGroup group; 
    private String state = "没有选择人员";//登录状态
    public void init() {
        /*
         * 设置标签大小
         */
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
        final JPanel jpanel = new JPanel();
        jpanel.setOpaque(false);
        
        /*
         * 去除JPanel默认布局方式,以实现各个控件自己的定位
         */
        
        jpanel.setLayout(null);
        
        final VerificationCode vc = new VerificationCode();//验证码
        group = new ButtonGroup();//实例化单选按钮组
        
        addJRadioButton("学生登录");
        addJRadioButton("教师登录");
        addJRadioButton("管理员登录");
        
		
        lb0.setForeground(Color.CYAN);
        lb0.setFont(new Font("黑体",Font.ITALIC,30));
        lb0.setBounds(310, 30, 400, 30);
        lb1.setForeground(Color.yellow);
        lb1.setFont(new Font("黑体",Font.PLAIN,20));
        lb1.setBounds(270, 100, 200,30);
        lb2.setForeground(Color.yellow);
        lb2.setFont(new Font("黑体",Font.PLAIN,20));
        lb2.setBounds(270, 200, 200, 30);
        lb3.setForeground(Color.yellow);
        lb3.setFont(new Font("黑体",Font.PLAIN,20));
        lb3.setBounds(270, 300, 200, 30);
        jt1.setForeground(Color.red);
        jt1.setFont(new Font("黑体",Font.PLAIN,20));
        jt1.setBackground(Color.lightGray);
        jt1.setBounds(400, 100, 280, 40);
        jt2.setForeground(Color.red);
        jt2.setFont(new Font("",Font.PLAIN,20));
        jt2.setBackground(Color.lightGray);
        jt2.setBounds(400, 200, 280, 40);
        jt3.setForeground(Color.red);
        jt3.setFont(new Font("黑体",Font.PLAIN,20));
        jt3.setBackground(Color.lightGray);
        jt3.setBounds(400, 300, 90, 40);
        btn1.setBounds(260, 440, 90, 40);
        btn2.setBounds(460, 440, 90, 40);
        btn3.setBounds(660, 440, 90, 40);
        btn4.setBounds(600, 300, 80, 40);
        vc.setBounds(495, 300, 100, 40);//验证码

        jpanel.add(lb0);
        jpanel.add(lb1);
        jpanel.add(lb2);
        jpanel.add(lb3);
        jpanel.add(btn1);
        jpanel.add(btn2);
        jpanel.add(btn3);
        jpanel.add(btn4);
        jpanel.add(jt1);
        jpanel.add(jt2);
        jpanel.add(jt3);
        jpanel.add(vc);
        //设置窗体图标
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image im = kit.createImage("lib\\3-2-4.jpg");
        jf.setIconImage(im);
        
        jp01.setBounds(340,370 ,400 , 40);
        jp01.setOpaque(false);
        jf.add(jp01);
        jf.add(jpanel);
        jf.setBounds(460, 260, 1000, 600);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //登录按钮事件监听及处理
        btn1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e){
				AdministratorDao administratorDao = new AdministratorDao();
				if(state.equals("学生登录")){
					String user = administratorDao.SelectTeacher("student", jt1.getText(), "StudentNumber", "Password"); 
					if((jt1.getText()+jt2.getText()).equals(user) && jt3.getText().equals(vc.getSt())){
						//模态对话框
						JOptionPane.showMessageDialog(new JFrame(),"登录成功！");
						@SuppressWarnings("unused")
						Student student = new Student(jt1.getText());
						//注销当前页面
						jf.dispose();
					}
					else if(jt1.getText().equals("") && jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"账号和密码不能为空！");
					}
					else if(jt1.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"账号不能为空！");
					}
					else if(jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"密码不能为空！");
					}
					else{
						JOptionPane.showMessageDialog(new JFrame(),"登录失败，请重新输入账号，密码！");
					}
				}else if(state.equals("教师登录")){
					String user = administratorDao.SelectTeacher("teacher", jt1.getText(), "StudentNumber", "Password"); 
					if((jt1.getText()+jt2.getText()).equals(user) && jt3.getText().equals(vc.getSt())){
						//模态对话框
						JOptionPane.showMessageDialog(new JFrame(),"登录成功！");
						@SuppressWarnings("unused")
						Teacher teacher = new Teacher(jt1.getText());
						//注销当前页面
						jf.dispose();
					}
					else if(jt1.getText().equals("") && jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"账号和密码不能为空！");
					}
					else if(jt1.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"账号不能为空！");
					}
					else if(jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"密码不能为空！");
					}
					else{
						JOptionPane.showMessageDialog(new JFrame(),"登录失败，请重新输入账号，密码！");
					}	
				}else if(state.equals("管理员登录")){
					String user = administratorDao.SelectTeacher("administrator", jt1.getText(), "StudentNumber", "Password"); 
					if((jt1.getText()+jt2.getText()).equals(user) && jt3.getText().equals(vc.getSt())){
						//模态对话框
						JOptionPane.showMessageDialog(new JFrame(),"登录成功！");
						@SuppressWarnings("unused")
						Administrator administrator = new Administrator(jt1.getText());
						//注销当前页面
						jf.dispose();
					}
					else if(jt1.getText().equals("") && jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"账号和密码不能为空！");
					}
					else if(jt1.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"账号不能为空！");
					}
					else if(jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"密码不能为空！");
					}
					else{
						JOptionPane.showMessageDialog(new JFrame(),"登录失败，请重新输入账号，密码！");
					}	
					
				}else if(state.equals("没有选择人员")){
					JOptionPane.showMessageDialog(new JFrame(),"请选择登录人员！");
				}
			}
        });
        //退出系统按钮事件监听及处理
        btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(),"确定要退出吗？");
				System.out.println("关闭了窗口！！");
				System.exit(0);
			}
		});
        //注册按钮事件监听及处理
        btn3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Registered register= new Registered();
				jf.dispose();
			}	
        });
        //验证码换一张按钮事件监听及处理
        btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					vc.getpaint();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			    jpanel.add(vc);
			    jf.add(jpanel);
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
				if("学生登录".equals(text)){
					state = "学生登录";
					
				}else if("教师登录".equals(text)){
					state = "教师登录";
					
				}else if("管理员登录".equals(text)){
					state = "管理员登录";	
				}
			}
		});
    }
    //登录界面背景音乐
    public void Medio(){
    	Media media = new Media();
        Thread thread = new Thread(media);
        thread.start();
    }
    
	public static void main(String[] args) {
        Test test = new Test();
        test.init();
        test.Medio();
    }
}
