package studentManagement_View;

import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import studentManagement_Data.Data;
import studentManagement_Service.AdministratorDao;

@SuppressWarnings("serial")
public class Student_ClassSchedule extends JDialog{
	private JLabel tableLabel=new JLabel("课程表");//列表标题
	private JScrollPane tablePane=new JScrollPane();//滚动视口
	protected JTable table=new JTable();//列表
	private AdministratorDao administratorDao = new AdministratorDao();
	//构造方法
	public Student_ClassSchedule(String state){
		this(null,true,state);
	}
			
	public Student_ClassSchedule(Frame owner,boolean modal,String state){
		super(owner,modal);
		this.init();//初始化操作
		this.addComponent(state);//添加组件
				
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
		table.setFont(new Font("微软雅黑",Font.BOLD,15));
		queryClassSchedule(state);
		tablePane.setBounds(25, 50, 950, 500);
		tablePane.setViewportView(table);
		this.add(tablePane);
				
	}
			
	
	
	
	
	
	public void queryClassSchedule(String personnel) {
		// TODO Auto-generated method stub
		String[] thead={"时间","星期一","星期二","星期三","星期四","星期五","星期六","星期天"};
		ArrayList<Data> dataList=administratorDao.queryclassscheduleData(personnel);
		String[][] tbody=list2Array(dataList);
		TableModel dataModel=new DefaultTableModel(tbody,thead);
		//设置表格内容居中显示
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		table.setRowHeight(60);
		table.setModel(dataModel);
	}
	
	public String[][] list2Array(ArrayList<Data> list) {
		// TODO Auto-generated method stub
		String [][] tbody=new String[list.size()][8];
		for(int i=0;i<list.size();i++){
			Data fruitItem=list.get(i);
			tbody[i][0]=fruitItem.getStudentNumber();
			tbody[i][1]=fruitItem.getPassword();
			tbody[i][2]=fruitItem.getName();
			tbody[i][3]=fruitItem.getSex();
			tbody[i][4]=fruitItem.getCollege();
			tbody[i][5]=fruitItem.getMajor();
			tbody[i][6]=fruitItem.getStudentClass();
			tbody[i][7]=fruitItem.getState();
		}
		
		return tbody;
	}
	
//	public static void main(String[] args) {
//		new Student_ClassSchedule("classschedule").setVisible(true);
//	}
}
