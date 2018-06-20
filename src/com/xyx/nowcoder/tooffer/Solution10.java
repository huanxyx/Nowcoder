package com.xyx.nowcoder.tooffer;

/**
 * 问题：矩形覆盖
 * 问题描述：
 * 			我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 			请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author huan
 * @date 2018年6月20日
 */
public class Solution10 {

	/*
	 * 变相的斐波拉契序列
	 * 新增的一列，要么横着放两个，要么竖着放一个
	 */
    public int RectCover(int target) {
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
