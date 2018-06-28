package com.xyx.nowcoder.tooffer;

import java.util.ArrayList;

/**
 * 问题：和为S的两个数字
 * 问题描述：
 * 			输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 			是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 			（对应每个测试案例，输出两个数，小的先输出。）
 * @author huan
 * @date 2018年6月25日
 */
public class Solution42 {

	/*
	 * 使用双指针，从头和尾开始遍历
	 */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
        	int s = array[left] + array[right];
        	if (s < sum)
        		left++;
        	else if (s > sum)
        		right--;
        	else 
        		break;
        }
        
        //注意数组为空的时候
        //所以不能只是left == right
        if (left >= right) 
        	return new ArrayList<Integer>();
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(array[left]);
        result.add(array[right]);
        
        return result;
    }

}
