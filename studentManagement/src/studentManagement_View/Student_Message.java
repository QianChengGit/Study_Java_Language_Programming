package studentManagement_View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import studentManagement_Data.Data;
import studentManagement_Service.AdministratorDao;

@SuppressWarnings("serial")
public class Student_Message extends JDialog{
	//��ǩ
	private JLabel tableLabel=new JLabel("ѧ��������Ϣ��");//�б����
	private JLabel StudentNumberLabel=new JLabel("ѧ  ��");//
	private JLabel PasswordLabel=new JLabel("��  ��");//
	private JLabel NameLabel=new JLabel("��  ��");//
	private JLabel SexLabel=new JLabel("��  ��");//
	private JLabel CollegeLabel=new JLabel("ѧ  Ժ");//
	private JLabel MajorLabel=new JLabel("ר  ҵ");//
	private JLabel StudentClassLabel=new JLabel("��  ��");//
	//�ı���
	protected JTextArea addStudentNumberText=new JTextArea();//��ӱ���ı���
	protected JTextArea addPasswordText=new JTextArea();//��������ı���
	protected JTextArea addNameText=new JTextArea();//��ӵ����ı���
	protected JTextArea addSexText=new JTextArea();//��ӼƼ۵�λ�ı���
	protected JTextArea addCollegeText=new JTextArea();//��ӼƼ۵�λ�ı���
	protected JTextArea addMajorText=new JTextArea();//��ӼƼ۵�λ�ı���
	protected JTextArea addStudentClassText=new JTextArea();//��ӼƼ۵�λ�ı���
	
	
	//���췽��
			public Student_Message(String state,String number){
				this(null,true,state,number);
			}
			
			public Student_Message(Frame owner,boolean modal,String state,String number){
				super(owner,modal);
				this.init();//��ʼ������
				this.addComponent(state,number);//������
				
			}
	
	//��ʼ������
			private void init(){
				this.setTitle("ѧ��������Ϣ");//���ڱ���
				this.setSize(860,500);//�����С��λ��
				this.setLocation(400, 200);
				this.setResizable(false);//�����Сλ��
				
			}
			
			//������
			private void addComponent(String state,String number){
				//ȡ������
				this.setLayout(null);
				//������
				tableLabel.setFont(new Font("����",Font.BOLD,20));
				tableLabel.setForeground(Color.orange);
				tableLabel.setBounds(350, 10, 200, 50);
				this.add(tableLabel);
	
				//�ֶα���
				StudentNumberLabel.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				StudentNumberLabel.setForeground(Color.RED);
				StudentNumberLabel.setBounds(120,70,70,25);
				PasswordLabel.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				PasswordLabel.setForeground(Color.orange);
				PasswordLabel.setBounds(400,70,70,25);
				NameLabel.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				NameLabel.setForeground(Color.BLUE);
				NameLabel.setBounds(680,70,70,25);
				SexLabel.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				SexLabel.setForeground(Color.GREEN);
				SexLabel.setBounds(120,170,70,25);
				CollegeLabel.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				CollegeLabel.setForeground(Color.CYAN);
				CollegeLabel.setBounds(400, 170,70,25);
				MajorLabel.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				MajorLabel.setForeground(Color.PINK);
				MajorLabel.setBounds(680, 170,70,25);
				StudentClassLabel.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				StudentClassLabel.setForeground(Color.CYAN);
				StudentClassLabel.setBounds(120, 270,70,25);
				this.add(StudentNumberLabel);
				this.add(PasswordLabel);
				this.add(NameLabel);
				this.add(SexLabel);
				this.add(CollegeLabel);
				this.add(MajorLabel);
				this.add(StudentClassLabel);
				
				//�������
				addStudentNumberText.setBounds(50,100,200,25);
				addPasswordText.setBounds(330,100,200,25);
				addNameText.setBounds(610,100,200,25);
				addSexText.setBounds(50,200,200,25);
				addCollegeText.setBounds(330,200,200,25);
				addMajorText.setBounds(610,200,200,25);
				addStudentClassText.setBounds(50,300,200,25);
				
				
				String[][] tbody = queryDate(state,number);
				
				addStudentNumberText.setText(tbody[0][0]);
				addStudentNumberText.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				addStudentNumberText.setEditable(false);
				
				addPasswordText.setText(tbody[0][1]);
				addPasswordText.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				addPasswordText.setEditable(false);
				
				addNameText.setText(tbody[0][2]);
				addNameText.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				addNameText.setEditable(false);
				
				addSexText.setText(tbody[0][3]);
				addSexText.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				addSexText.setEditable(false);
				
				addCollegeText.setText(tbody[0][4]);
				addCollegeText.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				addCollegeText.setEditable(false);
				
				addMajorText.setText(tbody[0][5]);
				addMajorText.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				addMajorText.setEditable(false);
				
				addStudentClassText.setText(tbody[0][6]);
				addStudentClassText.setFont(new Font("΢���ź�", Font.ITALIC, 20));
				addStudentClassText.setEditable(false);

				this.add(addStudentNumberText);
				this.add(addPasswordText);
				this.add(addNameText);
				this.add(addSexText);
				this.add(addCollegeText);
				this.add(addMajorText);
				this.add(addStudentClassText);
			}
			
	
	public String[][] queryDate(String personnel,String StudentNumber) {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDao();
		ArrayList<Data> dataList=administratorDao.SelectStudent(personnel,StudentNumber);
		String[][] tbody=list2Array(dataList);
		return tbody;
	}
	
	public String[][] list2Array(ArrayList<Data> list) {
		// TODO Auto-generated method stub
		String [][] tbody=new String[list.size()][7];
		for(int i=0;i<list.size();i++){
			Data date=list.get(i);
			tbody[i][0]=date.getStudentNumber();
			tbody[i][1]=date.getPassword();
			tbody[i][2]=date.getName();
			tbody[i][3]=date.getSex();
			tbody[i][4]=date.getCollege();
			tbody[i][5]=date.getMajor();
			tbody[i][6]=date.getStudentClass();
		}
		return tbody;
	}
	
//	public static void main(String[] args) {
//		new Student_Message("teacher","201701081002z").setVisible(true);
//	}
}
