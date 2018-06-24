package com.xyx.nowcoder.tooffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 问题：把数组排成最小的数
 * 问题描述：
 * 			输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 			打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 			则打印出这三个数字能排成的最小数字为321323。
 * @author huan
 * @date 2018年6月24日
 */
public class Solution32 {

	/*
	 * 贪心：基于MinNumComparator比较器
	 */
    public String PrintMinNumber(int[] numbers) {
    	Integer[] referArr = translate(numbers);
    	Arrays.sort(referArr, new MinNumberComparator());
    	
    	StringBuilder builder = new StringBuilder();
    	for (Integer num : referArr)
    		builder.append(num.toString());
    	return builder.toString();
    }
    
    private static Integer[] translate(int[] numbers) {
    	Integer[] result = new Integer[numbers.length];
    	for (int i = 0; i < numbers.length; i++)
    		result[i] = numbers[i];
    	return result;
    }
    
    private static class MinNumberComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			String s1 = o1.toString();
			String s2 = o2.toString();
			return (s1 + s2).compareTo(s2 + s1);
		}
    }
}
