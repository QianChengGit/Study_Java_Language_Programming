package gui1;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
class Example07 extends JFrame implements ActionListener{
	JFrame jf1=new JFrame("ѧ����Ϣ���");
	JScrollPane scrollPane=new JScrollPane();
	JScrollPane scrollPane01=new JScrollPane();
	JPanel jp=new JPanel();
	Icon ic1=new ImageIcon("C:\\Users\\Administrator\\Desktop\\ps��ҵ\\JAVA���\\����-1.jpg");
	JButton button1=new JButton(ic1);
	JTable table;
	Object[] columnTitle={"����","����","�Ա�"};
	Object[][] tableDate = {
		new Object[] {"������",29,"Ů"},
		new Object[] {"�ո�����",56,"��"},
		new Object[] {"���",35,"��"},
		new Object[] {"Ū��",18,"Ů"},
		new Object[] {"�Ÿ�",29,"��"},
		new Object[] {"��ͷ",20,"��"},
		new Object[] {"Tom",15,"��"},
		new Object[] {"Home",29,"��"},
		new Object[] {"Air",17,"Ů"},
		new Object[] {"Sking",28,"��"},
		new Object[] {"����",26,"��"},
		new Object[] {"�����",30,"��"},
	};
	public void init(){
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table=new JTable(tableDate,columnTitle);
		jp.add(button1);
		scrollPane.setViewportView(table);
		scrollPane01.setViewportView(jp);
		jf1.add(scrollPane,BorderLayout.CENTER);
		jf1.add(scrollPane01,BorderLayout.SOUTH);
		jf1.pack();
		jf1.setBounds(460, 260, 1000, 600);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setVisible(true);
		button1.addActionListener(this);
		button1.addMouseListener(new MouseListener(){
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
					jf1.dispose();
					
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
	}
	public static void main(String[] args) {
		new Example07().init();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
