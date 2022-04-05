package studentManagement_View;


import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import studentManagement_Data.Data;
import studentManagement_Service.AdministratorDao;



@SuppressWarnings("serial")
public class AdministratorDialog extends JDialog{
	//定义界面使用到的组件作为成员变量
		private JLabel tableLabel=new JLabel("信息表");//列表标题
		private JScrollPane tablePane=new JScrollPane();//滚动视口
		protected JTable table=new JTable();//列表
		private JLabel StudentNumberLabel=new JLabel("学号");//
		private JLabel PasswordLabel=new JLabel("密码");//
		private JLabel NameLabel=new JLabel("姓名");//
		private JLabel SexLabel=new JLabel("性别");//
		private JLabel CollegeLabel=new JLabel("学院");//
		private JLabel MajorLabel=new JLabel("专业");//
		private JLabel StudentClassLabel=new JLabel("班级");//
		
		//添加功能组件
		protected JTextField addStudentNumberText=new JTextField(6);//添加编号文本框
		protected JTextField addPasswordText=new JTextField(6);//添加名称文本框
		protected JTextField addNameText=new JTextField(6);//添加单价文本框
		protected JTextField addSexText=new JTextField(6);//添加计价单位文本框
		protected JTextField addCollegeText=new JTextField(6);//添加计价单位文本框
		protected JTextField addMajorText=new JTextField(6);//添加计价单位文本框
		protected JTextField addStudentClassText=new JTextField(6);//添加计价单位文本框
		private JButton addBtn=new JButton("添加学生");//添加水果按钮
		
		//修改功能组件
		protected JTextField updateStudentNumberText=new JTextField(6);//修改编号文本框
		protected JTextField updatePasswordText=new JTextField(6);//修改名称文本框
		protected JTextField updateNameText=new JTextField(6);//修改单价文本框
		protected JTextField updateSexText=new JTextField(6);//修改计价单位文本框
		protected JTextField updateCollegeText=new JTextField(6);//添加计价单位文本框
		protected JTextField updateMajorText=new JTextField(6);//添加计价单位文本框
		protected JTextField updateStudentClassText=new JTextField(6);//添加计价单位文本框
		private JButton updateBtn=new JButton("修改信息");//修改水果按钮
		
		//删除功能组件
		protected JTextField delStudentNumberText=new JTextField(6);//添加编号文本框
		private JButton delBtn=new JButton("删除学生");//删除水果按钮
		private AdministratorDao administratorDao = new AdministratorDao();
		
		//构造方法
		public AdministratorDialog(String state){
			this(null,true,state);
		}
		
		public AdministratorDialog(Frame owner,boolean modal,String state){
			super(owner,modal);
			this.init();//初始化操作
			this.addComponent(state);//添加组件
			this.addListener();//添加监听器
		}
		
		//初始化操作
		private void init(){
			this.setTitle("学生系统信息管理");//窗口标题
			this.setSize(1000,600);//窗体大小与位置
			this.setLocation(400, 200);
			//GUITools.center(this);//设置窗口在屏幕上的位置
			this.setResizable(false);//窗体大小位置
			
		}
		
		//添加组件
		private void addComponent(String state){
			//取消布局
			this.setLayout(null);
			//表格标题
			tableLabel.setFont(new Font("黑体",Font.BOLD,20));
			tableLabel.setBounds(450, 10, 200, 50);
			this.add(tableLabel);
			//表格
			table.getTableHeader().setReorderingAllowed(false);
			table.getTableHeader().setResizingAllowed(false);
			table.setEnabled(false);
			queryDate(state);
			tablePane.setBounds(25, 50, 950, 300);
			tablePane.setViewportView(table);
			this.add(tablePane);
			//字段标题
			StudentNumberLabel.setBounds(70,370,70,25);
			PasswordLabel.setBounds(180,370,70,25);
			NameLabel.setBounds(290,370,70,25);
			SexLabel.setBounds(400,370,70,25);
			CollegeLabel.setBounds(510, 370,70,25);
			MajorLabel.setBounds(620, 370,70,25);
			StudentClassLabel.setBounds(730, 370,70,25);
			this.add(StudentNumberLabel);
			this.add(PasswordLabel);
			this.add(NameLabel);
			this.add(SexLabel);
			this.add(CollegeLabel);
			this.add(MajorLabel);
			this.add(StudentClassLabel);
			
			//增加组件
			addStudentNumberText.setBounds(50,400,100,25);
			addPasswordText.setBounds(160,400,100,25);
			addNameText.setBounds(270,400,100,25);
			addSexText.setBounds(380,400,100,25);
			addCollegeText.setBounds(490,400,100,25);
			addMajorText.setBounds(600,400,100,25);
			addStudentClassText.setBounds(710,400,100,25);
			this.add(addStudentNumberText);
			this.add(addPasswordText);
			this.add(addNameText);
			this.add(addSexText);
			this.add(addCollegeText);
			this.add(addMajorText);
			this.add(addStudentClassText);
			addBtn.setBounds(850, 400, 90, 25);
			this.add(addBtn);
			
			//修改组件
			updateStudentNumberText.setBounds(50,450,100,25);
			updatePasswordText.setBounds(160,450,100,25);
			updateNameText.setBounds(270,450,100,25);
			updateSexText.setBounds(380,450,100,25);
			updateCollegeText.setBounds(490,450,100,25);
			updateMajorText.setBounds(600,450,100,25);
			updateStudentClassText.setBounds(710,450,100,25);
			this.add(updateStudentNumberText);
			this.add(updatePasswordText);
			this.add(updateNameText);
			this.add(updateSexText);
			this.add(updateCollegeText);
			this.add(updateMajorText);
			this.add(updateStudentClassText);
			updateBtn.setBounds(850,450, 90, 25);
			this.add(updateBtn);
			
			//删除组件
			delStudentNumberText.setBounds(50, 500, 100, 25);
			this.add(delStudentNumberText);
			delBtn.setBounds(850, 500, 90, 25);
			this.add(delBtn);
		}
		
		//添加监听器
		private void addListener(){
			//添加按钮
			addBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//调用添加方法
					Data teacherData = new Data(addStudentNumberText.getText(),addPasswordText.getText(),addNameText.getText()
							,addSexText.getText(),addCollegeText.getText(),addMajorText.getText(),addStudentClassText.getText());
					AdministratorDao administratorDao = new AdministratorDao();
					administratorDao.addTeacher(teacherData,"teacher");
					System.out.println("1");
					}
				});
			//修改按钮
			updateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//调用修改方法
					Data teacherData = new Data(updateStudentNumberText.getText(),updatePasswordText.getText(),updateNameText.getText()
							,updateSexText.getText(),updateCollegeText.getText(),updateMajorText.getText(),updateStudentClassText.getText());
					AdministratorDao administratorDao = new AdministratorDao();
					administratorDao.updateTeacher("teacher",teacherData.getStudentNumber(),"Password",updatePasswordText.getText());
					
					System.out.println("2");
				}
			});
			//删除按钮
			delBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//调用删除方法
					Data teacherData = new Data(delStudentNumberText.getText());
					AdministratorDao administratorDao = new AdministratorDao();
					administratorDao.delTeacher("teacher",teacherData.getStudentNumber());//,"Password",updatePasswordText.getText()
					System.out.println("3");
				}
			});
		}
		
		public void queryDate(String personnel) {
			// TODO Auto-generated method stub
			String[] thead={"学号","密码","姓名","性别","学院","专业","班级"};
			ArrayList<Data> dataList=administratorDao.queryAllData(personnel);
			String[][] tbody=list2Array(dataList);
			TableModel dataModel=new DefaultTableModel(tbody,thead);
			//设置表格内容居中显示
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(JLabel.CENTER);
			table.setDefaultRenderer(Object.class, tcr);
			table.setModel(dataModel);
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
		
//		public static void main(String[] args) {
//			new AdministratorDialog("teacher").setVisible(true);
//		}
//		
}
