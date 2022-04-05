package studentManagement;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import studentManagement_Data.Data;
import studentManagement_Service.AdministratorDao;
import studentManagement_View.Administrator;
import studentManagement_View.Student;
import studentManagement_View.Teacher;

public class StudentAdministrator {
	JFrame jf1=new JFrame("学生信息表格");
	JScrollPane scrollPane=new JScrollPane();
	JScrollPane scrollPane01=new JScrollPane();
	JPanel jp=new JPanel();
	Icon ic1=new ImageIcon("lib\\返回-1.jpg");
	JButton button1=new JButton(ic1);
	
	JTable table = new JTable();
	private AdministratorDao administratorDao = new AdministratorDao();
	private String state;
	public void init(String personnel){
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setEnabled(false);
		queryFruitItem(personnel);
		jp.add(button1);
		jp.setBounds(0, 0, 500, 20);
		scrollPane.setViewportView(table);
		scrollPane01.setViewportView(jp);
		jf1.add(scrollPane,BorderLayout.CENTER);
		jf1.add(scrollPane01,BorderLayout.SOUTH);
		jf1.pack();
		jf1.setBounds(460, 260, 1000, 600);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setVisible(true);
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(state.equals("student")){
					new Student("201701081001");
				}else if(state.equals("teacher")){
					new Teacher("  ");
				}else if(state.equals("administrator")){
					new Administrator("  ");
				}
				jf1.dispose();
			}
		});	
	}
	
	public void queryFruitItem(String personnel) {
		// TODO Auto-generated method stub
		String[] thead={"学号","密码","姓名","性别","学院","专业","班级"};
		ArrayList<Data> dataList=administratorDao.queryAllData(personnel);
		String[][] tbody=list2Array(dataList);
		TableModel dataModel=new DefaultTableModel(tbody,thead);
		table.setModel(dataModel);
	}
	
	//将集合转换为二维数组的方法
	public String[][] list2Array(ArrayList<Data> list) {
		// TODO Auto-generated method stub
		String [][] tbody=new String[list.size()][7];
		for(int i=0;i<list.size();i++){
			Data fruitItem=list.get(i);
			tbody[i][0]=fruitItem.getStudentNumber();
			tbody[i][1]=fruitItem.getPassword();
			tbody[i][2]=fruitItem.getName();
			tbody[i][3]=fruitItem.getSex();
			tbody[i][4]=fruitItem.getCollege();
			tbody[i][5]=fruitItem.getMajor();
			tbody[i][6]=fruitItem.getStudentClass();
		}
		
		return tbody;
	}
	
	public static void main(String[] args) {
		new StudentAdministrator().init("teacher");
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
