package youxi;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Canvas extends JPanel implements KeyListener{
	private static final long serialVersionUID = -1354251777507926593L;
	
	/*游戏参数*/
	public static final int COLUMN = 10;
	public static final int ROW = 18;
	public static final int SIZE = 24;
	public static final Color backgroundColor = new Color(0xf1,0xf1,0xf1);
	public static final Color blockColor = Color.YELLOW;
	public static final Color cblockColor = Color.ORANGE;
	public static final int[] PADDING = {10,20,10,20};
	public static final int WIDTH = PADDING[1] + PADDING[3] + SIZE*COLUMN;
	public static final int HEIGHT= PADDING[0] + PADDING[2] + SIZE*ROW;
	public final int borderWidth = 1;
	public int oneLineScore = 100;
	
	public int level; //游戏当前等级
	public int score; //游戏当前分数
	
	/*游戏对象*/
	public BlockGrid16 currBlock; //当前操作的方块网格
	public BlockGrid16 nextBlock; //下一个将要操作的方块网格
	public boolean[][] map; //游戏图  18X10 网格
	public Timer downTimer; //下落计数器
	
	/*游戏标志*/
	public boolean isEnd = true; /*游戏是否结束*/
	public boolean isPause = false; /*游戏是否暂停*/

	/*主窗口对象*/
	public GameApplication app;
	
	/*线程*/
	public ChangeBlockThread cbThread; /*切换方块线程*/
	
	public Canvas(GameApplication app) {
		this.app = app;
		setPreferredSize(null);         /*设置面板大小*/
		map = new boolean[ROW][COLUMN]; /*初始化地图数组*/
		setBackground(backgroundColor); /*设置背景颜色*/
		addKeyListener(this); /*注册键盘监听*/
		cbThread = new ChangeBlockThread();
	}
	
	public void gameInit(int level) { 
		/*标志初始化*/
		isEnd = false;
		isPause = false;
		/*地图初始化*/
		map = new boolean[ROW][COLUMN];
		/*当前操作方块初始化*/
		currBlock = new BlockGrid16(this,level);
		currBlock.init();
		/*下一个操作方块初始化*/
		nextBlock = new BlockGrid16(this,level);
		/*等级*/
		this.level = level;
		/*分数*/
		this.score = 0;
		/*重绘*/
		repaint();
	}
	
	/*判断指定位置是否为合法位置*/
	public boolean isValidPlace(int row,int column) {
		if ( row < 0 || row >= ROW || column < 0 || column >= COLUMN)
			return false;
		return true;
	}
	
	/*检查是否底部为满行*/
	public void haveFullLine() {
		for (int i=0;i<ROW;i++) {
			boolean isFullLine = true;
			for (int j=0;j<COLUMN;j++) {
				if (!map[i][j]) {
					isFullLine = false;
					break;
				}
			}
			if (isFullLine) {
				clearLine(i);
				i -- ;
			}
		}
	}
	/*删除指定行*/
	public void clearLine(int row) {
		for (int i=row;i>0;i--) {
			for (int j=0;j<COLUMN;j++) {
				map[i][j] = map[i-1][j];
			}
		}
		score += oneLineScore;
	}
	
	@Override
	public void setPreferredSize(Dimension arg0) {
		super.setPreferredSize(new Dimension(WIDTH,HEIGHT));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		/*画游戏边界*/
		g.drawLine(PADDING[3], PADDING[0], PADDING[3]+SIZE*COLUMN, PADDING[0]);
		g.drawLine(PADDING[3], PADDING[0] + SIZE*ROW, PADDING[3]+SIZE*COLUMN, PADDING[0]+ SIZE*ROW);
		g.drawLine(PADDING[3], PADDING[0], PADDING[3], PADDING[0] + ROW*SIZE);
		g.drawLine(PADDING[3]+SIZE*COLUMN, PADDING[0], PADDING[3]+SIZE*COLUMN, PADDING[0] + ROW*SIZE);
		
		/*更新当前操作方块位置*/
		if(currBlock != null)
			currBlock.update();
		
		/*画方块*/
		if(map != null)
			for ( int i=0;i<ROW;i++) {
				for ( int j=0;j<COLUMN;j++){
					if (map[i][j]) { 
						/*画矩形*/
						g.drawRect(PADDING[3] + j*SIZE, PADDING[0] + i*SIZE, SIZE, SIZE);
						/*选择颜色变填充矩形*/
						Color oldColor = g.getColor();
						g.setColor(Color.CYAN);
						g.fillRect(PADDING[3] + j*SIZE + borderWidth, PADDING[0] + i*SIZE + borderWidth, SIZE -borderWidth , SIZE -borderWidth);
						/*还原颜色*/
						g.setColor(oldColor);
					}
				}
			}
	}

	/*键盘监听*/
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if ( (key >=37 && key <= 40 || key == 32) && !isEnd) {
			if (key == 37) {
				currBlock.moveLeft();
			} else if (key == 39) {
				currBlock.moveRight();
			} else if (key == 40) {
				currBlock.moveDown();
			} else if (key == 32) {
				currBlock.moveBottom();
			} else if (key == 38) {
				currBlock.rorate();
			}
			System.out.println(score);
			repaint();
		}else if ( key == 80) { //P
			
		}else if ( key == 78) { //N
			if (downTimer != null) {
				downTimer.cancel();
				downTimer = null;
			}
			if (isEnd != true)
				if( JOptionPane.showConfirmDialog(this, "您确定要重新开始吗？", "新的游戏", 
					JOptionPane.YES_NO_OPTION) == 0) {	
					gameInit(app.gameLevel);
					downTimer = new Timer();
					downTimer.schedule(new TimerTask(){
						public void run() {
							currBlock.moveDown();
							repaint();
						}
					}, 0, 1000-level*50);
					return;
				}
			gameInit(app.gameLevel);
			downTimer = new Timer();
			downTimer.schedule(new TimerTask(){
				public void run() {
					currBlock.moveDown();
					repaint();
				}
			}, 0, 1000-level*50);
		}else if ( key == 82) { //R
			
		}else if ( key == 79) { //O
			
		}
		
		//上:38
		//下:40
		//左:37
		//右:39
		//P:80
		//N:78
		//R:82
		//O:79
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	/*方块下落控制的线程*/
	class ChangeBlockThread extends Thread{
		
		public long delay = 1000;
		
		@Override
		public void run() {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}