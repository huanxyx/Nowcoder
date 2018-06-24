package com.xyx.nowcoder.tooffer;

/**
 * 问题：第一个只出现一次的字符
 * 问题描述：	
 * 				在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找
 * 				到第一个只出现一次的字符,并返回它的位置
 * @author huan
 * @date 2018年6月24日
 */
public class Solution34 {

	/*
	 * 借助哈希表存储一个字符出现的次数
	 * 只需要遍历字符串两遍就可以解决问题
	 */
    public int FirstNotRepeatingChar(String str) {
    	if (str == null || str.length() == 0)
    		return -1;
        int[] counts = new int[256];
        
        for (int i = 0; i < str.length(); i++) {
        	char curCh = str.charAt(i);
        	counts[curCh]++;
        }
        
        for (int i = 0; i < str.length(); i++) {
        	char curCh = str.charAt(i);
        	if (counts[curCh] == 1)
        		return i;
        }
        return -1;
    }

}
