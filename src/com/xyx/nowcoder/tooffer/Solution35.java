package com.xyx.nowcoder.tooffer;

/**
 * 问题：
 * 问题描述：
 * 				在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 				则这两个数字组成一个逆序对。输入一个数组,求出这个数
 * 				组中的逆序对的总数P。并将P对1000000007取模的结果输
 * 				出。 即输出P%1000000007
 * @author huan
 * @date 2018年6月25日
 */
public class Solution35 {

	/*
	 * 借助归并排序，将数组分为两个部分，两个部分内部已经计算好了逆序数，只需要求两个部分之间的
	 * 逆序数了
	 */
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0 || array.length == 1)
        	return 0;
        
        int[] helper = new int[array.length];
        
        return (int) (mergeSort(array, 0, array.length - 1, helper) % 1000000007);
    }
    
    private long mergeSort(int[] array, int start, int end, int[] helper) {
    	if (start >= end)
    		return 0;
    	int mid = start + ((end - start) >> 1);
    	return mergeSort(array, start, mid, helper) + mergeSort(array, mid + 1, end, helper)
    	 				+ merge(array, start, mid, end, helper);
    }
    
    private long merge(int[] array, int start, int mid, int end, int[] helper) {
    	//拷贝到辅助数组中
    	for (int i = start; i <= end; i++) 
    		helper[i] = array[i];
    	
    	int cur = start;
    	int left = start;
    	int right = mid + 1;
    	long count = 0;
    	while (left <= mid && right <= end) {
    		if (helper[left] <= helper[right])
    			array[cur++] = helper[left++];
    		else {
    			count += mid - left + 1;
    			array[cur++] = helper[right++];
    		}
    	}
    	
    	while (left <= mid) {
    		array[cur++] = helper[left++];
    	}
    	while (right <= end) {
    		array[cur++] = helper[right++];
    	}
    	return count;
    }

}
