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
	
	/*��Ϸ����*/
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
	
	public int level; //��Ϸ��ǰ�ȼ�
	public int score; //��Ϸ��ǰ����
	
	/*��Ϸ����*/
	public BlockGrid16 currBlock; //��ǰ�����ķ�������
	public BlockGrid16 nextBlock; //��һ����Ҫ�����ķ�������
	public boolean[][] map; //��Ϸͼ  18X10 ����
	public Timer downTimer; //���������
	
	/*��Ϸ��־*/
	public boolean isEnd = true; /*��Ϸ�Ƿ����*/
	public boolean isPause = false; /*��Ϸ�Ƿ���ͣ*/

	/*�����ڶ���*/
	public GameApplication app;
	
	/*�߳�*/
	public ChangeBlockThread cbThread; /*�л������߳�*/
	
	public Canvas(GameApplication app) {
		this.app = app;
		setPreferredSize(null);         /*��������С*/
		map = new boolean[ROW][COLUMN]; /*��ʼ����ͼ����*/
		setBackground(backgroundColor); /*���ñ�����ɫ*/
		addKeyListener(this); /*ע����̼���*/
		cbThread = new ChangeBlockThread();
	}
	
	public void gameInit(int level) { 
		/*��־��ʼ��*/
		isEnd = false;
		isPause = false;
		/*��ͼ��ʼ��*/
		map = new boolean[ROW][COLUMN];
		/*��ǰ���������ʼ��*/
		currBlock = new BlockGrid16(this,level);
		currBlock.init();
		/*��һ�����������ʼ��*/
		nextBlock = new BlockGrid16(this,level);
		/*�ȼ�*/
		this.level = level;
		/*����*/
		this.score = 0;
		/*�ػ�*/
		repaint();
	}
	
	/*�ж�ָ��λ���Ƿ�Ϊ�Ϸ�λ��*/
	public boolean isValidPlace(int row,int column) {
		if ( row < 0 || row >= ROW || column < 0 || column >= COLUMN)
			return false;
		return true;
	}
	
	/*����Ƿ�ײ�Ϊ����*/
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
	/*ɾ��ָ����*/
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
		/*����Ϸ�߽�*/
		g.drawLine(PADDING[3], PADDING[0], PADDING[3]+SIZE*COLUMN, PADDING[0]);
		g.drawLine(PADDING[3], PADDING[0] + SIZE*ROW, PADDING[3]+SIZE*COLUMN, PADDING[0]+ SIZE*ROW);
		g.drawLine(PADDING[3], PADDING[0], PADDING[3], PADDING[0] + ROW*SIZE);
		g.drawLine(PADDING[3]+SIZE*COLUMN, PADDING[0], PADDING[3]+SIZE*COLUMN, PADDING[0] + ROW*SIZE);
		
		/*���µ�ǰ��������λ��*/
		if(currBlock != null)
			currBlock.update();
		
		/*������*/
		if(map != null)
			for ( int i=0;i<ROW;i++) {
				for ( int j=0;j<COLUMN;j++){
					if (map[i][j]) { 
						/*������*/
						g.drawRect(PADDING[3] + j*SIZE, PADDING[0] + i*SIZE, SIZE, SIZE);
						/*ѡ����ɫ��������*/
						Color oldColor = g.getColor();
						g.setColor(Color.CYAN);
						g.fillRect(PADDING[3] + j*SIZE + borderWidth, PADDING[0] + i*SIZE + borderWidth, SIZE -borderWidth , SIZE -borderWidth);
						/*��ԭ��ɫ*/
						g.setColor(oldColor);
					}
				}
			}
	}

	/*���̼���*/
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
				if( JOptionPane.showConfirmDialog(this, "��ȷ��Ҫ���¿�ʼ��", "�µ���Ϸ", 
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
		
		//��:38
		//��:40
		//��:37
		//��:39
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
	
	
	/*����������Ƶ��߳�*/
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