package youxi;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class BlockGrid16 {
	
	/*���з�����������*/
	public static final int[][] MODELS = {
		{0x0063,0x0264,0x0063,0x0264}, //Z
		{0x006c,0x0462,0x006c,0x0462}, //��Z
		{0x0446,0x002e,0x0622,0x00e8}, //L
		{0x0226,0x0047,0x0644,0x0071}, //��L
		{0x0027,0x0464,0x0072,0x0131}, //T
		{0x0066,0x0066,0x0066,0x0066}, //��
		{0x000f,0x4444,0x000f,0x4444}, //l
	};
	/*�����������*/
	public static final Random random = new Random();
	/*ÿһά��С*/
	public static final int dimension = 4;
	/*��������*/
	public int type;
	/*����״̬*/
	public int status;
	/*�����ٶȵȼ�*/
	public int level;
	/*����ģ��*/
	public boolean[][] model;
	/*��ǰ���ڻ���*/
	public Canvas canvas;
	/*����ģ�����Ͻ��ڻ�������ϵ�е���λ��*/
	public int row;
	/*����ģ�����Ͻ��ڻ�������ϵ�е���λ��*/
	public int column;
	/*��ʱ��*/
	public Timer t;
	/*���췽��*/
	public BlockGrid16(Canvas canvas,int level) {
		this.type = random.nextInt(MODELS.length);
		this.status = random.nextInt(MODELS[0].length);
		this.level = level;
		this.canvas = canvas;
		this.row = -999;
		this.column = 4;
		buildModel(MODELS[type][status]);
	}
	/*���������췽��*/
	public BlockGrid16(int type,int status,int level,Canvas canvas,int row,int column) {
		this(canvas,level);
		this.type = type;
		this.status = status;
		this.row = row;
		this.column = column;
	}
	
	public void init(){
		row = -3;
		column = 4;
		/*�ж���Ϸ�Ƿ����*/
		if (isTouchBottom(row, column)) {
			canvas.isEnd = true;
		}
	}
	/*���·���ģ���ڻ����ϵ�λ��*/
	public void update(){ 
		for (int i=0;i<dimension;i++) {
			for (int j=0;j<dimension;j++) {
				if ( canvas.isValidPlace(row + i, column + j) && model[i][j]) {
					canvas.map[row+i][column+j] = true;
				}
			}
		}
	}
	
	/*�����ƶ�*/
	public void moveTo(int r,int c) { 
		/* �ж��ƶ��Ŀ����� */
		if (!moveable(r,c))
			return;
		
		/*��������ģ���ƶ�ǰ��λ��*/
		erase();
		/*��������ģ��λ��*/
		row = r;
		column = c;
		/*����*/
		update();
		
		/*����Ѿ�����ײ�����ʱ1000-level*50 ���������ǰ����ģ��*/
		if (isTouchBottom(row,column)) {
			canvas.haveFullLine();
			t = new Timer();
			t.schedule(new TimerTask(){
				public void run() {
					if(t != null){
						canvas.currBlock = canvas.nextBlock;
						canvas.currBlock.init();
						canvas.nextBlock = new BlockGrid16(canvas,level);
						t = null;
						canvas.repaint();
					}
				}
			}, 1000-level*50);
		}
	}
	
	/*�����ƶ�*/
	public void moveLeft() {
		moveTo(row,column-1);
	}
	
	/*�����ƶ�*/
	public void moveRight() {
		moveTo(row, column+1);
	}
	
	/*�����ƶ�*/
	public void moveDown() {
		if (t != null && isTouchBottom(row,column)) {
			canvas.haveFullLine();
			canvas.currBlock = canvas.nextBlock;
			canvas.currBlock.init();
			canvas.nextBlock = new BlockGrid16(canvas,level);
			canvas.repaint();
			t = null;
		}
		moveTo(row+1, column);
	}
	
	/*�ƶ����ײ�*/
	public void moveBottom() {
		for (int i=-3;i<Canvas.ROW;i++) {
			if (moveable(i, column) && isTouchBottom(i, column)) {
				t = new Timer();
				moveTo(i, column);
				canvas.haveFullLine();
				canvas.currBlock = canvas.nextBlock;
				canvas.currBlock.init();
				canvas.nextBlock = new BlockGrid16(canvas,level);
				canvas.repaint();
				t = null;
				break;
			}
		}
	}
	/*�Ƿ�����ƶ���ָ��λ��*/
	public boolean moveable(int row,int column) {
		/*������ǰҪ�ƶ�����ģ����ռλ�ã�����Ӱ���ж�*/
		erase();
		
		/*�жϷ���ģ��ÿһ����Ԫ��Ҫ�ƶ�����λ���Ƿ��Ѿ���ռ��*/
		for (int i=0;i<dimension;i++) {
			for (int j=0;j<dimension;j++) {
				/*ֻ���жϷ���ģ���б�ռ�еĵ�Ԫ��*/
				if (model[i][j]) {
					/*�жϺϷ���*/
					if (i + row >= Canvas.ROW || j + column <0 || j + column >= Canvas.COLUMN){
						update();
						return false;
					}
					/*�жϽ�Ҫ�ƶ���λ�����Ƿ��Ѿ���ռ��*/
					if (canvas.isValidPlace(i+row, j+column) && canvas.map[i+row][j+column]) {
						update();
						return false;
					}
				}
			}
		}
		/*�ָ�����ģ��*/
		update();
		return true;
	}
	
	/*�жϷ���ģ���Ƿ񵽵ײ�*/
	public boolean isTouchBottom(int row,int column) {
		erase();
		for (int i=0;i<dimension;i++) {
			for (int j=0;j<dimension;j++) {
				if (model[i][j]) {
					int nextR = i + 1 + row;
					int nextC = j + column;
					/*���Ѿ����ײ�*/
					if (nextR == Canvas.ROW) {
						update();
						return true;
					}
					/*�жϵ�ǰ��Ԫ���·��ĵ�Ԫ���Ƿ��Ѿ���ռ��*/
					if (canvas.isValidPlace(nextR, nextC)) {
						if (canvas.map[nextR][nextC]) {
							update();
							return true;
						}
					}
				}
			}
		}
		update();
		return false;
	}
	
	/*����*/
	public void rorate() {
		int newStatus = (status + 1)%MODELS[type].length;
		if (!rorateable(MODELS[type][newStatus])) {
			return;
		}else {
			status ++;
		}
		/*����ԭ��*/
		erase();
		/*��ת*/
		buildModel(MODELS[type][newStatus]);
		/*����*/
		update();
	}
	
	//TODO ����Ƿ���Ա���
	public boolean rorateable(int keyCode) {
		erase();
		
		/*��ʼ����ʱģ��*/
		boolean[][] tempModel = new boolean[dimension][dimension];
		int bitKey = 0x8000;
		for (int i = 0;i<dimension;i++) {
			for (int j = 0;j<dimension;j++) {
				tempModel[i][j] = !((bitKey & keyCode) == 0);
				bitKey = bitKey >> 1;
			}
		}
		
		for (int i=0;i<dimension;i++) {
			for (int j=0;j<dimension;j++) {
				if (tempModel[i][j]) {
					if ( row + i >= Canvas.ROW || column+j < 0 || column +j >=Canvas.COLUMN ) {
						update();
						return false;
					}
				}
			}
		}
		
		update();
		return true;
		
	}
	
	
	/*��������*/ 
	public void erase() {
		for (int i=0;i<dimension;i++) {
			for (int j=0;j<dimension;j++) {
				if ( canvas.isValidPlace(row + i, column + j) && model[i][j]) {
					canvas.map[row+i][column+j] = false;
				}
			}
		}
	}
	/*��������ģ��*/
	public void buildModel(int modelCode) {
		int bitKey = 0x8000;
		model = new boolean[dimension][dimension];
		for (int i = 0;i<dimension;i++) {
			for (int j = 0;j<dimension;j++) {
				model[i][j] = !((bitKey & modelCode) == 0);
				bitKey = bitKey >> 1;
			}
		}
	}
}