package com.qq.shoot;
/**
 * 奖励接口
 */
public interface Award {
	int DOUBLE_FIRE = 0;  //火力值
	int LIFE = 1;   //生命
	/** 获得奖励类型 */
	int getType();
}
