package com.xyx.nowcoder.tooffer;

/**
 * 问题：二进制中1的个数
 * 问题描述：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author huan
 * @date 2018年6月21日
 */
public class Solution11 {

	/*
	 * 小知识点：
	 * 			位运算符的优先级小于关系运算符。
	 * 			>>>无符号位移运算
	 * 原理如下：
	 * 			每次n&(n-1)将会去掉n的二进制表示中最右边的1
	 * 			
	 */
    public int NumberOf1(int n) {
    	int count = 0;
        while (n != 0) {
        	count++;
        	n &= n - 1;
        }
        return count;
    }

}
