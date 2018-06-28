package com.xyx.nowcoder.tooffer;

import java.util.ArrayList;

/**
 * 问题：和为S的连续正数序列
 * 问题描述：
 * 			小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 			他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟
 * 			有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就
 * 			得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交
 * 			给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * @author huan
 * @date 2018年6月25日
 */
public class Solution41 {

	/*
	 * 使用两个指针，存储着连续序列的头和尾
	 */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	int left = 1;
    	int right = 2;
    	int end = sum >> 1;
    	int s = 3;
    	
    	while (left <= end) {
    		if (s < sum) {
    			right++;
    			s += right;
    		} else if (s > sum) {
    			s -= left;
    			left++;
    		} else {
    			result.add(produceResult(left, right));
    			right++;
    			s += right;
    		}
    	}
    	return result;
    }
    
    //生成结果序列
    private ArrayList<Integer> produceResult(int start, int end) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	for (int i = start; i <= end; i++)
    		result.add(i);
    	
    	return result;
    }

}
