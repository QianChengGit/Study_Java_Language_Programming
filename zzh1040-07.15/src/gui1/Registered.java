package gui1;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
public class Registered extends JFrame implements ActionListener{
	JFrame jf=new JFrame("�û�ע��");
	JPanel jp1=new JPanel();
	ImageIcon background = new ImageIcon("C:\\Users\\Administrator\\Desktop\\ps��ҵ\\�ز�\\17-1���ࣺ���츺ƬЧ��.jpg");
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
    protected JTextField jt4 = new JTextField(4);
    protected JTextField jt5 = new JTextField(4);
    protected JTextField jt6 = new JTextField(4);
    protected JTextField jt7 = new JTextField(4);
    Icon ic1=new ImageIcon("C:\\Users\\Administrator\\Desktop\\ps��ҵ\\JAVA���\\����-1.jpg");
    Icon ic2=new ImageIcon("C:\\Users\\Administrator\\Desktop\\ps��ҵ\\JAVA���\\�ύ-1.jpg");
    JButton btn1 = new JButton(ic1);
    JButton btn2 = new JButton(ic2);
	public void Registered(){
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
		
		
		lb0.setForeground(Color.CYAN);
        lb0.setFont(new Font("����",Font.ITALIC,30));
        lb0.setBounds(350, 30, 400, 30);
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
        jt1.setBounds(400, 100, 280, 30);
        jt2.setBackground(Color.lightGray);
        jt2.setForeground(Color.red);
        jt2.setBounds(400, 150, 280, 30);
        jt3.setBackground(Color.lightGray);
        jt3.setForeground(Color.red);
        jt3.setBounds(400, 200, 280, 30);
        jt4.setBackground(Color.lightGray);
        jt4.setForeground(Color.red);
        jt4.setBounds(400, 250, 280, 30);
        jt5.setBackground(Color.lightGray);
        jt5.setForeground(Color.red);
        jt5.setBounds(400, 300, 280, 30);
        jt6.setBackground(Color.lightGray);
        jt6.setForeground(Color.red);
        jt6.setBounds(400, 350, 280, 30);
        jt7.setBackground(Color.lightGray);
        jt7.setForeground(Color.red);
        jt7.setBounds(400, 400, 280, 30);
		btn1.setBounds(10, 10, 80, 40);
		btn2.setBounds(510, 500, 80, 40);
		
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
        
		jf.setSize(1000,600);//���ô��ڴ�Сbackground.getIconWidth(),background.getIconHeight()
		jf.setBounds(460, 260, 1000, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ϊ���ڹر����ע�������
		jf.setVisible(true);//����������Ϊ��ʾ״̬
		//���ذ�ť�¼�����
		btn1.addActionListener(this);
		btn1.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����ɵ����¼�");
				if(e.getButton()==e.BUTTON1){
					System.out.println("�������¼�");
					//��ת�׽���
					Example example=new Example();
					example.init();
					//ע����ǰҳ��
					jf.dispose();
					
				}
				if(e.getButton()==e.BUTTON2){
					System.out.println("����м������¼�");
				}
				if(e.getButton() == e.BUTTON3){
					System.out.println("����һ��¼�");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��갴���¼�");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���ſ��¼�");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����뷵�ذ�ť�����¼�");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("����Ƴ����ذ�ť�����¼�");
			}
     	
     });
		//�ύ��ť�¼�����
		btn2.addActionListener(this);
		btn2.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����ɵ����¼�");
				if(e.getButton()==e.BUTTON1){
					System.out.println("�������¼�");
					//��ת�׽���
					Example example=new Example();
					example.init();
					//ע����ǰҳ��
					jf.dispose();
					
				}
				if(e.getButton()==e.BUTTON2){
					System.out.println("����м������¼�");
				}
				if(e.getButton() == e.BUTTON3){
					System.out.println("����һ��¼�");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��갴���¼�");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���ſ��¼�");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����뷵�ذ�ť�����¼�");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("����Ƴ����ذ�ť�����¼�");
			}
     	
     });
		
		jf.add(jpanel);
		jt1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				int KeyCode=e.getKeyCode();
				String s=KeyEvent.getKeyText(KeyCode);
				System.out.println(s);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
//	public static void main(String[] args) {
//		Registered re=new Registered();
//		re.Registered();
//	}
//	
}
