package com.xyx.nowcoder.tooffer;

import java.util.HashSet;

/**
 * 问题：两个链表的第一个公共结点
 * 问题描述：
 * 			输入两个链表，找出它们的第一个公共结点。
 * @author huan
 * @date 2018年6月25日
 */
public class Solution36 {
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	/*
	 * 1.借助HashSet查重
	 * 2.求解出两个链表的长度，让长的那个链表先走他们的差值，然后一起走，直到找到第一个相同的点
	 * 3.借助栈，然后反向判断是否相同
	 */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	 HashSet<ListNode> set1 = new HashSet<ListNode>();

    	 while (pHead1 != null && !set1.contains(pHead1)) {
    		 set1.add(pHead1);
    		 pHead1 = pHead1.next;
    	 }
    	 
    	 HashSet<ListNode> set2 = new HashSet<ListNode>();
    	 
    	 while (pHead2 != null && !set2.contains(pHead2)) {
    		 if (set1.contains(pHead2))
    			 return pHead2;
    		 set2.add(pHead2);
    		 pHead2 = pHead2.next;
    	 }
    	 return null;
    }


}
