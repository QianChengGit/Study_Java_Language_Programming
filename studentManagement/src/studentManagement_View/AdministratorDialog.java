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
	//�������ʹ�õ��������Ϊ��Ա����
		private JLabel tableLabel=new JLabel("��Ϣ��");//�б����
		private JScrollPane tablePane=new JScrollPane();//�����ӿ�
		protected JTable table=new JTable();//�б�
		private JLabel StudentNumberLabel=new JLabel("ѧ��");//
		private JLabel PasswordLabel=new JLabel("����");//
		private JLabel NameLabel=new JLabel("����");//
		private JLabel SexLabel=new JLabel("�Ա�");//
		private JLabel CollegeLabel=new JLabel("ѧԺ");//
		private JLabel MajorLabel=new JLabel("רҵ");//
		private JLabel StudentClassLabel=new JLabel("�༶");//
		
		//��ӹ������
		protected JTextField addStudentNumberText=new JTextField(6);//��ӱ���ı���
		protected JTextField addPasswordText=new JTextField(6);//��������ı���
		protected JTextField addNameText=new JTextField(6);//��ӵ����ı���
		protected JTextField addSexText=new JTextField(6);//��ӼƼ۵�λ�ı���
		protected JTextField addCollegeText=new JTextField(6);//��ӼƼ۵�λ�ı���
		protected JTextField addMajorText=new JTextField(6);//��ӼƼ۵�λ�ı���
		protected JTextField addStudentClassText=new JTextField(6);//��ӼƼ۵�λ�ı���
		private JButton addBtn=new JButton("���ѧ��");//���ˮ����ť
		
		//�޸Ĺ������
		protected JTextField updateStudentNumberText=new JTextField(6);//�޸ı���ı���
		protected JTextField updatePasswordText=new JTextField(6);//�޸������ı���
		protected JTextField updateNameText=new JTextField(6);//�޸ĵ����ı���
		protected JTextField updateSexText=new JTextField(6);//�޸ļƼ۵�λ�ı���
		protected JTextField updateCollegeText=new JTextField(6);//��ӼƼ۵�λ�ı���
		protected JTextField updateMajorText=new JTextField(6);//��ӼƼ۵�λ�ı���
		protected JTextField updateStudentClassText=new JTextField(6);//��ӼƼ۵�λ�ı���
		private JButton updateBtn=new JButton("�޸���Ϣ");//�޸�ˮ����ť
		
		//ɾ���������
		protected JTextField delStudentNumberText=new JTextField(6);//��ӱ���ı���
		private JButton delBtn=new JButton("ɾ��ѧ��");//ɾ��ˮ����ť
		private AdministratorDao administratorDao = new AdministratorDao();
		
		//���췽��
		public AdministratorDialog(String state){
			this(null,true,state);
		}
		
		public AdministratorDialog(Frame owner,boolean modal,String state){
			super(owner,modal);
			this.init();//��ʼ������
			this.addComponent(state);//������
			this.addListener();//��Ӽ�����
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
			queryDate(state);
			tablePane.setBounds(25, 50, 950, 300);
			tablePane.setViewportView(table);
			this.add(tablePane);
			//�ֶα���
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
			
			//�������
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
			
			//�޸����
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
			
			//ɾ�����
			delStudentNumberText.setBounds(50, 500, 100, 25);
			this.add(delStudentNumberText);
			delBtn.setBounds(850, 500, 90, 25);
			this.add(delBtn);
		}
		
		//��Ӽ�����
		private void addListener(){
			//��Ӱ�ť
			addBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//������ӷ���
					Data teacherData = new Data(addStudentNumberText.getText(),addPasswordText.getText(),addNameText.getText()
							,addSexText.getText(),addCollegeText.getText(),addMajorText.getText(),addStudentClassText.getText());
					AdministratorDao administratorDao = new AdministratorDao();
					administratorDao.addTeacher(teacherData,"teacher");
					System.out.println("1");
					}
				});
			//�޸İ�ť
			updateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//�����޸ķ���
					Data teacherData = new Data(updateStudentNumberText.getText(),updatePasswordText.getText(),updateNameText.getText()
							,updateSexText.getText(),updateCollegeText.getText(),updateMajorText.getText(),updateStudentClassText.getText());
					AdministratorDao administratorDao = new AdministratorDao();
					administratorDao.updateTeacher("teacher",teacherData.getStudentNumber(),"Password",updatePasswordText.getText());
					
					System.out.println("2");
				}
			});
			//ɾ����ť
			delBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//����ɾ������
					Data teacherData = new Data(delStudentNumberText.getText());
					AdministratorDao administratorDao = new AdministratorDao();
					administratorDao.delTeacher("teacher",teacherData.getStudentNumber());//,"Password",updatePasswordText.getText()
					System.out.println("3");
				}
			});
		}
		
		public void queryDate(String personnel) {
			// TODO Auto-generated method stub
			String[] thead={"ѧ��","����","����","�Ա�","ѧԺ","רҵ","�༶"};
			ArrayList<Data> dataList=administratorDao.queryAllData(personnel);
			String[][] tbody=list2Array(dataList);
			TableModel dataModel=new DefaultTableModel(tbody,thead);
			//���ñ�����ݾ�����ʾ
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
