package com.xyx.nowcoder.tooffer;

/**
 * 问题：数组中重复的数字
 * 问题描述：
 * 				在一个长度为n的数组里的所有数字都在0到n-1的范
 * 				围内。 数组中某些数字是重复的，但不知道有几个数字
 * 				是重复的。也不知道每个数字重复几次。请找出数组中
 * 				任意一个重复的数字。 例如，如果输入长度为7的数
 * 				组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @author huan
 * @date 2018年6月29日
 */
public class Solution50 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length == 0 || duplication == null)
        	return false;
        
        //将每个元素放到属于它的位置,
        //若是那个位置的元素已经有正确的元素，那意味着出现了重复
        int cur = 0;
        while (cur < length) {
        	if (numbers[cur] == cur)
        		cur++;
        	else {
        		if (numbers[numbers[cur]] != numbers[cur])
        			swap(numbers, numbers[cur], cur);
        		else {
        			duplication[0] = numbers[cur];
        			return true;
        		}
        	}
        }
        return false;
    }
    
    private void swap(int[] numbers, int a, int b) {
    	numbers[a] = numbers[a] + numbers[b];
    	numbers[b] = numbers[a] - numbers[b];
    	numbers[a] = numbers[a] - numbers[b];
    }

}
