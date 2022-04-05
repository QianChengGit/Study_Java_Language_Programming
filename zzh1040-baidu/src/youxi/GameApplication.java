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
	/*工具栏*/    
	private JToolBar toolbar;   
	
	/*构造方法*/
	public GameApplication() {
		init();
	}
	
	/*界面初始化函数*/
	private void init() {
		setTitle("俄罗斯方块                     by:luiyikeke");
		add(createOrGetCanvas());
		add(createOrGetToolBar(),BorderLayout.NORTH);
		pack();
		setLocationRelativeTo(null);
		canvas.requestFocus();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*创建画布面板,位于分割面板的左部*/
	private Canvas createOrGetCanvas(){
		if(canvas == null){
			canvas = new Canvas(this);
		}
		return canvas;
	}
	
	/*创建工具栏*/
	private JToolBar createOrGetToolBar() {
		if ( toolbar == null) {
			toolbar = new JToolBar();
			toolbar.add(createButtonWithAction("重新开始(N)"));
			toolbar.add(createButtonWithAction("暂停(P)"));
			toolbar.add(createButtonWithAction("排行榜(R)"));
			toolbar.add(createButtonWithAction("设置(O)"));
		}
		return toolbar;
	}
	
	/*创建按钮，并且带有事件监听*/
	private JButton createButtonWithAction(String btnString) { 
		JButton btn = new JButton(btnString);
		btn.addActionListener(this);
		return btn;
	}
	
	// ------------------------------------
	// 事件监听
	// ------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if("重新开始(N)".equals(command)) {
			canvas.gameInit(gameLevel);
		}else if("暂停(P)".equals(command)) {
			
		}else if("排行榜(R)".equals(command)) {
			
		}else if("设置(O)".equals(command)) {
			
		}
		canvas.requestFocus();
	}
	
	public static void main(String[] args) {
		try {
			// 设置程序将采用的界面风格
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