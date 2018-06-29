package com.xyx.nowcoder.tooffer;

/**
 * 问题：不用加减乘除做加法
 * 问题描述：
 * 			写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author huan
 * @date 2018年6月29日
 */
public class Solution48 {

	/*
	 * 使用位运算符实现加法运算：
	 * 		1.不考虑进位，利用异或运算
	 * 		2.考虑进位，利用与运算，并向左位移一位
	 * 		3.一，二步骤产生了两个新的数，若是进位数不为0，则新对这两个操作数进行以上的重复操作
	 */
    public int Add(int num1,int num2) {
    	int sum = 0;
    	int carry = 0;
    	
    	do {
    		sum = num1 ^ num2;				//不考虑进位的结果
    		carry = (num1 & num2) << 1;		//因为进位产生的新数
    		num1 = sum;
    		num2 = carry;
    	} while (num2 != 0);
    	
        return sum;
    }
}
