package studentManagement_View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import studentManagement_Data.Data;
import studentManagement_Service.AdministratorDao;

public class UpdatePassword  extends JDialog{
	//标签
		private JLabel tableLabel=new JLabel("学生个人信息表");
		private JLabel StudentNumberLabel=new JLabel("学  号");
		private JLabel PasswordLabel=new JLabel("新密 码");
		private JButton jButton = new JButton("确定");
		//文本框
		protected JTextArea addStudentNumberText=new JTextArea();
		protected JTextField addPasswordText=new JTextField();
		
		
		//构造方法
				public UpdatePassword(String state,String number){
					this(null,true,state,number);
				}
				
				public UpdatePassword(Frame owner,boolean modal,String state,String number){
					super(owner,modal);
					this.init();//初始化操作
					this.addComponent(state,number);//添加组件
					
				}
		
		//初始化操作
				private void init(){
					this.setTitle("修改密码");//窗口标题
					this.setSize(300,400);//窗体大小与位置
					this.setLocation(400, 200);
					this.setResizable(false);//窗体大小位置
					
				}
				
				//添加组件
				private void addComponent(final String state,final String number){
					//取消布局
					this.setLayout(null);
					//表格标题
					tableLabel.setFont(new Font("黑体",Font.BOLD,20));
					tableLabel.setForeground(Color.orange);
					tableLabel.setBounds(90, 10, 200, 50);
					this.add(tableLabel);
		
					//字段标题
					StudentNumberLabel.setFont(new Font("微软雅黑", Font.ITALIC, 20));
					StudentNumberLabel.setForeground(Color.RED);
					StudentNumberLabel.setBounds(120,70,70,25);
					
					PasswordLabel.setFont(new Font("微软雅黑", Font.ITALIC, 20));
					PasswordLabel.setForeground(Color.orange);
					PasswordLabel.setBounds(120,140,70,25);
					
					this.add(StudentNumberLabel);
					this.add(PasswordLabel);
					
					
					addStudentNumberText.setBounds(50,100,200,25);
					
					addPasswordText.setBounds(50,180,200,25);
					
					
					
					
					
					addStudentNumberText.setText(number);
					addStudentNumberText.setFont(new Font("微软雅黑", Font.ITALIC, 20));
					addStudentNumberText.setEditable(false);
					

					addPasswordText.setFont(new Font("微软雅黑", Font.ITALIC, 20));
					
					
					this.add(addStudentNumberText);
					this.add(addPasswordText);
					
					jButton.setBounds(100, 250, 100, 25);
					this.add(jButton);
					jButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO 自动生成的方法存根
							queryDate(state,number,addPasswordText.getText());
						}
					});
					
				}
				
		
		public void queryDate(String personnel,String StudentNumber,String content) {
			// TODO Auto-generated method stub
			AdministratorDao administratorDao = new AdministratorDao();
			administratorDao.updatePassword(personnel, StudentNumber, content);
			
		}
		
//		public static void main(String[] args) {
//			new UpdatePassword("teacher","201701081002z").setVisible(true);
//		}
}
