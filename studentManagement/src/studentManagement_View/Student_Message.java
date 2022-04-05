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
	//标签
	private JLabel tableLabel=new JLabel("学生个人信息表");//列表标题
	private JLabel StudentNumberLabel=new JLabel("学  号");//
	private JLabel PasswordLabel=new JLabel("密  码");//
	private JLabel NameLabel=new JLabel("姓  名");//
	private JLabel SexLabel=new JLabel("性  别");//
	private JLabel CollegeLabel=new JLabel("学  院");//
	private JLabel MajorLabel=new JLabel("专  业");//
	private JLabel StudentClassLabel=new JLabel("班  级");//
	//文本框
	protected JTextArea addStudentNumberText=new JTextArea();//添加编号文本框
	protected JTextArea addPasswordText=new JTextArea();//添加名称文本框
	protected JTextArea addNameText=new JTextArea();//添加单价文本框
	protected JTextArea addSexText=new JTextArea();//添加计价单位文本框
	protected JTextArea addCollegeText=new JTextArea();//添加计价单位文本框
	protected JTextArea addMajorText=new JTextArea();//添加计价单位文本框
	protected JTextArea addStudentClassText=new JTextArea();//添加计价单位文本框
	
	
	//构造方法
			public Student_Message(String state,String number){
				this(null,true,state,number);
			}
			
			public Student_Message(Frame owner,boolean modal,String state,String number){
				super(owner,modal);
				this.init();//初始化操作
				this.addComponent(state,number);//添加组件
				
			}
	
	//初始化操作
			private void init(){
				this.setTitle("学生个人信息");//窗口标题
				this.setSize(860,500);//窗体大小与位置
				this.setLocation(400, 200);
				this.setResizable(false);//窗体大小位置
				
			}
			
			//添加组件
			private void addComponent(String state,String number){
				//取消布局
				this.setLayout(null);
				//表格标题
				tableLabel.setFont(new Font("黑体",Font.BOLD,20));
				tableLabel.setForeground(Color.orange);
				tableLabel.setBounds(350, 10, 200, 50);
				this.add(tableLabel);
	
				//字段标题
				StudentNumberLabel.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				StudentNumberLabel.setForeground(Color.RED);
				StudentNumberLabel.setBounds(120,70,70,25);
				PasswordLabel.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				PasswordLabel.setForeground(Color.orange);
				PasswordLabel.setBounds(400,70,70,25);
				NameLabel.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				NameLabel.setForeground(Color.BLUE);
				NameLabel.setBounds(680,70,70,25);
				SexLabel.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				SexLabel.setForeground(Color.GREEN);
				SexLabel.setBounds(120,170,70,25);
				CollegeLabel.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				CollegeLabel.setForeground(Color.CYAN);
				CollegeLabel.setBounds(400, 170,70,25);
				MajorLabel.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				MajorLabel.setForeground(Color.PINK);
				MajorLabel.setBounds(680, 170,70,25);
				StudentClassLabel.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				StudentClassLabel.setForeground(Color.CYAN);
				StudentClassLabel.setBounds(120, 270,70,25);
				this.add(StudentNumberLabel);
				this.add(PasswordLabel);
				this.add(NameLabel);
				this.add(SexLabel);
				this.add(CollegeLabel);
				this.add(MajorLabel);
				this.add(StudentClassLabel);
				
				//增加组件
				addStudentNumberText.setBounds(50,100,200,25);
				addPasswordText.setBounds(330,100,200,25);
				addNameText.setBounds(610,100,200,25);
				addSexText.setBounds(50,200,200,25);
				addCollegeText.setBounds(330,200,200,25);
				addMajorText.setBounds(610,200,200,25);
				addStudentClassText.setBounds(50,300,200,25);
				
				
				String[][] tbody = queryDate(state,number);
				
				addStudentNumberText.setText(tbody[0][0]);
				addStudentNumberText.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				addStudentNumberText.setEditable(false);
				
				addPasswordText.setText(tbody[0][1]);
				addPasswordText.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				addPasswordText.setEditable(false);
				
				addNameText.setText(tbody[0][2]);
				addNameText.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				addNameText.setEditable(false);
				
				addSexText.setText(tbody[0][3]);
				addSexText.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				addSexText.setEditable(false);
				
				addCollegeText.setText(tbody[0][4]);
				addCollegeText.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				addCollegeText.setEditable(false);
				
				addMajorText.setText(tbody[0][5]);
				addMajorText.setFont(new Font("微软雅黑", Font.ITALIC, 20));
				addMajorText.setEditable(false);
				
				addStudentClassText.setText(tbody[0][6]);
				addStudentClassText.setFont(new Font("微软雅黑", Font.ITALIC, 20));
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
