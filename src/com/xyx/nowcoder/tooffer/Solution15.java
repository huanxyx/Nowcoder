package com.xyx.nowcoder.tooffer;

/**
 * 问题：反转链表
 * 问题描述：输入一个链表，反转链表后，输出链表的所有元素。
 * @author huan
 * @date 2018年6月21日
 */
public class Solution15 {

	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	/*
	 * 学会如何对代码输入样例进行分类
	 */
    public ListNode ReverseList(ListNode head) {
    	ListNode lastNode = null;
    	ListNode cur = head;
    	while (cur != null) {
    		ListNode next = cur.next;
    		cur.next = lastNode;
    		lastNode = cur;
    		cur = next;
    	}
    	return lastNode;
    }
    
    /*
     * 递归实现：
     * 		处理head 为空的情况
     * 		处理head.next 为空的情况，也就是该链表只有一个节点（无需执行head.next了）
     */
    private ListNode recursReverseList(ListNode head) {
    	if (head == null || head.next == null)
    		return head;
    								
    	ListNode reverseHead = recursReverseList(head.next);
    	ListNode reverseTail = head.next;
    	reverseTail.next = head;
    	head.next = null;									//别忘了
    	return reverseHead;
    }

}
