package com.xyx.nowcoder.tooffer;

/**
 * 问题：数组中只出现一次的数字
 * 问题描述：
 * 			一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 			请写程序找出这两个只出现一次的数字。
 * @author huan
 * @date 2018年6月25日
 */
public class Solution40 {
	
	/*
	 * 利用异或运算的规律：两个相同的数异或为0
	 * 所以若是数组中只有一个数只有一个，而其他数均为两个的时候，所有数的异或结果就是这个数
	 * 同理若是由两个数，则最后的异或结果就是这两个数的异或结果，肯定不为0，因为这两个数不相等
	 * 所以只需要找到它们异或结果中第一个为1的位，然后通过判断这个位置是否为1来划分这两个只有一个的数（其他数都有2个，所以异或后为0）
	 */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        
    	int bitSum = 0;
    	for (int num : array) {
    		bitSum ^= num;
    	}
    	int splitMask = 1 << findFirstBitIs1(bitSum);			//用来划分的掩码
    	
    	int n1 = 0;											//第一个数
    	int n2 = 0;											//第二个数
    	for (int num : array) {
    		if ((splitMask & num) != 0)  
    			n1 ^= num;
    		else
    			n2 ^= num;
    	}
    	num1[0] = n1;
    	num2[0] = n2;
    }
    
    //找到一个数二进制表示中第一个为1的位置0-31
    private int findFirstBitIs1(int num) {
    	
    	for (int i = 0; i < 32; i++) {
    		if ((num & 1) == 1)
    			return i;
    		else
    			num = num >> 1;
    	}
    	throw new IllegalArgumentException();
    }

}
