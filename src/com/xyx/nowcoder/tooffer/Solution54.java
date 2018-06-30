package com.xyx.nowcoder.tooffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题：字符流中第一个不重复的字符
 * 问题描述：
 * 				请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 				例如，当从字符流中只读出前两个字符"go"时，第一个只出现
 * 				一次的字符是"g"。当从该字符流中读出前六个字符“google"时
 * 				，第一个只出现一次的字符是"l"。
 * @author huan
 * @date 2018年6月30日
 */
public class Solution54 {
	
	/*
	 * 使用一个map存储每个字符出现的次数
	 * 使用一个队列存储加入的字符
	 * 
	 * 当需要查找第一个只出现一个的字符，则不断地从队列中弹出元素，
	 * 若是这个元素只出现一次地为所求的结果，若是队列为空时还未找到一个满足条件的元素
	 * 则返回'#'
	 */
    int[] map = new int[256];
    Queue<Character> list = new LinkedList<Character>();
    
    public void Insert(char ch) {
        map[ch]++;
        list.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
    	//当有重复的时候，剔除，直到没有重复的或者为空的时候
    	while (!list.isEmpty() && map[list.peek()] > 1)
    		list.poll();
    	
    	if (list.isEmpty())
    		return '#';
    	else 
    		return list.peek();
    }

}
