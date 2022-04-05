package com.qq.shoot;

import java.util.Random;
//蜜蜂类
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 1;//x坐标移动速度
	private int ySpeed = 2;//y坐标移动速度
	private int awardType;
	
	public Bee(){
		this.image = ShootGame.bee;
		this.ember = ShootGame.beeEmber;
		width = image.getWidth();
		height = image.getHeight();
		y = -height;
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - width);
		awardType = rand.nextInt(2);   //0和1之间的随机数
	}
	//获取奖励类型
	public int getType(){
		return awardType;
	}
	//重写outOfBounds()方法
	@Override
	public boolean outOfBounds() {
		return y>ShootGame.HEIGHT;
	}
	//重写step()移动方法
	@Override
	public void step() {     
		x += xSpeed;
		y += ySpeed;
		if(x > ShootGame.WIDTH-width){
			xSpeed = -1;
		}
		if(x < 0){
			xSpeed = 1;
		}
	}
}