package com.xyx.nowcoder.tooffer;

/**
 * 问题：左旋转字符串
 * 问题描述：
 * 				汇编语言中有一种移位指令叫做循环左移（ROL），
 * 				现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 				对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 				例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 				即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @author huan
 * @date 2018年6月25日
 */
public class Solution43 {

	/*
	 * 第一步：将前k个字符翻转，将后len-k个字符翻转
	 * 第二步：全部翻转
	 */
    public String LeftRotateString(String str,int n) {
        
    	if (str == null || str.length() == 0 || str.length() == 1 || n < 0) 
    		return str;
    	
    	int len = str.length();
    	n = n % len;
    	char[] strCh = str.toCharArray();
    	
    	//翻转前n个字符
    	reverseRange(strCh, 0, n - 1);
    	//翻转后len - k个字符
    	reverseRange(strCh, n, len - 1);
    	
    	//全部翻转
    	reverseRange(strCh, 0, len - 1);

    	return new String(strCh);
    }
    
    //翻转一个数组[start, end]之间的字符
    private void reverseRange(char[] strCh, int start, int end) {
    	if (strCh == null || strCh.length == 0 || strCh.length <= end || start < 0 || start >= end)
    		return ;
    	
    	while (start < end) {
    		char tmp = strCh[start];
    		strCh[start] = strCh[end];
    		strCh[end] = tmp;
    		start++;
    		end--;
    	}
    }
}
