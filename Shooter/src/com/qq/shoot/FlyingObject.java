package com.qq.shoot;

import java.awt.image.BufferedImage;

/**
 * 飞行物抽象类
 */
public abstract class FlyingObject {
	protected int x;
	protected int y;
	protected int width;   
	protected int height;
	protected BufferedImage image;
	protected BufferedImage[] ember;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	/**
	 * 越界抽象方法
	 * @param width  �߽��
	 * @param height �߽��
	 * @return true �������
	 */
	public abstract boolean outOfBounds();
	
	/**
	 * 移动抽象方法
	 */
	public abstract void step();
	
	/**
	 * 被射击方法，如果子弹坐标和敌机坐标相同就判断被轰炸
	 * true��ʾ���У���������Ա�����
	 * @param Bullet �ӵ�����
	 * @return true��ʾ��������
	 */
	public boolean shootBy(Bullet bullet){
		if(bullet.isBomb()){
			return false;
		}
		int x = bullet.x;  //将子弹类x坐标赋值给x;
		int y = bullet.y;  //将子弹类y坐标赋值给y;
		boolean shoot = this.x<x && x<this.x+width && this.y<y && y<this.y+height;
		if(shoot){
			bullet.setBomb(true);
		}
		return shoot;
	}

	public int getScore() {
		// TODO 自动生成的方法存根
		return 0;
	}

}
