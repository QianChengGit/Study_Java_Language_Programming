package youxi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class GameApplication extends JFrame implements ActionListener{
	private static final long serialVersionUID = -1653174441012031192L;

	   private Canvas canvas;
	
	public int gameLevel = 10;
	/*������*/    
	private JToolBar toolbar;   
	
	/*���췽��*/
	public GameApplication() {
		init();
	}
	
	/*�����ʼ������*/
	private void init() {
		setTitle("����˹����                     by:luiyikeke");
		add(createOrGetCanvas());
		add(createOrGetToolBar(),BorderLayout.NORTH);
		pack();
		setLocationRelativeTo(null);
		canvas.requestFocus();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*�����������,λ�ڷָ�������*/
	private Canvas createOrGetCanvas(){
		if(canvas == null){
			canvas = new Canvas(this);
		}
		return canvas;
	}
	
	/*����������*/
	private JToolBar createOrGetToolBar() {
		if ( toolbar == null) {
			toolbar = new JToolBar();
			toolbar.add(createButtonWithAction("���¿�ʼ(N)"));
			toolbar.add(createButtonWithAction("��ͣ(P)"));
			toolbar.add(createButtonWithAction("���а�(R)"));
			toolbar.add(createButtonWithAction("����(O)"));
		}
		return toolbar;
	}
	
	/*������ť�����Ҵ����¼�����*/
	private JButton createButtonWithAction(String btnString) { 
		JButton btn = new JButton(btnString);
		btn.addActionListener(this);
		return btn;
	}
	
	// ------------------------------------
	// �¼�����
	// ------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if("���¿�ʼ(N)".equals(command)) {
			canvas.gameInit(gameLevel);
		}else if("��ͣ(P)".equals(command)) {
			
		}else if("���а�(R)".equals(command)) {
			
		}else if("����(O)".equals(command)) {
			
		}
		canvas.requestFocus();
	}
	
	public static void main(String[] args) {
		try {
			// ���ó��򽫲��õĽ�����
			UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceOfficeSilver2007LookAndFeel");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new GameApplication().setVisible(true);
	}

	
}