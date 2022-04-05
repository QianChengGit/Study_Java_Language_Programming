package gui1;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Example05 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;// ��Ƭ���ֹ�����
	private JPanel jPanel;// ʹ�ÿ�Ƭ���ֹ����������
	private JTextField jTextField;// �������������תҳ��
	public Example05() {
		setTitle("���ֹ�����֮CardLayout");
		setSize(1053, 670);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

/* ����������ť����ӵ�����ײ���Ĭ�ϴ��岼�ֲ���BorderLayout */
		JPanel jp = new JPanel();// ���Ĭ�ϲ���ʹ��FlowLayout

		JButton up = new JButton("��һ��");
		JButton next = new JButton("��һ��");
		jTextField = new JTextField("2");
		JButton go = new JButton("go");

		jp.add(up);
		jp.add(next);
		jp.add(jTextField);
		jp.add(go);
// ע�ᰴť�����¼�

		up.addActionListener(this);
		next.addActionListener(this);
		go.addActionListener(this);
		this.add(jp, BorderLayout.SOUTH);

/* ����ʹ��CardLayout���ֹ����������� */
		cardLayout = new CardLayout();
		jPanel = new JPanel(cardLayout);

/* ���������Ӽ���ͼƬ */

// ��ͼƬ���Ƶ������ 
		JPanel images = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(
						Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\ps��ҵ\\�ز�\\4-2����ͼƬ��ɫ.jpg"), 5, 5, this);

			}

		};
//��ͼƬ�����ӵ�ʹ����cardLayout���������

		jPanel.add("sprite", images);

		JPanel img = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(
						Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\ps��ҵ\\�ز�\\17-1���ࣺ���츺ƬЧ��.jpg"), 5, 5, this);
			}
//src/images/Freedom1.gif
		};

		jPanel.add("Freedom1", img);

		JPanel im = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(
						Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\ps��ҵ\\�ز�\\1-1���ȶԱȶȣ�͸���Ļ���Ч��.jpg"), 5, 5, this);
			}

		};
		jPanel.add("sprite1", im);

// ��ʹ����CardLayout�������ӵ���������ʾ
		this.add(jPanel, BorderLayout.CENTER);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("��һ��".equals(cmd)) {
			cardLayout.next(jPanel); // �л���һ��ѡ�
			System.out.println("��һ��");
		} else if ("��һ��".equals(cmd)) {
			cardLayout.previous(jPanel);// �л���һ��ѡ�
			System.out.println("��һ��");
		} else if ("go".equals(cmd)) {
			System.out.println("go");
			cardLayout.show(jPanel, "Freedom" + jTextField.getText());//�����Ҫ�������������Ƶ�ͼƬ�����������ת��ͼƬ���ֲ�һ���Ļ�����Ϳ���ȥ��ͼƬ�����ָĳ����Ƶġ�
		}

	}

	public static void main(String[] args) {
		new Example05();
	}
}
