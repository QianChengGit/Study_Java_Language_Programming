package com.qq.shoot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShootGame extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 512; // 设置窗体宽512
	public static final int HEIGHT = 768; // 设置窗体高768
	/**游戏状态: START RUNNING PAUSE GAME_OVER */
	private int state;
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;

	private int score = 0; // 成绩
	private Timer timer; // 计时器
	private int intervel = 1000/100; // 测量间隔
	
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage bullet;
	public static BufferedImage airplane;
	public static BufferedImage[] airplaneEmber=new BufferedImage[4];
	public static BufferedImage bee;
	public static BufferedImage[] beeEmber=new BufferedImage[4];;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage[] heroEmber=new BufferedImage[4];;
	public static BufferedImage bigPlane;
	public static BufferedImage[] bigPlaneEmber=new BufferedImage[4];;

	private FlyingObject[] flyings = {}; // 飞行数组
	private Bullet[] bullets = {}; // 子弹
	private Hero hero = new Hero(); // 战机数组
	private Ember[] embers = {}; // 灰烬数组

	static {// 初始化静态图片
		try {
			background = ImageIO.read(new File("image/background.png"));//修改背景4-2修正图片颜色.jpg
			bigPlane = ImageIO.read(new File("image/bigplane.png"));//大飞机敌机.jpg
			airplane = ImageIO.read(new File("image/airplane.png"));//小飞机
			bee = ImageIO.read(new File("image/bee.png"));//蜜蜂
			bullet = ImageIO.read(new File("image/bullet.png"));//子弹  子弹.jpg
			hero0 = ImageIO.read(new File("image/hero0.png"));//英雄机0
			hero1 = ImageIO.read(new File("image/hero1.png"));//英雄机1
			pause = ImageIO.read(new File("image/pause.png"));//暂停页面
			gameover = ImageIO.read(new File("image/gameover.png"));//游戏结束页面
			start = ImageIO.read(new File("image/start.png"));//游戏开始页面
			for(int i=0; i<4; i++){
				beeEmber[i] = ImageIO.read(new File("image/boom"+i+".png"));//蜜蜂灰烬
				airplaneEmber[i] = ImageIO.read(new File("image/boom"+i+".png"));//小飞机灰烬
				bigPlaneEmber[i] = ImageIO.read(new File("image/boom"+i+".png"));//大飞机灰烬
				heroEmber[i] = ImageIO.read(new File("image/boom"+i+".png"));//英雄机灰烬
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	//覆写panit(Graphics)方法
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null); // 画背景
		paintEmber(g);//画灰烬
		paintHero(g); // 调用画英雄战机方法
		paintBullets(g); // 调用画子弹方法
		paintFlyingObjects(g); // 调用画飞行物方法
		paintScore(g); // 调用画成绩方法
		paintState(g); // 调用画状态方法
	}

	/**画英雄机方法 */
	public void paintHero(Graphics g) {
		g.drawImage(hero.getImage(), hero.getX(), hero.getY(), null);//获得英雄机并为其设置坐标
	}
	//画爆炸灰烬
	public void paintEmber(Graphics g) {
		for (int i = 0; i < embers.length; i++) {
			Ember e = embers[i];
			g.drawImage(e.getImage(), e.getX(), e.getY(), null);
		}
	}

	/** 画子弹 */
	public void paintBullets(Graphics g) {
		for (int i = 0; i < bullets.length; i++) {
			Bullet b = bullets[i];
			if(! b.isBomb())
				g.drawImage(b.getImage(), b.getX() - b.getWidth() / 2, b.getY(),
					null);
		}
	}

	/** 画飞行物 */
	public void paintFlyingObjects(Graphics g) {
		for (int i = 0; i < flyings.length; i++) {
			FlyingObject f = flyings[i];
			g.drawImage(f.getImage(), f.getX(), f.getY(), null);
		}
	}

	/** 画成绩 */
	public void paintScore(Graphics g) {
		int x = 10;
		int y = 25;
		Font font = new Font(Font.SANS_SERIF,Font.BOLD, 25);
		g.setColor(new Color(0xfff));//设置成绩字体颜色
		g.setFont(font); // 画设置的字体样式
		g.drawString("SCORE:" + score, x, y); // 画成绩板块
		y+=20;
		g.drawString("LIFE:" + hero.getLife(), x, y);//画生命值模块
	}

	/** 画游戏状态页面 */
	public void paintState(Graphics g) {
		switch (state) {
		case START:
			g.drawImage(start, 0, 0, null);
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}

	public void Test() {//static void main(String[] args)
		JFrame frame = new JFrame("Shoot Game");
		
		ShootGame game = new ShootGame(); // 创建ShootGame对象
		frame.add(game); // 添加JPanel中间容器
		frame.setSize(WIDTH, HEIGHT); // 设置窗体尺寸
		frame.setAlwaysOnTop(true); // 设置此窗口是否应该始终位于其他窗口上方
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 注册窗体关闭按钮
		frame.setIconImage(new ImageIcon("image\\张泽宏.jpg").getImage()); //P81013-111047 设置要作为此窗口图标显示的图像
		frame.setLocationRelativeTo(null); // 设置窗口相对于指定组件的位置。如果组件当前未显示，或者 c 为 null，则此窗口将置于屏幕的中央。
		frame.setVisible(true); // 设置窗体可见

		game.action(); // 调用ShootGame类中的action()方法
	}

	public void action() { // 活动方法
		// 创建鼠标适配器对象，为鼠标注册活动监听器，并处理鼠标事件
		MouseAdapter l = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) { // 覆写mouseMoved（）方法。（鼠标移动事件处理）
				if (state == RUNNING) { // 状态为运行
					int x = e.getX();//获得鼠标X坐标
					int y = e.getY();//获得鼠标y坐标
					hero.moveTo(x, y);//将英雄机和鼠标绑定(英雄机随鼠标移动)
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) { // 覆写mouseEntered()方法。（鼠标进入事件处理）
				if (state == PAUSE) { // 状态为暂停时，鼠标进入窗体
					state = RUNNING;//将状态设为运行
				}
			}

			@Override
			public void mouseExited(MouseEvent e) { // 覆写mouseExited()方法。（鼠标移出事件处理）
				if (state != GAME_OVER) {//游戏没有结束时，鼠标移出窗体
					state = PAUSE; // 将状态设为暂停
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) { // 覆写mouseClicked()方法。（鼠标完成单击事件处理）
				switch (state) {
				case START://状态为开始时，单击鼠标
					state = RUNNING;//将状态设为运行
					break;
				case GAME_OVER: // 游戏结束状态，单击鼠标
					flyings = new FlyingObject[0];//重置飞行物
					bullets = new Bullet[0];//重置子弹
					hero = new Hero();//重置英雄机
					score = 0;//重置成绩
					state = START;//将状态设为开始
					break;
				}
			}
		};
		this.addMouseListener(l); // 为容器注册鼠标事件监听
		this.addMouseMotionListener(l); // 为容器注册鼠标动作事件监听

		timer = new Timer(); // 计时器对象
		timer.schedule(new TimerTask() {//schedule（）安排指定的任务从指定的延迟后开始进行重复的固定延迟执行。以近似固定的时间间隔（由指定的周期分隔）进行后续执行。
			@Override					//TimerTask()创建一个新的计时器任务。
			public void run() {//此计时器任务要执行的操作。
				if (state == RUNNING) {
					enterAction(); // 进入活动
					stepAction(); // 移动活动
					shootAction(); // 射击活动
					bangAction(); // 重击活动
					outOfBoundsAction(); // 越界活动
					checkGameOverAction(); // 检查游戏结束活动
					emberAction();//灰烬活动
				}
				repaint(); // 调用重新绘制方法
			}
		}, intervel, intervel);
		//TimerTask() - 所要安排的任务。
		//第一个intervel - 执行任务前的延迟时间，单位是毫秒。
		//第二个intervel - 执行各后续任务之间的时间间隔，单位是毫秒。
	}
	//灰烬活动
	private void emberAction() {
		Ember[] live = new Ember[embers.length];
		int index = 0;
		for (int i = 0; i < embers.length; i++) {
			Ember ember = embers[i];
			if(! ember.burnDown()){
				live[index++]=ember;
			}
		}
		embers = Arrays.copyOf(live, index);
	}
	int flyEnteredIndex = 0; // 设置飞进入指数

	/** 敌人进入活动方法 */
	public void enterAction() {
		flyEnteredIndex++;
		if (flyEnteredIndex % 40 == 0) { // 判断飞进入指数能被40整除
			FlyingObject obj = nextOne(); // 调用nextOne()方法将返回的BigPlaine()或Airplane()或Bee()方法赋给obj。（获取敌人对象）
			flyings = Arrays.copyOf(flyings, flyings.length + 1);
			flyings[flyings.length - 1] = obj;//将敌人添加到最后一个元素
		}
	}

	//移动活动方法
	public void stepAction() {
		/** 飞行物移动 */
		for (int i = 0; i < flyings.length; i++) { // 让飞行物移动
			FlyingObject f = flyings[i];
			f.step();
		}

		/** 子弹移动 */
		for (int i = 0; i < bullets.length; i++) {
			Bullet b = bullets[i];
			b.step();
		}
		hero.step();//战机移动
	}

	int shootIndex = 0; // 射击指数

	/** 射击活动*/
	public void shootAction() {
		shootIndex++;
		if (shootIndex % 25 == 0) { // 判断是否是被25整除的射击指数
			Bullet[] bs = hero.shoot(); // 为子弹数组赋值（主战机类shoot()方法返回的子弹值
			bullets = Arrays.copyOf(bullets, bullets.length + bs.length); // 复制指定的数组，截取或用 0 填充（如有必要），以使副本具有指定的长度。
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length,
					bs.length); // ׷������
		}
	}

	/** 重击活动方法(子弹与敌机的碰撞) */
	public void bangAction() {
		for (int i = 0; i < bullets.length; i++) { // 获取子弹
			Bullet b = bullets[i];
			bang(b);
		}
	}

	/** 越界活动方法 */
	public void outOfBoundsAction() {
		int index = 0;
		FlyingObject[] flyingLives = new FlyingObject[flyings.length]; // 为飞行物数组设置长度
		for (int i = 0; i < flyings.length; i++) {
			FlyingObject f = flyings[i];
			if (!f.outOfBounds()) {
				flyingLives[index++] = f; // 为飞行物离开赋值
			}
		}
		flyings = Arrays.copyOf(flyingLives, index); // 将flyingLives的长度复制给flyings

		index = 0; // 指数赋值为0
		Bullet[] bulletLives = new Bullet[bullets.length];
		for (int i = 0; i < bullets.length; i++) {
			Bullet b = bullets[i];
			if (!b.outOfBounds()) {
				bulletLives[index++] = b;
			}
		}
		bullets = Arrays.copyOf(bulletLives, index); // 将bulletLives的长度复制给bullets数组
	}

	/** 检查游戏结束活动方法 */
	public void checkGameOverAction() {
		if (isGameOver()) {
			state = GAME_OVER; // 设置游戏状态为结束״̬
		}
	}

	/** 游戏结束方法 */
	public boolean isGameOver() {
		int index = -1;
		for (int i = 0; i < flyings.length; i++) {
			FlyingObject obj = flyings[i];
			if (hero.hit(obj)) { // 判断战机是否被打击
				hero.subtractLife();
				hero.setDoubleFire(0);
				index = i;
				
				Ember ember = new Ember(hero);
				embers = Arrays.copyOf(embers, embers.length+1);
				embers[embers.length-1]=ember;
			}
		}
		if(index!=-1){
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = t;
			flyings = Arrays.copyOf(flyings, flyings.length-1);
			
			Ember ember = new Ember(t);
			embers = Arrays.copyOf(embers, embers.length+1);
			embers[embers.length-1]=ember;
		}
		return  hero.getLife() <= 0;
	}

	/** 重击方法 */
	public void bang(Bullet bullet) {
		int index = -1; // 初始化指数为-1
		for (int i = 0; i < flyings.length; i++) {
			FlyingObject obj = flyings[i];
			if (obj.shootBy(bullet)) { // 判断是否被射击（撞上了）
				index = i; // 为指数赋值
				break;
			}
		}
		if (index != -1) { // 撞上了
			FlyingObject one = flyings[index]; // 为飞行物对象赋值（被撞的敌人）

			FlyingObject temp = flyings[index]; // 为临时飞行物对象赋值
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = temp;

			flyings = Arrays.copyOf(flyings, flyings.length - 1); // 为飞行数组定义长度

			// 敌机被击中
			if (one instanceof Enemy) { // 判断one是不是Enemy类的实例化对象
				Enemy e = (Enemy) one; // 将one强制转换为Enemy类型并赋值给e
				score += e.getScore(); // 打中敌人成绩增加
			} 
			//判断是不是奖励
			if (one instanceof Award) { // 判断one是不是Award类的实例化对象
				Award a = (Award) one;
				int type = a.getType(); // 获得战机状态
				switch (type) {
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire(); // 战机双火模式
					break;
				case Award.LIFE:
					hero.addLife(); // 战机增加生命值
					break;
				}
			}
			
			//灰烬效果
			Ember ember = new Ember(one);
			embers = Arrays.copyOf(embers, embers.length+1);
			embers[embers.length-1]=ember;
		}
	}

	/**
	 * 飞行物出现方法
	 * 
	 * @return 返回敌人飞行物
	 */
	public static FlyingObject nextOne() {
		Random random = new Random();
		int type = random.nextInt(20); // [0,4)
		if (type==0) {
			return new Bee();
		}else if(type<=2){
			return new BigPlane();
		}else{
			return new Airplane();
		}
	}
}
