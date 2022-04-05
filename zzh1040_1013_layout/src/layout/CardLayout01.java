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
	
	Frame f = new Frame("张泽宏的窗体！");//为窗体命名
	Panel cardPanel = new Panel();//定义Panel面板放置卡片
	Panel controlpaPanel = new Panel();//定义Panel面板放置按钮
	Button nextbutton,preButton;//定义了两个按钮
	CardLayout cardLayout = new CardLayout();//定义卡片布局对象
	//定义构造方法，设置卡片布局管理器的属性
	public Cardlayout() {
		f.setSize(500,400);//设置窗口大小
		f.setBounds(460, 260, 500, 400);
		f.setVisible(true);//将窗口设置为显示状态
		f.addWindowListener(new MyWindowListener());//为窗口组件注册监听器
		cardPanel.setLayout(cardLayout);//使这个cardPanel容器采用CardLayout布局管理器
		//向cardPanel面板对象中添加3个文本标签
		
		
		cardPanel.add(new Label("第1个界面",Label.CENTER));
		cardPanel.add(new Label("第2个界面",Label.CENTER));
		cardPanel.add(new Label("第3个界面",Label.CENTER));
		cardPanel.add(new Label("制作四色图片",Label.CENTER));
		//创建两个按钮对象
		nextbutton = new Button("下一张卡片");
		preButton = new Button("上一张卡片");
		//为两个按钮对象注册监听器
		nextbutton.addActionListener(this);
		preButton.addActionListener(this);
		//将按钮添加到controlpaPanel面板中
		controlpaPanel.add(preButton);
		controlpaPanel.add(nextbutton);
		//将cardPanel面板放置在窗口边界布局的中间，窗口默认为边界布局
		f.add(cardPanel, BorderLayout.CENTER);
		//将controlpaPanel面板放置在窗口边界布局的南区，窗口默认为边界布局
		f.add(controlpaPanel, BorderLayout.SOUTH);
	}
private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}
	//该方法实现按钮的监听触发，并对触发进行处理
	public void actionPerformed(ActionEvent e) {
		//如果用户单击nextbutton，执行的语句
		if(e.getSource() == nextbutton){
			//切换面板中的组件，若当前组件为最后一个组件，则显示第一个组件
			cardLayout.next(cardPanel);
			System.out.println("若当前组件为最后一个组件，则显示第一个组件");
		}
		//如果用户单击preButton，执行的语句
		if(e.getSource() == preButton){
			//切换面板中的组件，若当前组件为第一个组件，则显示最后一个组件
			cardLayout.previous(cardPanel);
			System.out.println("若当前组件为第一个组件，则显示最后一个组件");
		}
	}
}
//继承WindowAdapter类，重写windowClosing方法
class MyWindowListener extends WindowAdapter{
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

public class CardLayout01 {
	public static void main(String[] args) {
		Cardlayout cardlayout=new Cardlayout();
	}
}
