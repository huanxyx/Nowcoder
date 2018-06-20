package com.xyx.nowcoder.tooffer;

/**
 * 问题：跳台阶
 * 问题描述：
 * 			一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 			求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author huan
 * @date 2018年6月20日
 */
public class Solution08 {

	/*
	 * 假如跳到第n阶有k种不同的方法，跳到第n+1阶有w种不同的方法，那么跳到n+2阶有k+w种方法：
	 * 变相的斐波拉契序列
	 */
    public int JumpFloor(int target) {
    	if (target < 3)
            return target;
    	int a = 1;
    	int b = 2;
    	for (int i = 3; i <= target; i++) {
    		b = a + b;
    		a = b - a;
    	}
    	return b;
    }

}
