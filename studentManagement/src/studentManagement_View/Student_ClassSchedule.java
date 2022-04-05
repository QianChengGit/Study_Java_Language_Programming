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
	private JLabel tableLabel=new JLabel("�γ̱�");//�б����
	private JScrollPane tablePane=new JScrollPane();//�����ӿ�
	protected JTable table=new JTable();//�б�
	private AdministratorDao administratorDao = new AdministratorDao();
	//���췽��
	public Student_ClassSchedule(String state){
		this(null,true,state);
	}
			
	public Student_ClassSchedule(Frame owner,boolean modal,String state){
		super(owner,modal);
		this.init();//��ʼ������
		this.addComponent(state);//������
				
	}
			
	//��ʼ������
	private void init(){
		this.setTitle("ѧ��ϵͳ��Ϣ����");//���ڱ���
		this.setSize(1000,600);//�����С��λ��
		this.setLocation(400, 200);
		//GUITools.center(this);//���ô�������Ļ�ϵ�λ��
		this.setResizable(false);//�����Сλ��
				
	}
		
	//������
	private void addComponent(String state){
		//ȡ������
		this.setLayout(null);
		//������
		tableLabel.setFont(new Font("����",Font.BOLD,20));
		tableLabel.setBounds(450, 10, 200, 50);
		this.add(tableLabel);
		//���
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setEnabled(false);
		table.setFont(new Font("΢���ź�",Font.BOLD,15));
		queryClassSchedule(state);
		tablePane.setBounds(25, 50, 950, 500);
		tablePane.setViewportView(table);
		this.add(tablePane);
				
	}
			
	
	
	
	
	
	public void queryClassSchedule(String personnel) {
		// TODO Auto-generated method stub
		String[] thead={"ʱ��","����һ","���ڶ�","������","������","������","������","������"};
		ArrayList<Data> dataList=administratorDao.queryclassscheduleData(personnel);
		String[][] tbody=list2Array(dataList);
		TableModel dataModel=new DefaultTableModel(tbody,thead);
		//���ñ�����ݾ�����ʾ
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
