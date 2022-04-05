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
	//��ǩ
		private JLabel tableLabel=new JLabel("ѧ��������Ϣ��");
		private JLabel StudentNumberLabel=new JLabel("ѧ  ��");
		private JLabel PasswordLabel=new JLabel("���� ��");
		private JButton jButton = new JButton("ȷ��");
		//�ı���
		protected JTextArea addStudentNumberText=new JTextArea();
		protected JTextField addPasswordText=new JTextField();
		
		
		//���췽��
				public UpdatePassword(String state,String number){
					this(null,true,state,number);
				}
				
				public UpdatePassword(Frame owner,boolean modal,String state,String number){
					super(owner,modal);
					this.init();//��ʼ������
					this.addComponent(state,number);//������
					
				}
		
		//��ʼ������
				private void init(){
					this.setTitle("�޸�����");//���ڱ���
					this.setSize(300,400);//�����С��λ��
					this.setLocation(400, 200);
					this.setResizable(false);//�����Сλ��
					
				}
				
				//������
				private void addComponent(final String state,final String number){
					//ȡ������
					this.setLayout(null);
					//������
					tableLabel.setFont(new Font("����",Font.BOLD,20));
					tableLabel.setForeground(Color.orange);
					tableLabel.setBounds(90, 10, 200, 50);
					this.add(tableLabel);
		
					//�ֶα���
					StudentNumberLabel.setFont(new Font("΢���ź�", Font.ITALIC, 20));
					StudentNumberLabel.setForeground(Color.RED);
					StudentNumberLabel.setBounds(120,70,70,25);
					
					PasswordLabel.setFont(new Font("΢���ź�", Font.ITALIC, 20));
					PasswordLabel.setForeground(Color.orange);
					PasswordLabel.setBounds(120,140,70,25);
					
					this.add(StudentNumberLabel);
					this.add(PasswordLabel);
					
					
					addStudentNumberText.setBounds(50,100,200,25);
					
					addPasswordText.setBounds(50,180,200,25);
					
					
					
					
					
					addStudentNumberText.setText(number);
					addStudentNumberText.setFont(new Font("΢���ź�", Font.ITALIC, 20));
					addStudentNumberText.setEditable(false);
					

					addPasswordText.setFont(new Font("΢���ź�", Font.ITALIC, 20));
					
					
					this.add(addStudentNumberText);
					this.add(addPasswordText);
					
					jButton.setBounds(100, 250, 100, 25);
					this.add(jButton);
					jButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO �Զ����ɵķ������
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
