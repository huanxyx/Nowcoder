package com.xyx.nowcoder.tooffer;

/**
 * 问题：链表中倒数第k个结点
 * 问题描述：输入一个链表，输出该链表中倒数第k个结点。
 * @author huan
 * @date 2018年6月21日
 */
public class Solution14 {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	/*
	 * 一般解法：遍历第一次求出节点个数，遍历第二次找到倒数第k个结点
	 * 双指针解法：第一个指针先走k步（有可能没有k个节点），然后第二个指针再与第一个指针同时走
	 */
    public ListNode FindKthToTail(ListNode head,int k) {
    	//链表为空的情况, k为0时，虽然本程序中k为0之后也能得到null，但是这个判断能够加速函数的执行
    	if (head == null || k == 0)
    		return null;
    	ListNode fast = head;
    	//距离相隔k个
    	while (k != 0 && fast != null) {
    		fast = fast.next;
    		k--;
    	}
    	//链表节点没有k个的情况
    	if (k != 0)
    		return null;
    	ListNode slow = head;
    	//fast != null必须与上面的保持一致
    	while (fast != null) {
    		fast = fast.next;
    		slow = slow.next;
    	}
    	return slow;
    }

}
