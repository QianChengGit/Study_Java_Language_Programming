package gui1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Example extends JFrame implements ActionListener{
    JFrame jf = new JFrame("[欢迎进入张泽宏的系统]");
    JLabel lb0 = new JLabel("     欢迎进入学生管理系统");
    JLabel lb1 = new JLabel("用       户      名:");
    JLabel lb2 = new JLabel("密               码:");
    JLabel lb3 = new JLabel("验       证      码:");
   
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
        
    public void init() {
        /*
         * 设置标签大小
         */
    	//
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
        
        Example08 jpanpel01=new Example08();//验证码
    //    String hp=jpanpel01.paint(getGraphics());
       
        lb0.setForeground(Color.CYAN);
        lb0.setFont(new Font("黑体",Font.ITALIC,30));
        lb0.setBounds(310, 30, 400, 30);
        lb1.setForeground(Color.yellow);
        lb1.setFont(new Font("黑体",Font.PLAIN,20));
        lb1.setBounds(180, 100, 200,30);
        lb2.setForeground(Color.yellow);
        lb2.setFont(new Font("黑体",Font.PLAIN,20));
        lb2.setBounds(180, 200, 220, 30);
        lb3.setForeground(Color.yellow);
        lb3.setFont(new Font("黑体",Font.PLAIN,20));
        lb3.setBounds(180, 300, 200, 30);
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
        jpanpel01.setBounds(495, 300, 100, 40);//验证码

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
        jpanel.add(jpanpel01);
        //设置窗体图标
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image im = kit.createImage("lib\\3-2-4.jpg");
        jf.setIconImage(im);
        
        jf.add(jpanel);
        jf.setBounds(460, 260, 1000, 600);
        jf.setVisible(true);
        
        //验证码换一张按钮事件监听及处理
        btn4.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标完成单击事件");
				if(e.getButton()==e.BUTTON1){
					System.out.println("鼠标左击事件");
					Example08 jpanpel02=new Example08();
					jpanpel02.setBounds(495, 300, 100, 40);//验证码
					JPanel jpanel=new JPanel();
			        jpanel.add(jpanpel02);
			        jf.add(jpanel);
				}
				if(e.getButton()==e.BUTTON2){
					System.out.println("鼠标中键单击事件");
				}
				if(e.getButton() == e.BUTTON3){
					System.out.println("鼠标右击事件");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标按下事件");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标放开事件");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标进入换一张按钮区域事件");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标移出换一张按钮区域事件");
			}
        	
        });
        //登录按钮事件监听及处理
        btn1.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标完成单击事件");
				if(e.getButton()==e.BUTTON1){
					System.out.println("鼠标左击事件");
					if(jt1.getText().equals("张泽宏") && jt2.getText().equals("zzh12345")){
						//模态对话框
						JOptionPane.showMessageDialog(new JFrame(),"登录成功！");
						//跳转登录界面
						//Cardlayout1 cardlayout1=new Cardlayout1();
						Example07 example = new Example07();
						example.init();
						//注销当前页面
						jf.dispose();
					}
					else if(jt1.getText().equals("") && jt2.getText().equals("zzh12345")){
						JOptionPane.showMessageDialog(new JFrame(),"账号不能为空！");
					}
					else if(jt1.getText().equals("张泽宏") && jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"密码不能为空！");
					}
					else if(jt1.getText().equals("") && jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"账号和密码不能为空！");
					}
					else{
						JOptionPane.showMessageDialog(new JFrame(),"登录失败，请重新输入账号，密码！");
					}
				}
				if(e.getButton()==e.BUTTON2){
					System.out.println("鼠标中键单击事件");
				}
				if(e.getButton() == e.BUTTON3){
					System.out.println("鼠标右击事件");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标按下事件");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标放开事件");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标进入登录按钮区域事件");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标移出登录按钮区域事件");
			}
        	
        });
        //退出系统按钮事件监听及处理
        btn2.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标完成单击事件");
				if(e.getButton()==e.BUTTON1){
					System.out.println("鼠标左击事件");
					System.out.println("鼠标左击关闭了窗口！！");
					System.exit(0);
				}
				if(e.getButton()==e.BUTTON2){
					System.out.println("鼠标中键单击事件");
				}
				if(e.getButton() == e.BUTTON3){
					System.out.println("鼠标右击事件");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标按下事件");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标放开事件");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标进入退出系统按钮区域事件");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标移出退出系统按钮区域事件");
			}
        	
        });
        //开户按钮事件监听及处理
        btn3.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标完成单击事件");
				if(e.getButton()==e.BUTTON1){
					System.out.println("鼠标左击事件");
					Registered registered= new Registered();
					registered.Registered();
					jf.dispose();
				}
				if(e.getButton()==e.BUTTON2){
					System.out.println("鼠标中键单击事件");
				}
				if(e.getButton() == e.BUTTON3){
					System.out.println("鼠标右击事件");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标按下事件");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标放开事件");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标进入开户按钮区域事件");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标移出开户按钮区域事件");
			}
        	
        });
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	}
}
public class Example03{
	public static void main(String[] args) {
        new Example().init();
    }

}