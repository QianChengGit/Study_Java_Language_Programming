package ch84;
import javax.swing.*;
public class MYJTable {
	JFrame jf1=new JFrame("�򵥱��");
	JTable table;
	Object[] columnTitle={"����","����","�Ա�"};
	Object[][] tableDate = {
		new Object[] {"������",29,"Ů"},
		new Object[] {"�ո�����",56,"��"},
		new Object[] {"���",35,"��"},
		new Object[] {"Ū��",18,"Ů"},
		new Object[] {"�Ÿ�",29,"��"},
		new Object[] {"��ͷ",20,"��"},
		
	};
	public void init(){
		
		table=new JTable(tableDate,columnTitle);
		
		jf1.add(new JScrollPane(table));
		jf1.pack();
		jf1.setBounds(460, 260, 500, 400);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setVisible(true);
		
	}
	public static void main(String[] args) {
		new MYJTable().init();
	}

}
