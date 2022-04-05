package studentManagement_View;
import javax.swing.*;

import studentManagement_App.Test;
import studentManagement_Data.Data;
import studentManagement_Service.AdministratorDao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Registered extends JFrame{
	JFrame jf=new JFrame("�û�ע��");
	ImageIcon background = new ImageIcon("lib\\17-1���ࣺ���츺ƬЧ��.jpg");
    JLabel label = new JLabel(background);
	JLabel lb0 = new JLabel("     ��ӭ����ע��ϵͳ");
    JLabel lb1 = new JLabel("ѧ��:");
    JLabel lb2 = new JLabel("����:");
    JLabel lb3 = new JLabel("����:");
    JLabel lb4 = new JLabel("�Ա�:");
    JLabel lb5 = new JLabel("ѧԺ:");
    JLabel lb6 = new JLabel("רҵ:");
    JLabel lb7 = new JLabel("�༶:");
    protected JTextField jt1 = new JTextField(25);
    protected JPasswordField jt2 = new JPasswordField(25);
    protected JTextField jt3 = new JTextField(4);
    protected JComboBox<String> jt4 = new JComboBox<String>();
    protected JComboBox<String> jt5 = new JComboBox<String>();
    protected JTextField jt6 = new JTextField(4);
    protected JTextField jt7 = new JTextField(4);
    Icon ic1=new ImageIcon("lib\\����-1.jpg");
    Icon ic2=new ImageIcon("lib\\�ύ-1.jpg");
    JButton btn1 = new JButton(ic1);
    JButton btn2 = new JButton(ic2);
    
    private JPanel jp01 =new JPanel();
    private ButtonGroup group; 
    private String state = "û��ѡ����Ա";//��¼״̬
	public Registered(){
		//����ͼƬ��ǩ���꼰��С
		 label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		 /*
         * ������������JPanel
         */
        
        jf.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        JPanel jp = (JPanel) jf.getContentPane();
        
        /*
         * JPanel����ſ��Ե���setOpaque(false);�����Ƿ�͸��
         */
        
        jp.setOpaque(false);
        JPanel jpanel = new JPanel();
        jpanel.setOpaque(false);
        
        /*
         * ȥ��JPanelĬ�ϲ��ַ�ʽ,��ʵ�ָ����ؼ��Լ��Ķ�λ
         */
        
        jpanel.setLayout(null);
        
        group = new ButtonGroup();//ʵ������ѡ��ť��
        addJRadioButton("ѧ��ע��");
        addJRadioButton("��ʦע��");
        addJRadioButton("����Աע��");
		
		
		lb0.setForeground(Color.CYAN);
        lb0.setFont(new Font("����",Font.ITALIC,30));
        lb0.setBounds(300, 30, 400, 30);
        lb1.setForeground(Color.yellow);
        lb1.setFont(new Font("����",Font.PLAIN,20));
        lb1.setBounds(350, 100, 120,30);
        lb2.setForeground(Color.yellow);
        lb2.setFont(new Font("����",Font.PLAIN,20));
        lb2.setBounds(350, 150, 120, 30);
        lb3.setForeground(Color.yellow);
        lb3.setFont(new Font("����",Font.PLAIN,20));
        lb3.setBounds(350, 200, 120, 30);
        lb4.setForeground(Color.yellow);
        lb4.setFont(new Font("����",Font.PLAIN,20));
        lb4.setBounds(350, 250, 120,30);
        lb5.setForeground(Color.yellow);
        lb5.setFont(new Font("����",Font.PLAIN,20));
        lb5.setBounds(350, 300, 120,30);
        lb6.setForeground(Color.yellow);
        lb6.setFont(new Font("����",Font.PLAIN,20));
        lb6.setBounds(350, 350, 120,30);
        lb7.setForeground(Color.yellow);
        lb7.setFont(new Font("����",Font.PLAIN,20));
        lb7.setBounds(350, 400, 120,30);
       
        jt1.setBackground(Color.lightGray);
        jt1.setForeground(Color.red);
        jt1.setBounds(400, 100, 220, 30);
        jt2.setBackground(Color.lightGray);
        jt2.setForeground(Color.red);
        jt2.setBounds(400, 150, 220, 30);
        jt3.setBackground(Color.lightGray);
        jt3.setForeground(Color.red);
        jt3.setBounds(400, 200, 220, 30);
        jt4.setBackground(Color.lightGray);
        jt4.setForeground(Color.red);
        jt4.setBounds(400, 250, 150, 30);
        jt4.addItem("<--��ѡ���Ա�-->");
        jt4.addItem("��");
        jt4.addItem("Ů");
        jt5.setBackground(Color.lightGray);
        jt5.setForeground(Color.red);
        jt5.setBounds(400, 300, 150, 30);
        jt5.addItem("<--��ѡ��ѧԺ-->");
        jt5.addItem("��������Ϣ����ѧԺ");
        jt5.addItem("��֯����ѧԺ");
        jt5.addItem("�����ѧԺ");
        jt5.addItem("�����뻷��ѧԺ");
        jt5.addItem("��������ѧԺ");
        jt5.addItem("��е����ѧԺ");
        jt5.addItem("��װѧԺ");
        jt5.addItem("����ѧԺ");
        jt5.addItem("���ù���ѧԺ");
        jt6.setBackground(Color.lightGray);
        jt6.setForeground(Color.red);
        jt6.setBounds(400, 350, 220, 30);
        jt7.setBackground(Color.lightGray);
        jt7.setForeground(Color.red);
        jt7.setBounds(400, 400, 220, 30);
		btn1.setBounds(410, 500, 80, 40);
		btn2.setBounds(530, 500, 80, 40);
		
        jpanel.add(lb0);
        jpanel.add(lb1);
        jpanel.add(lb2);
        jpanel.add(lb3);
        jpanel.add(lb4);
        jpanel.add(lb5);
        jpanel.add(lb6);
        jpanel.add(lb7);
        jpanel.add(jt1);
        jpanel.add(jt2);
        jpanel.add(jt3);
        jpanel.add(jt4);
        jpanel.add(jt5);
        jpanel.add(jt6);
        jpanel.add(jt7);
        jpanel.add(btn1);
        jpanel.add(btn2);
        
        jp01.setBounds(320,440 ,400 , 40);
        jp01.setOpaque(false);
        jf.add(jp01);
        jf.add(jpanel);
		jf.setSize(1000,600);//���ô��ڴ�Сbackground.getIconWidth(),background.getIconHeight()
		jf.setBounds(460, 260, 1000, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ϊ���ڹر����ע�������
		jf.setVisible(true);//����������Ϊ��ʾ״̬
		//���ذ�ť�¼�����
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					//��ת�׽���
					Test test=new Test();
					test.init();
					//ע����ǰҳ��
					jf.dispose();
			}
		});
		//�ύ��ť�¼�����
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ע����Ϣд�����ݿ�
				if(state.equals("ѧ��ע��")){
					
					@SuppressWarnings("deprecation")
					Data teacherData = new Data(jt1.getText(),jt2.getText(),jt3.getText()
							,(String)jt4.getSelectedItem(),(String)jt5.getSelectedItem(),jt6.getText(),jt7.getText(),state);
					AdministratorDao administratorDao = new AdministratorDao();
					administratorDao.addTeacher(teacherData,"student");
					JOptionPane.showMessageDialog(new JFrame(),"ע��ɹ���");
					//��ת�׽���
					Test test=new Test();
					test.init();
					//ע����ǰҳ��
					jf.dispose();
				}else if(state.equals("��ʦע��")){
					
					@SuppressWarnings("deprecation")
					Data teacherData = new Data(jt1.getText(),jt2.getText(),jt3.getText()
							,(String)jt4.getSelectedItem(),(String)jt5.getSelectedItem(),jt6.getText(),jt7.getText(),state);
					AdministratorDao administratorDao = new AdministratorDao();
					administratorDao.addTeacher(teacherData,"teacher");
					JOptionPane.showMessageDialog(new JFrame(),"ע��ɹ���");
					//��ת�׽���
					Test test=new Test();
					test.init();
					//ע����ǰҳ��
					jf.dispose();
				}else if(state.equals("����Աע��")){
					
					@SuppressWarnings("deprecation")
					Data teacherData = new Data(jt1.getText(),jt2.getText(),jt3.getText()
							,(String)jt4.getSelectedItem(),(String)jt5.getSelectedItem(),jt6.getText(),jt7.getText(),state);
					AdministratorDao administratorDao = new AdministratorDao();
					administratorDao.addTeacher(teacherData,"administrator");
					JOptionPane.showMessageDialog(new JFrame(),"ע��ɹ���");
					//��ת�׽���
					Test test=new Test();
					test.init();
					//ע����ǰҳ��
					jf.dispose();
				}else if(state.equals("û��ѡ����Ա")){
					JOptionPane.showMessageDialog(new JFrame(),"��ѡ��ע����Ա��");
				}
			}
		});
		
	}
	
	//��ѡ��
    private void addJRadioButton(final String text){
    	JRadioButton radioButton = new JRadioButton(text);
    	radioButton.setContentAreaFilled(false);
    	radioButton.setForeground(Color.CYAN);
    	radioButton.setFont(new Font("΢���ź�", 0, 20));
    	group.add(radioButton);
    	jp01.add(radioButton);
    	radioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if("ѧ��ע��".equals(text)){
					state = "ѧ��ע��";
					
				}else if("��ʦע��".equals(text)){
					state = "��ʦע��";
					
				}else if("����Աע��".equals(text)){
					state = "����Աע��";	
				}
			}
		});
    }
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Registered re=new Registered();
		
	}
	
}

