package com.xyx.nowcoder.tooffer;

/**
 * 问题：旋转数组的最小数字
 * 问题描述：
 * 			把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 			输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 			例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 			NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author huan
 * @date 2018年6月20日
 */
public class Solution06 {

	/*
	 * 二分查找改版算法找最小值:
	 * 		不断缩小查找的范围，直到只有一个元素的时候
	 */
    public int minNumberInRotateArray(int [] array) {
    	int low = 0;
    	int hig = array.length - 1;
    	
    	while (low < hig) {
    		int mid = low + ((hig - low) >> 1);
    		if (array[mid] <= array[hig]) {
    			hig = mid;
    		} else if (array[mid] > array[hig]) {
    			low = mid + 1;
    		}
    	}
    	return array[low];
    }

}
