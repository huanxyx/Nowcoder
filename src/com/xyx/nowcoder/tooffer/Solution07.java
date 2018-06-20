package com.xyx.nowcoder.tooffer;

/**
 * 问题：斐波那契数列
 * 问题描述：
 * 			大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * 			n<=39
 * @author huan
 * @date 2018年6月20日
 */
public class Solution07 {

    public int Fibonacci(int n) {
    	if (n == 0)
    		return 0;
    	if (n == 1 || n == 2)
    		return 1;
    	int a = 1;
    	int b = 1;
    	
    	for (int i = 3; i <= n; i++) {
    		b = a + b;
    		a = b - a;
    	}
    	return b;
    }

}
