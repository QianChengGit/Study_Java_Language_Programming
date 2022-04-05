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
	private CardLayout cardLayout;// 卡片布局管理器
	private JPanel jPanel;// 使用卡片布局管理器的面板
	private JTextField jTextField;// 用于你输入的跳转页面
	public Example05() {
		setTitle("布局管理器之CardLayout");
		setSize(1053, 670);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

/* 创建两个按钮，添加到窗体底部，默认窗体布局采用BorderLayout */
		JPanel jp = new JPanel();// 面板默认布局使用FlowLayout

		JButton up = new JButton("上一张");
		JButton next = new JButton("下一张");
		jTextField = new JTextField("2");
		JButton go = new JButton("go");

		jp.add(up);
		jp.add(next);
		jp.add(jTextField);
		jp.add(go);
// 注册按钮监听事件

		up.addActionListener(this);
		next.addActionListener(this);
		go.addActionListener(this);
		this.add(jp, BorderLayout.SOUTH);

/* 创建使用CardLayout布局管理器的容器 */
		cardLayout = new CardLayout();
		jPanel = new JPanel(cardLayout);

/* 向面板中添加几张图片 */

// 将图片绘制到面板中 
		JPanel images = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(
						Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\ps作业\\素材\\4-2修正图片颜色.jpg"), 5, 5, this);

			}

		};
//将图片面板添加到使用了cardLayout容器面板中

		jPanel.add("sprite", images);

		JPanel img = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(
						Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\ps作业\\素材\\17-1反相：打造负片效果.jpg"), 5, 5, this);
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
						Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\ps作业\\素材\\1-1亮度对比度：透亮的花瓣效果.jpg"), 5, 5, this);
			}

		};
		jPanel.add("sprite1", im);

// 将使用了CardLayout的面板添加到窗体中显示
		this.add(jPanel, BorderLayout.CENTER);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("下一张".equals(cmd)) {
			cardLayout.next(jPanel); // 切换下一个选项卡
			System.out.println("下一张");
		} else if ("上一张".equals(cmd)) {
			cardLayout.previous(jPanel);// 切换上一个选项卡
			System.out.println("上一张");
		} else if ("go".equals(cmd)) {
			System.out.println("go");
			cardLayout.show(jPanel, "Freedom" + jTextField.getText());//这个主要是用于名字相似的图片，如果你想跳转的图片名字不一样的话，你就可以去把图片的名字改成相似的。
		}

	}

	public static void main(String[] args) {
		new Example05();
	}
}
