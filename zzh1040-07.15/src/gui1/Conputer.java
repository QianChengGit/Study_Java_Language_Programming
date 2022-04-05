package gui1;


	import java.awt.*; 
	import javax.swing.*; 
	public class Conputer extends JFrame { 
	protected Container con = getContentPane();// 指向内容面板 
	protected JMenuBar a = new JMenuBar();// 菜单条 
	protected JMenu a1 = new JMenu("编辑(E)");// 菜单1 
	protected JMenu a2 = new JMenu("查看(V)");// 菜单2 
	protected JMenu a3 = new JMenu("帮助(H)");// 菜单3 
	protected JMenuItem a11 = new JMenuItem("复制(C)", 'C');// 菜单1的菜单项 
	protected JMenuItem a12 = new JMenuItem("粘贴(P)", 'P');// 菜单1的菜单项 
	protected JMenuItem a21 = new JMenuItem("标准型(T)", 'T');// 菜单2的菜单项 
	protected JMenuItem a22 = new JMenuItem("科学型(S)", 'S');// 菜单2的菜单项 
	protected JMenuItem a31 = new JMenuItem("帮助主题(H)", 'H');// 菜单3的菜单项 

	protected JTextField jtf = new JTextField(30);// 文本框 
	protected JButton[] jb = new JButton[27]; 
	protected String[] arr = { "Backspace", "CE", "C", "MC", "7", "8", "9", "/", "sqrt", 
	"MR", "4", "5", "6", "*", "%", "MS", "1", "2", "3", "-", "1/x", 
	"M+", "0", "+/-", ".", "+", "=" }; 

	protected JPanel jp = new JPanel();// 主面板 
	protected JPanel m = new JPanel();// 次面板 
	protected JPanel m1 = new JPanel();// 次次面板 
	protected JPanel m2 = new JPanel();// 次次面板 
	protected JPanel m3 = new JPanel();// 次次面板 
	protected JPanel m4 = new JPanel();// 次次面板 
	protected JPanel m5 = new JPanel();// 次次面板 
	protected JPanel m6 = new JPanel();// 次次面板 

	protected GridLayout glo = new GridLayout(6, 1, 3, 3);// 主网格布局 
	protected GridLayout glo1 = new GridLayout(1, 3, 3, 3);// 次网格布局 
	protected GridLayout glo2 = new GridLayout(1, 6, 3, 3);// 次网格布局 

	protected Conputer(String s) { 
	super(s); 
	a1.setMnemonic('E'); 
	a1.add(a11); 
	a1.add(a12); 
	a2.setMnemonic('V'); 
	a2.add(a21); 
	a2.add(a22); 
	a3.setMnemonic('H'); 
	a3.add(a31); 
	a.add(a1); 
	a.add(a2); 
	a.add(a3); 
	this.setJMenuBar(a);// 菜单条完成 

	for (int i = 0; i < 27; i++) { 
	jb[i] = new JButton(arr[i]); 
	} 

	jp.setLayout(glo); 
	jp.add(m1); 
	m1.add(jtf); 
	jtf.setEditable(false); jtf.setText("0."); jtf.setForeground(Color.BLUE); jtf.setBackground(Color.WHITE); 
	jtf.setHorizontalAlignment(JTextField.RIGHT);//文本显示在右边 

	jp.add(m2); 
	m2.setLayout(glo1); 
	m2.add(jb[0]); 
	m2.add(jb[1]); 
	m2.add(jb[2]); 

	jp.add(m3); 
	m3.setLayout(glo2); 
	m3.add(jb[3]); 
	m3.add(jb[4]); 
	m3.add(jb[5]); 
	m3.add(jb[6]); 
	m3.add(jb[7]); 
	m3.add(jb[8]); 

	jp.add(m4); 
	m4.setLayout(glo2); 
	m4.add(jb[9]); 
	m4.add(jb[10]); 
	m4.add(jb[11]); 
	m4.add(jb[12]); 
	m4.add(jb[13]); 
	m4.add(jb[14]); 

	jp.add(m5); 
	m5.setLayout(glo2); 
	m5.add(jb[15]); 
	m5.add(jb[16]); 
	m5.add(jb[17]); 
	m5.add(jb[18]); 
	m5.add(jb[19]); 
	m5.add(jb[20]); 

	jp.add(m6); 
	m6.setLayout(glo2); 
	m6.add(jb[21]); 
	m6.add(jb[22]); 
	m6.add(jb[23]); 
	m6.add(jb[24]); 
	m6.add(jb[25]); 
	m6.add(jb[26]); 

	m.add(jp); 
	con.add(m); 

	this.setResizable(false);// 不能用鼠标拉伸窗体 
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//可以关闭窗体 
	this.setSize(380, 275); 
	this.setVisible(true); 

	} 

	protected Conputer() { 
	this("计算器"); 
	} 

	public static void main(String[] args) { 
	new Conputer("计算器"); 
	} 

	}

