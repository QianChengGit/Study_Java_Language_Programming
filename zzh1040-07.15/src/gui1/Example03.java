package gui1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Example extends JFrame implements ActionListener{
    JFrame jf = new JFrame("[��ӭ����������ϵͳ]");
    JLabel lb0 = new JLabel("     ��ӭ����ѧ������ϵͳ");
    JLabel lb1 = new JLabel("��       ��      ��:");
    JLabel lb2 = new JLabel("��               ��:");
    JLabel lb3 = new JLabel("��       ֤      ��:");
   
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
        
    public void init() {
        /*
         * ���ñ�ǩ��С
         */
    	//
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
        
        Example08 jpanpel01=new Example08();//��֤��
    //    String hp=jpanpel01.paint(getGraphics());
       
        lb0.setForeground(Color.CYAN);
        lb0.setFont(new Font("����",Font.ITALIC,30));
        lb0.setBounds(310, 30, 400, 30);
        lb1.setForeground(Color.yellow);
        lb1.setFont(new Font("����",Font.PLAIN,20));
        lb1.setBounds(180, 100, 200,30);
        lb2.setForeground(Color.yellow);
        lb2.setFont(new Font("����",Font.PLAIN,20));
        lb2.setBounds(180, 200, 220, 30);
        lb3.setForeground(Color.yellow);
        lb3.setFont(new Font("����",Font.PLAIN,20));
        lb3.setBounds(180, 300, 200, 30);
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
        jpanpel01.setBounds(495, 300, 100, 40);//��֤��

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
        jpanel.add(jpanpel01);
        //���ô���ͼ��
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image im = kit.createImage("lib\\3-2-4.jpg");
        jf.setIconImage(im);
        
        jf.add(jpanel);
        jf.setBounds(460, 260, 1000, 600);
        jf.setVisible(true);
        
        //��֤�뻻һ�Ű�ť�¼�����������
        btn4.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����ɵ����¼�");
				if(e.getButton()==e.BUTTON1){
					System.out.println("�������¼�");
					Example08 jpanpel02=new Example08();
					jpanpel02.setBounds(495, 300, 100, 40);//��֤��
					JPanel jpanel=new JPanel();
			        jpanel.add(jpanpel02);
			        jf.add(jpanel);
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
				System.out.println("�����뻻һ�Ű�ť�����¼�");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("����Ƴ���һ�Ű�ť�����¼�");
			}
        	
        });
        //��¼��ť�¼�����������
        btn1.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����ɵ����¼�");
				if(e.getButton()==e.BUTTON1){
					System.out.println("�������¼�");
					if(jt1.getText().equals("�����") && jt2.getText().equals("zzh12345")){
						//ģ̬�Ի���
						JOptionPane.showMessageDialog(new JFrame(),"��¼�ɹ���");
						//��ת��¼����
						//Cardlayout1 cardlayout1=new Cardlayout1();
						Example07 example = new Example07();
						example.init();
						//ע����ǰҳ��
						jf.dispose();
					}
					else if(jt1.getText().equals("") && jt2.getText().equals("zzh12345")){
						JOptionPane.showMessageDialog(new JFrame(),"�˺Ų���Ϊ�գ�");
					}
					else if(jt1.getText().equals("�����") && jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"���벻��Ϊ�գ�");
					}
					else if(jt1.getText().equals("") && jt2.getText().equals("")){
						JOptionPane.showMessageDialog(new JFrame(),"�˺ź����벻��Ϊ�գ�");
					}
					else{
						JOptionPane.showMessageDialog(new JFrame(),"��¼ʧ�ܣ������������˺ţ����룡");
					}
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
				System.out.println("�������¼��ť�����¼�");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("����Ƴ���¼��ť�����¼�");
			}
        	
        });
        //�˳�ϵͳ��ť�¼�����������
        btn2.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����ɵ����¼�");
				if(e.getButton()==e.BUTTON1){
					System.out.println("�������¼�");
					System.out.println("�������ر��˴��ڣ���");
					System.exit(0);
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
				System.out.println("�������˳�ϵͳ��ť�����¼�");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("����Ƴ��˳�ϵͳ��ť�����¼�");
			}
        	
        });
        //������ť�¼�����������
        btn3.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����ɵ����¼�");
				if(e.getButton()==e.BUTTON1){
					System.out.println("�������¼�");
					Registered registered= new Registered();
					registered.Registered();
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
				System.out.println("�����뿪����ť�����¼�");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("����Ƴ�������ť�����¼�");
			}
        	
        });
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	}
}
public class Example03{
	public static void main(String[] args) {
        new Example().init();
    }

}