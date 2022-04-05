package studentManagement_App;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import studentManagement_Service.AdministratorDao;
import studentManagement_Tool.Media;
import studentManagement_Tool.VerificationCode;
import studentManagement_View.Administrator;
import studentManagement_View.Registered;
import studentManagement_View.Student;
import studentManagement_View.Teacher;
@SuppressWarnings("serial")

public class Test extends JFrame{
	JFrame jf = new JFrame("[��ӭ����������ϵͳ]");
    JLabel lb0 = new JLabel("     ��ӭ����ѧ������ϵͳ");
    JLabel lb1 = new JLabel("��  ��  ��:");
    JLabel lb2 = new JLabel("��      ��:");
    JLabel lb3 = new JLabel("��  ֤  ��:");
    /*
     * ���ر���ͼƬ
     */
    ImageIcon background = new ImageIcon("lib\\17-1���ࣺ���츺ƬЧ��.jpg");
    JLabel label = new JLabel(background);
    Icon ic1=new ImageIcon("lib\\��һ��-1.jpg");
    Icon ic2=new ImageIcon("lib\\��¼-1.jpg");
    Icon ic3=new ImageIcon("lib\\�˳�-1.jpg");
    Icon ic4=new ImageIcon("lib\\ע��-1.jpg");
    protected JTextField jt1 = new JTextField(25);
    protected JPasswordField jt2 = new JPasswordField(25);
    protected JTextField jt3 = new JTextField(4);
    JButton btn1 = new JButton(ic2);
    JButton btn2 = new JButton(ic3);
    JButton btn3 = new JButton(ic4);
    JButton btn4 = new JButton(ic1);
    private JPanel jp01 =new JPanel();
    private ButtonGroup group; 
    private String state = "û��ѡ����Ա";//��¼״̬
    public void init() {
        /*
         * ���ñ�ǩ��С
         */
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
        final JPanel jpanel = new JPanel();
        jpanel.setOpaque(false);
        
        /*
         * ȥ��JPanelĬ�ϲ��ַ�ʽ,��ʵ�ָ����ؼ��Լ��Ķ�λ
         */
        
        jpanel.setLayout(null);
        
        final VerificationCode vc = new VerificationCode();//��֤��
        group = new ButtonGroup();//ʵ������ѡ��ť��
        
        addJRadioButton("ѧ����¼");
        addJRadioButton("��ʦ��¼");
        addJRadioButton("����Ա��¼");
        
		
        lb0.setForeground(Color.CYAN);
        lb0.setFont(new Font("����",Font.ITALIC,30));
        lb0.setBounds(310, 30, 400, 30);
        lb1.setForeground(Color.yellow);
        lb1.setFont(new Font("����",Font.PLAIN,20));
        lb1.setBounds(270, 100, 200,30);
        lb2.setForeground(Color.yellow);
        lb2.setFont(new Font("����",Font.PLAIN,20));
        lb2.setBounds(270, 200, 200, 30);
        lb3.setForeground(Color.yellow);
        lb3.setFont(new Font("����",Font.PLAIN,20));
        lb3.setBounds(270, 300, 200, 30);
        jt1.setForeground(Color.red);
        jt1.setFont(new Font("����",Font.PLAIN,20));
        jt1.setBackground(Color.lightGray);
        jt1.setBounds(400, 100, 280, 40);
        jt2.setForeground(Color.red);
        jt2.setFont(new Font("",Font.PLAIN,20));
        jt2.setBackground(Color.lightGray);
        jt2.setBounds(400, 200, 280, 40);
        jt3.setForeground(Color.red);
        jt3.setFont(new Font("����",Font.PLAIN,20));
        jt3.setBackground(Color.lightGray);
        jt3.setBounds(400, 300, 90, 40);
        btn1.setBounds(260, 440, 90, 40);
        btn2.setBounds(460, 440, 90, 40);
        btn3.setBounds(660, 440, 90, 40);
        btn4.setBounds(600, 300, 80, 40);
        vc.setBounds(495, 300, 100, 40);//��֤��

        jpanel.add(lb0);
        jpanel.add(lb1);
        jpanel.add(lb2);
        jpanel.add(lb3);
        jpanel.add(btn1);
        jpanel.add(btn2);
        jpanel.add(btn3);
        jpanel.add(btn4);
        jpanel.add(jt1);
        jpanel.add(jt2);
        jpanel.add(jt3);
        jpanel.add(vc);
        //���ô���ͼ��
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image im = kit.createImage("lib\\3-2-4.jpg");
        jf.setIconImage(im);
        
        jp01.setBounds(340,370 ,400 , 40);
        jp01.setOpaque(false);
        jf.add(jp01);
        jf.add(jpanel);
        jf.setBounds(460, 260, 1000, 600);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //��¼��ť�¼�����������
        btn1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e){
				AdministratorDao administratorDao = new AdministratorDao();
				if(state.equals("ѧ����¼")){
					String user = administratorDao.SelectTeacher("student", jt1.getText(), "StudentNumber", "Password"); 
					if((jt1.getText()+jt2.getText()).equals(user) && jt3.getText().equals(vc.getSt())){
						//ģ̬�Ի���
						JOptionPane.showMessageDialog(new JFrame(),"��¼�ɹ���");
						@SuppressWarnings("unused")
						Student student = new Student(jt1.getText());
						//ע����ǰҳ��
						jf.dispose();
					}
					else if(jt1.getText().equals("") && jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"�˺ź����벻��Ϊ�գ�");
					}
					else if(jt1.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"�˺Ų���Ϊ�գ�");
					}
					else if(jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"���벻��Ϊ�գ�");
					}
					else{
						JOptionPane.showMessageDialog(new JFrame(),"��¼ʧ�ܣ������������˺ţ����룡");
					}
				}else if(state.equals("��ʦ��¼")){
					String user = administratorDao.SelectTeacher("teacher", jt1.getText(), "StudentNumber", "Password"); 
					if((jt1.getText()+jt2.getText()).equals(user) && jt3.getText().equals(vc.getSt())){
						//ģ̬�Ի���
						JOptionPane.showMessageDialog(new JFrame(),"��¼�ɹ���");
						@SuppressWarnings("unused")
						Teacher teacher = new Teacher(jt1.getText());
						//ע����ǰҳ��
						jf.dispose();
					}
					else if(jt1.getText().equals("") && jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"�˺ź����벻��Ϊ�գ�");
					}
					else if(jt1.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"�˺Ų���Ϊ�գ�");
					}
					else if(jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"���벻��Ϊ�գ�");
					}
					else{
						JOptionPane.showMessageDialog(new JFrame(),"��¼ʧ�ܣ������������˺ţ����룡");
					}	
				}else if(state.equals("����Ա��¼")){
					String user = administratorDao.SelectTeacher("administrator", jt1.getText(), "StudentNumber", "Password"); 
					if((jt1.getText()+jt2.getText()).equals(user) && jt3.getText().equals(vc.getSt())){
						//ģ̬�Ի���
						JOptionPane.showMessageDialog(new JFrame(),"��¼�ɹ���");
						@SuppressWarnings("unused")
						Administrator administrator = new Administrator(jt1.getText());
						//ע����ǰҳ��
						jf.dispose();
					}
					else if(jt1.getText().equals("") && jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"�˺ź����벻��Ϊ�գ�");
					}
					else if(jt1.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"�˺Ų���Ϊ�գ�");
					}
					else if(jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"���벻��Ϊ�գ�");
					}
					else{
						JOptionPane.showMessageDialog(new JFrame(),"��¼ʧ�ܣ������������˺ţ����룡");
					}	
					
				}else if(state.equals("û��ѡ����Ա")){
					JOptionPane.showMessageDialog(new JFrame(),"��ѡ���¼��Ա��");
				}
			}
        });
        //�˳�ϵͳ��ť�¼�����������
        btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(),"ȷ��Ҫ�˳���");
				System.out.println("�ر��˴��ڣ���");
				System.exit(0);
			}
		});
        //ע�ᰴť�¼�����������
        btn3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Registered register= new Registered();
				jf.dispose();
			}	
        });
        //��֤�뻻һ�Ű�ť�¼�����������
        btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					vc.getpaint();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			    jpanel.add(vc);
			    jf.add(jpanel);
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
				if("ѧ����¼".equals(text)){
					state = "ѧ����¼";
					
				}else if("��ʦ��¼".equals(text)){
					state = "��ʦ��¼";
					
				}else if("����Ա��¼".equals(text)){
					state = "����Ա��¼";	
				}
			}
		});
    }
    //��¼���汳������
    public void Medio(){
    	Media media = new Media();
        Thread thread = new Thread(media);
        thread.start();
    }
    
	public static void main(String[] args) {
        Test test = new Test();
        test.init();
        test.Medio();
    }
}
