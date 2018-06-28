package com.xyx.nowcoder.tooffer;

/**
 * 问题：翻转单词顺序列
 * 问题描述：
 * 				牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 				写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向
 * 				Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 				后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应
 * 				该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author huan
 * @date 2018年6月25日
 */
public class Solution44 {

	/*
	 * 第一步：翻转所有的字符
	 * 第二步：翻转每个单词中的顺序
	 */
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0 || str.length() == 1)
        	return str;
    	
        char[] strCh = str.toCharArray();
        
        //翻转所有字符
        reverseRange(strCh, 0, strCh.length - 1);
        
        //翻转每一个单词
        int start = 0;
        while (start < strCh.length) {
        	if (strCh[start] != ' ') {
	        	int end = start;
	        	while (end != strCh.length && strCh[end] != ' ') 
	        		end++;
	        	reverseRange(strCh, start, end - 1);
	        	start = end;
        	} else 
        		start++;
        }
    	
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
