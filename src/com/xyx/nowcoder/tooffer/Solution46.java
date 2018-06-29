package com.xyx.nowcoder.tooffer;

/**
 * 问题：孩子们的游戏（圆圈中最后剩下的数）
 * 问题描述：	
 * 				约瑟夫环问题
 * @author huan
 * @date 2018年6月28日
 */
public class Solution46 {
	
	
	/*
	 * 一般解法：使用循环链表
	 * 创新解法：发现其中的规律
	 * 			F(n,m) = (F(n-1,m) + m) % n
	 * 	当一个元素个数为n的环第一次删除一个元素的时候，
	 * 	剩下了n-1个元素，这n-1个元素可以通过一个函数映射到0到n-1
	 * 	上。
	 * 
	 * 	综：要得到n个数字的序列中最后剩下的数字，只需要得到n-1个数字
	 * 	的序列中最后剩下的数字
	 */
    public int LastRemaining_Solution(int n, int m) {
    	if (n < 1 || m < 1)
    		return -1;
    	int last = 0;
    	for (int i = 2; i <= n; i++)
    		last = (last + m) % i;
    	return last;
    }

}
