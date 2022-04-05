package gui1;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
class Cardlayout1 extends Frame implements ActionListener{
	Frame f = new Frame("张泽宏的窗体！");//为窗体命名
	Panel cardPanel = new Panel();//定义Panel面板放置卡片
	Panel controlpaPanel = new Panel();//定义Panel面板放置按钮
	Button nextbutton1,preButton1,button1;//定义了两个按钮
	CardLayout cardLayout = new CardLayout();//定义卡片布局对象
	//定义构造方法，设置卡片布局管理器的属性
	public Cardlayout1() {
	f.setSize(1000,600);//设置窗口大小
	f.setBounds(460, 260, 1000, 600);
	f.addWindowListener(new My());//为窗口组件注册监听器
	f.setVisible(true);//将窗口设置为显示状态
	cardPanel.setLayout(cardLayout);//使这个cardPanel容器采用CardLayout布局管理器
		//向cardPanel面板对象中添加3个文本标签
	Panel jp1=new ImgPanel(Toolkit.getDefaultToolkit().createImage("C:\\Users\\Administrator\\Desktop\\ps作业\\素材\\4-2修正图片颜色.jpg"));
	Panel jp2=new ImgPanel(Toolkit.getDefaultToolkit().createImage("C:\\Users\\Administrator\\Desktop\\ps作业\\素材\\17-1反相：打造负片效果.jpg"));
	Panel jp3=new ImgPanel(Toolkit.getDefaultToolkit().createImage("C:\\Users\\Administrator\\Desktop\\ps作业\\素材\\1-1亮度对比度：透亮的花瓣效果.jpg"));
	cardPanel.add(jp1);
	cardPanel.add(jp2);
	cardPanel.add(jp3);
		
		//创建两个按钮对象
	nextbutton1 = new Button("下一张卡片");
	preButton1 = new Button("上一张卡片");
	button1=new Button("返回");
		//为两个按钮对象注册监听器
	nextbutton1.addActionListener(this);
	preButton1.addActionListener(this);
	button1.addActionListener(this);
		//将按钮添加到controlpaPanel面板中
	controlpaPanel.add(preButton1);
	controlpaPanel.add(nextbutton1);
	controlpaPanel.add(button1);
		//将cardPanel面板放置在窗口边界布局的中间，窗口默认为边界布局
	f.add(cardPanel, BorderLayout.CENTER);
		//将controlpaPanel面板放置在窗口边界布局的南区，窗口默认为边界布局
	f.add(controlpaPanel, BorderLayout.SOUTH);
	button1.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标完成单击事件");
				if(e.getButton()==e.BUTTON1){
					System.out.println("鼠标左击事件");
					//跳转首界面
					Example example=new Example();
					example.init();
					//注销当前页面
					f.dispose();
					
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
				System.out.println("鼠标进入按钮区域事件");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标移出按钮区域事件");
			}
     	
     });	
}
//该方法实现按钮的监听触发，并对触发进行处理
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//如果用户单击nextbutton，执行的语句
		if(e.getSource() == nextbutton1){
			//切换面板中的组件，若当前组件为最后一个组件，则显示第一个组件
			cardLayout.next(cardPanel);
			System.out.println("若当前组件为最后一个组件，则显示第一个组件");
		}
		//如果用户单击preButton，执行的语句
		if(e.getSource() == preButton1){
			//切换面板中的组件，若当前组件为第一个组件，则显示最后一个组件
			cardLayout.previous(cardPanel);
			System.out.println("若当前组件为第一个组件，则显示最后一个组件");
		}
		
	}
}

//继承WindowAdapter类，重写windowClosing方法
class My extends WindowAdapter{
	//实例化windowClosing方法
	/* 如果单击窗口右上角的关闭按钮，
	 * 便会触发监听对象的windowClosing()方法，
	 * 从而关闭窗口
	 */
	public void windowClosing(WindowEvent e){
				//Cardlayout.this.dispose();
				Window window = (Window) e.getComponent();
				System.out.println("窗口关闭");
				window.dispose();//关闭窗口
				
	}		
}

public class Example04{
	public static void main(String[] args) {
		Cardlayout1 cardlayout1=new Cardlayout1();
		
	}
	
}