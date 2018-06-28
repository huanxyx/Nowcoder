package com.xyx.nowcoder.tooffer;

/**
 * 问题：数字在排序数组中出现的次数
 * 问题描述：
 * 			统计一个数字在排序数组中出现的次数。
 * @author huan
 * @date 2018年6月25日
 */
public class Solution37 {
	
	/*
	 * 二分查找的变形
	 */
    public int GetNumberOfK(int [] array , int k) {
        if (array == null)
        	return 0;
        
        int startPos = binarySearchStart(array, k);
        //记得注意startPos可以会越界，因为当需要查找的数大于该数组所有的数时，startPos == array.length
        if (startPos >= array.length || array[startPos] != k)
        	return 0;
        int endPos = binarySearchEnd(array, k);
        
        return endPos - startPos + 1;
    }
    
    //查找一个元素在排序数组中开始的位置
    private int binarySearchStart(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
        	int mid = start + ((end - start) >> 1);
        	if (array[mid] < k) 
        		start = mid + 1;
        	else if (array[mid] > k)
        		end = mid - 1;
        	else 
        		end = mid - 1;
        }
        return start;
    }
    
    //查找一个元素在排序数组中结束的位置
    private int binarySearchEnd(int[] array, int k) {
    	int start = 0;
    	int end = array.length - 1;
    	while (start <= end) {
    		int mid = start + ((end - start) >> 1);
    		if (array[mid] < k)
    			start = mid + 1;
    		else if (array[mid] > k)
    			end = mid - 1;
    		else 
    			start = mid + 1;
    	}
    	return end;
    }

}
