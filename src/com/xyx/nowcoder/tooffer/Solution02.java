package com.xyx.nowcoder.tooffer;

/**
 * 问题：替换空格
 * 问题描述：
 * 			请实现一个函数，将一个字符串中的空格
 * 			替换成“%20”。例如，当字符串为
 * 			We Are Happy.则经过替换之后的字符串
 * 			为We%20Are%20Happy。
 * @author huan
 * @date 2018年6月20日
 */
public class Solution02 {

	/*
	 * 不使用额外空间，只在str上操作
	 */
    public String replaceSpace(StringBuffer str) {
    	if (str == null)
    		return "";
    	//计算空格的数目，获取字符串需要的空间
    	int spaceCount = 0;
    	int originLen = str.length();
    	for (int i = 0; i < str.length(); i++) 
    		if (str.charAt(i) == ' ')
    			spaceCount++;
    	int newLen = originLen + spaceCount * 2;
    	str.setLength(newLen);
    	//双指针
    	int right = newLen - 1;
    	int left = originLen - 1;
    	//从后往前移动，遇到空格，后面的指针移动三位用于存储%20
    	while (right != left) {
    		char cur = str.charAt(left);
    		if (cur == ' ') {
    			str.setCharAt(right--, '0');
    			str.setCharAt(right--, '2');
    			str.setCharAt(right--, '%');
    		} else {
    			str.setCharAt(right--, cur);
    		}
    		left--;
    	}
    	
    	return str.toString();
    }

}
