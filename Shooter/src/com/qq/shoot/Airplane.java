package com.qq.shoot;



/**
 * 敌机
 */
public class Airplane extends FlyingObject implements Enemy {

	int speed = 2;  //移动的速度
	
	public Airplane(){
		this.image = ShootGame.airplane;
		this.ember = ShootGame.airplaneEmber;
		width = image.getWidth();
		height = image.getHeight();
		y = -height;          
		x = (int)(Math.random()*(ShootGame.WIDTH - width));
	}

	
	@Override
	public int getScore() {  //重写getScore()得分方法
		return 5;
	}

	@Override
	public 	boolean outOfBounds() {   //重写outOfBounds()检查是否越界
		return y>ShootGame.HEIGHT;
	}

	@Override
	public void step() {   //重写移动方法
		y += speed;
	}

}

