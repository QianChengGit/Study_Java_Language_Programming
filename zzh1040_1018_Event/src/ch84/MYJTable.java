package ch84;
import javax.swing.*;
public class MYJTable {
	JFrame jf1=new JFrame("简单表格");
	JTable table;
	Object[] columnTitle={"姓名","年龄","性别"};
	Object[][] tableDate = {
		new Object[] {"李清照",29,"女"},
		new Object[] {"苏格拉底",56,"男"},
		new Object[] {"李白",35,"男"},
		new Object[] {"弄玉",18,"女"},
		new Object[] {"杜甫",29,"男"},
		new Object[] {"虎头",20,"男"},
		
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
