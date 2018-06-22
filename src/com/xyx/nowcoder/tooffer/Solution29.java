package com.xyx.nowcoder.tooffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 问题：最小的K个数
 * 问题描述：
 * 			输入n个整数，找出其中最小的K个数。
 * 			例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author huan
 * @date 2018年6月22日
 */
public class Solution29 {

	/*
	 * 若是能够修改数据：可以是快速排序的分割算法，直到分割到指定位置k-1
	 * 使用一个容器存储（堆：海量数据处理）：
	 * 			1.能够在k个整数中找到最大数
	 * 			2.能够在这个容器中删除最大数	
	 * 			3.能够插入一个新的数
	 */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if (input == null || input.length == 0 || input.length < k)
    		return result;
    	
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
    	for (int num : input) {
    		queue.offer(num);
    		while (queue.size() > k) {
    			queue.poll();
    		}
    	}
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	while (!queue.isEmpty()) {
    		stack.push(queue.poll());
    	}
    	while (!stack.isEmpty()) {
    		result.add(stack.pop());
    	}
    	return result;
    }

}
