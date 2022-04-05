package youxi;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class BlockGrid16 {
	
	/*所有方块网格类型*/
	public static final int[][] MODELS = {
		{0x0063,0x0264,0x0063,0x0264}, //Z
		{0x006c,0x0462,0x006c,0x0462}, //反Z
		{0x0446,0x002e,0x0622,0x00e8}, //L
		{0x0226,0x0047,0x0644,0x0071}, //反L
		{0x0027,0x0464,0x0072,0x0131}, //T
		{0x0066,0x0066,0x0066,0x0066}, //田
		{0x000f,0x4444,0x000f,0x4444}, //l
	};
	/*随机数生成器*/
	public static final Random random = new Random();
	/*每一维大小*/
	public static final int dimension = 4;
	/*方块类型*/
	public int type;
	/*方块状态*/
	public int status;
	/*方块速度等级*/
	public int level;
	/*网格模型*/
	public boolean[][] model;
	/*当前所在画布*/
	public Canvas canvas;
	/*网格模型左上角在画布坐标系中的行位置*/
	public int row;
	/*网格模型左上角在画布坐标系中的列位置*/
	public int column;
	/*计时器*/
	public Timer t;
	/*构造方法*/
	public BlockGrid16(Canvas canvas,int level) {
		this.type = random.nextInt(MODELS.length);
		this.status = random.nextInt(MODELS[0].length);
		this.level = level;
		this.canvas = canvas;
		this.row = -999;
		this.column = 4;
		buildModel(MODELS[type][status]);
	}
	/*带参数构造方法*/
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
		/*判断游戏是否结束*/
		if (isTouchBottom(row, column)) {
			canvas.isEnd = true;
		}
	}
	/*更新方块模型在画布上的位置*/
	public void update(){ 
		for (int i=0;i<dimension;i++) {
			for (int j=0;j<dimension;j++) {
				if ( canvas.isValidPlace(row + i, column + j) && model[i][j]) {
					canvas.map[row+i][column+j] = true;
				}
			}
		}
	}
	
	/*方块移动*/
	public void moveTo(int r,int c) { 
		/* 判断移动的可能性 */
		if (!moveable(r,c))
			return;
		
		/*擦除方块模型移动前的位置*/
		erase();
		/*调整方块模型位置*/
		row = r;
		column = c;
		/*更新*/
		update();
		
		/*如果已经到达底部，延时1000-level*50 毫秒更换当前方块模型*/
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
	
	/*向左移动*/
	public void moveLeft() {
		moveTo(row,column-1);
	}
	
	/*向右移动*/
	public void moveRight() {
		moveTo(row, column+1);
	}
	
	/*向下移动*/
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
	
	/*移动到底部*/
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
	/*是否可以移动到指定位置*/
	public boolean moveable(int row,int column) {
		/*擦除当前要移动方块模型所占位置，以免影响判断*/
		erase();
		
		/*判断方块模型每一个单元格将要移动到的位置是否已经被占有*/
		for (int i=0;i<dimension;i++) {
			for (int j=0;j<dimension;j++) {
				/*只需判断方块模型中被占有的单元格*/
				if (model[i][j]) {
					/*判断合法性*/
					if (i + row >= Canvas.ROW || j + column <0 || j + column >= Canvas.COLUMN){
						update();
						return false;
					}
					/*判断将要移动的位置上是否已经被占用*/
					if (canvas.isValidPlace(i+row, j+column) && canvas.map[i+row][j+column]) {
						update();
						return false;
					}
				}
			}
		}
		/*恢复方块模型*/
		update();
		return true;
	}
	
	/*判断方块模型是否到底部*/
	public boolean isTouchBottom(int row,int column) {
		erase();
		for (int i=0;i<dimension;i++) {
			for (int j=0;j<dimension;j++) {
				if (model[i][j]) {
					int nextR = i + 1 + row;
					int nextC = j + column;
					/*若已经到底部*/
					if (nextR == Canvas.ROW) {
						update();
						return true;
					}
					/*判断当前单元格下方的单元格是否已经被占用*/
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
	
	/*变形*/
	public void rorate() {
		int newStatus = (status + 1)%MODELS[type].length;
		if (!rorateable(MODELS[type][newStatus])) {
			return;
		}else {
			status ++;
		}
		/*擦除原先*/
		erase();
		/*旋转*/
		buildModel(MODELS[type][newStatus]);
		/*更新*/
		update();
	}
	
	//TODO 检查是否可以变形
	public boolean rorateable(int keyCode) {
		erase();
		
		/*初始化临时模型*/
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
	
	
	/*擦除方块*/ 
	public void erase() {
		for (int i=0;i<dimension;i++) {
			for (int j=0;j<dimension;j++) {
				if ( canvas.isValidPlace(row + i, column + j) && model[i][j]) {
					canvas.map[row+i][column+j] = false;
				}
			}
		}
	}
	/*构建网格模型*/
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