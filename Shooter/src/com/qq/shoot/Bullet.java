package com.qq.shoot;


/**
 * 子弹类
 */
public class Bullet extends FlyingObject {
	private int speed = 5;  //移动速度
	private boolean bomb;
	public Bullet(int x,int y){
		this.x = x;
		this.y = y;
		this.image = ShootGame.bullet;
	}
	
	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}
	
	public boolean isBomb() {
		return bomb;
	}

	@Override
	public void step(){   //重写step()移动方法
		y-=speed;
	}

	@Override
	public boolean outOfBounds() {
		return y<-height;
	}

}
