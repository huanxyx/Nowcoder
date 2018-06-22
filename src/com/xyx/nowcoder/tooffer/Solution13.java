package com.xyx.nowcoder.tooffer;

/**
 * 问题：调整数组顺序使奇数位于偶数前面
 * 问题描述：	
 * 			输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 			使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 			并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author huan
 * @date 2018年6月21日
 */
public class Solution13 {
	
	/*
	 * 需要保证稳定性：快排不能保证稳定性
	 * 使用插入排序:时间复杂度为O(N^2)，或者使用额外空间O(N)
	 */
    public void reOrderArray(int [] array) {
    	if (array == null)
    		return ;
    	int oddRight = -1;
    	for (int i = 0; i < array.length; i++) {
    		int cur = array[i];
    		if (isOdd(cur)) {
	    		int j = i - 1;
	    		while (j > oddRight) {
	    			array[j + 1] = array[j--];
	    		}
	    		array[++oddRight] = cur;
    		}
    	}
    }
    
    private boolean isOdd(int a) {
    	return (a & 1) == 1;
    }

}
