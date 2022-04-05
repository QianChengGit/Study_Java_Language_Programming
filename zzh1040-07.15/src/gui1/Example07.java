package gui1;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
class Example07 extends JFrame implements ActionListener{
	JFrame jf1=new JFrame("学生信息表格");
	JScrollPane scrollPane=new JScrollPane();
	JScrollPane scrollPane01=new JScrollPane();
	JPanel jp=new JPanel();
	Icon ic1=new ImageIcon("C:\\Users\\Administrator\\Desktop\\ps作业\\JAVA组件\\返回-1.jpg");
	JButton button1=new JButton(ic1);
	JTable table;
	Object[] columnTitle={"姓名","年龄","性别"};
	Object[][] tableDate = {
		new Object[] {"李清照",29,"女"},
		new Object[] {"苏格拉底",56,"男"},
		new Object[] {"李白",35,"男"},
		new Object[] {"弄玉",18,"女"},
		new Object[] {"杜甫",29,"男"},
		new Object[] {"虎头",20,"男"},
		new Object[] {"Tom",15,"男"},
		new Object[] {"Home",29,"男"},
		new Object[] {"Air",17,"女"},
		new Object[] {"Sking",28,"男"},
		new Object[] {"苏轼",26,"男"},
		new Object[] {"诸葛亮",30,"男"},
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
				System.out.println("鼠标完成单击事件");
				if(e.getButton()==e.BUTTON1){
					System.out.println("鼠标左击事件");
					//跳转首界面
					Example example=new Example();
					example.init();
					//注销当前页面
					jf1.dispose();
					
				}
				if(e.getButton()==e.BUTTON2){
					System.out.println("鼠标中键单击事件");
				}
				if(e.getButton() == e.BUTTON3){
					System.out.println("鼠标右击事件");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标按下事件");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标放开事件");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标进入返回按钮区域事件");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标移出返回按钮区域事件");
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
