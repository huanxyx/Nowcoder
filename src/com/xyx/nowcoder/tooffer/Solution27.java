package com.xyx.nowcoder.tooffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 问题：字符串排序
 * 问题描述：
 * 				输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 				例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所
 * 				有字符串abc,acb,bac,bca,cab和cba。
 * @author huan
 * @date 2018年6月22日
 */
public class Solution27 {

	/*
	 * 使用TreeSet进行字典序排序
	 */
    public ArrayList<String> Permutation(String str) {
    	ArrayList<String> result = new ArrayList<String>();
    	if (str == null || str.length() == 0)
    		return result;
    	
    	char[] strArr = str.toCharArray();
    	TreeSet<String> temp = new TreeSet<>();
    	recursPermutation(strArr, 0, temp);
    	result.addAll(temp);
    	return result;
    }
    
    /*
     * 分成两部分，前面一部分一个元素固定，后面部分利用递归求解
     * 每次递归确定一个元素
     */
    private void recursPermutation(char[] strArr, int cur, TreeSet<String> temp) {
    	if (cur >= strArr.length)
        	//当前位置已经超过了末尾
    		return ;
    	if (cur == strArr.length - 1) {
    		//当前位置到达了末尾
    		temp.add(new String(strArr));
    	} else {
    		for (int i = cur; i < strArr.length; i++) {
	    			swap(strArr, cur, i);
	    			recursPermutation(strArr, cur + 1, temp);
	    			swap(strArr, cur, i);
    		}
    	}
    }
    
    private void swap(char[] strArr, int a, int b) {
    	char tmp = strArr[a];
    	strArr[a] = strArr[b];
    	strArr[b] = tmp;
    }
    
}
