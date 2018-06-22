package com.xyx.nowcoder.tooffer;

/**
 * 问题：数组中出现次数超过一般的数字
 * 问题描述：
 * 			数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 			例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 			超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author huan
 * @date 2018年6月22日
 */
public class Solution28 {

	/*
	 * 解决方案一：使用快排的分割算法，直到分割到中点的位置
	 * 解决方案二：使用快排排序，找到中间位置的数
	 * 解决方案三：因为存在一个元素的数超过一般，所以这个数的计数大于其他数的个数和（使用这种）
	 * 
	 * 注意：记得检查改数是否超过了半数
	 */
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) 
        	return 0;
        
        int count = 0;
        int num = 0;
        for (int ele : array) {
        	if (count == 0) {
        		count++;
        		num = ele;
        	} else {
        		if (ele == num)
        			count++;
        		else
        			count--;
        	}
        }
        
        if (checkMoreThanHalf(array, num))
        	return num;
    	return 0;
    }
    
    //检查是否超过一半了
    private boolean checkMoreThanHalf(int[] array, int num) {
    	int count = 0;
    	for (int ele : array) {
    		count = num == ele ? (count + 1) : count;
    	}
    	if (count > (array.length >> 1))
    		return true;
    	return false;
    }
}
