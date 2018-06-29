package com.xyx.nowcoder.tooffer;

/**
 * 问题：求1+2+3+...+n
 * 问题描述：
 * 			求1+2+3+...+n，要求不能使用乘
 * 			除法、for、while、if、else、switch、case等
 * 			关键字及条件判断语句（A?B:C）。
 * @author huan
 * @date 2018年6月29日
 */
public class Solution47 {
	
	/*
	 * 利用&&关系运算符代替递归的终止if语句
	 */
    public int Sum_Solution(int n) {
        return add(n);
    }
    
    public static int add(int n) {
    	int sum = 0;
    	boolean tmp = (n > 0) && ((sum = (add(n - 1) + n)) == 0);
    	return sum;
    }
}
