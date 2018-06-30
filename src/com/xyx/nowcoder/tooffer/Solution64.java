package com.xyx.nowcoder.tooffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 问题：滑动窗口的最大值 
 * 问题描述： 
 * 					给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 					例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一 共存在6个
 * 					滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数
 * 					组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * 					{2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 * 					{2,3,4,2,6,[2,5,1]}。
 * 
 * @author huan
 * @date 2018年6月30日
 */
public class Solution64 {

	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (num == null || size == 0 || num.length < size)
			return result;
		
		//存储着数的下标，用来判断是否过期
		Deque<Integer> index = new LinkedList<Integer>();
		
		for (int i = 0; i < num.length; i++) {
			/*
			 * 判断最大值是否过期，假如过期了，则需要把这个值删掉
			 */
			if (!index.isEmpty() && i >= index.peekFirst() + size)
				index.pollFirst();
			/*
			 * 从队尾开始比较，删除比他小的数，因为这些数不可能为最大值了
			 */
			while (!index.isEmpty() && num[index.peekLast()] < num[i])
				index.pollLast();
			index.offerLast(i);	
			if (i >= size - 1)
				result.add(num[index.peekFirst()]);
		}
		return result;
	}

}
