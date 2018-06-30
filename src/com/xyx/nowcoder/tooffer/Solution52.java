package com.xyx.nowcoder.tooffer;

/**
 * 问题：正则表达式匹配
 * 问题描述：
 * 			请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 			模式中的字符'.'表示任意一个字符，而'*'表示它前
 * 			面的字符可以出现任意次（包含0次）。 在本题中，匹
 * 			配是指字符串的所有字符匹配整个模式。例如，字符
 * 			串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author huan
 * @date 2018年6月29日
 */
public class Solution52 {

    public boolean match(char[] str, char[] pattern) {
    	if (str == null || pattern == null)
    		return false;
    	
    	return matchCore(str, 0, pattern, 0);
    }
    
    /*
     * 注意：若是字符串已经遍历完了，而模式还没有遍历完，那么只存在两种情况
     * 				1.有*号，则直接跳过*号到后面一个元素
     * 				2.没有*号，则匹配失败
     */
    private boolean matchCore(char[] str, int curS, char[] pattern, int curP) {
    	
    	if (curS == str.length && curP == pattern.length) 
    		return true;
    	
    	if (curS != str.length && curP == pattern.length)
    		return false;
    	
    	//有*号标记
    	if (curP + 1 < pattern.length && pattern[curP + 1] == '*') {
    		if (curS < str.length && 
    				(str[curS] == pattern[curP] || pattern[curP] == '.')) 
    			//三种情况：
    			//使用多次，使用一次，不使用
    			return matchCore(str, curS + 1, pattern, curP) ||		
    					matchCore(str, curS + 1, pattern, curP + 2) ||
    					matchCore(str, curS, pattern, curP + 2);
    		else 
    			//直接移动到下一个位置
    			return matchCore(str, curS, pattern, curP + 2);
    	}
    	
    	//但没有*号标记
    	if (curS < str.length && 
    			(str[curS] == pattern[curP] || pattern[curP] == '.'))
    		return matchCore(str, curS + 1, pattern, curP + 1);
    	
    	return false;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution52().match("".toCharArray(), ".*".toCharArray()));
	}

}
