package gui1;


	import java.awt.*; 
	import javax.swing.*; 
	public class Conputer extends JFrame { 
	protected Container con = getContentPane();// ָ��������� 
	protected JMenuBar a = new JMenuBar();// �˵��� 
	protected JMenu a1 = new JMenu("�༭(E)");// �˵�1 
	protected JMenu a2 = new JMenu("�鿴(V)");// �˵�2 
	protected JMenu a3 = new JMenu("����(H)");// �˵�3 
	protected JMenuItem a11 = new JMenuItem("����(C)", 'C');// �˵�1�Ĳ˵��� 
	protected JMenuItem a12 = new JMenuItem("ճ��(P)", 'P');// �˵�1�Ĳ˵��� 
	protected JMenuItem a21 = new JMenuItem("��׼��(T)", 'T');// �˵�2�Ĳ˵��� 
	protected JMenuItem a22 = new JMenuItem("��ѧ��(S)", 'S');// �˵�2�Ĳ˵��� 
	protected JMenuItem a31 = new JMenuItem("��������(H)", 'H');// �˵�3�Ĳ˵��� 

	protected JTextField jtf = new JTextField(30);// �ı��� 
	protected JButton[] jb = new JButton[27]; 
	protected String[] arr = { "Backspace", "CE", "C", "MC", "7", "8", "9", "/", "sqrt", 
	"MR", "4", "5", "6", "*", "%", "MS", "1", "2", "3", "-", "1/x", 
	"M+", "0", "+/-", ".", "+", "=" }; 

	protected JPanel jp = new JPanel();// ����� 
	protected JPanel m = new JPanel();// ����� 
	protected JPanel m1 = new JPanel();// �δ���� 
	protected JPanel m2 = new JPanel();// �δ���� 
	protected JPanel m3 = new JPanel();// �δ���� 
	protected JPanel m4 = new JPanel();// �δ���� 
	protected JPanel m5 = new JPanel();// �δ���� 
	protected JPanel m6 = new JPanel();// �δ���� 

	protected GridLayout glo = new GridLayout(6, 1, 3, 3);// �����񲼾� 
	protected GridLayout glo1 = new GridLayout(1, 3, 3, 3);// �����񲼾� 
	protected GridLayout glo2 = new GridLayout(1, 6, 3, 3);// �����񲼾� 

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
	this.setJMenuBar(a);// �˵������ 

	for (int i = 0; i < 27; i++) { 
	jb[i] = new JButton(arr[i]); 
	} 

	jp.setLayout(glo); 
	jp.add(m1); 
	m1.add(jtf); 
	jtf.setEditable(false); jtf.setText("0."); jtf.setForeground(Color.BLUE); jtf.setBackground(Color.WHITE); 
	jtf.setHorizontalAlignment(JTextField.RIGHT);//�ı���ʾ���ұ� 

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

	this.setResizable(false);// ������������촰�� 
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���Թرմ��� 
	this.setSize(380, 275); 
	this.setVisible(true); 

	} 

	protected Conputer() { 
	this("������"); 
	} 

	public static void main(String[] args) { 
	new Conputer("������"); 
	} 

	}

