package com.xyx.nowcoder.tooffer;

/**
 * 问题：连续子数组的最大和
 * 问题描述：
 * 			HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 			今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 			常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 			但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 			例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 			你会不会被他忽悠住？(子向量的长度至少是1)
 * @author huan
 * @date 2018年6月24日
 */
public class Solution30 {

	/*
	 * 需要先判断之前的和是否小于0，若是小于0，则之后只会使数总和变小
	 */
    public int FindGreatestSumOfSubArray(int[] array) {
    	if (array == null || array.length == 0)
    		throw new IllegalArgumentException();
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int ele : array) {
        	if (sum < 0)
        		sum = 0;
        	sum += ele;
        	maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

}
