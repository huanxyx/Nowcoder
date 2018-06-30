package com.xyx.nowcoder.tooffer;

/**
 * 问题：链表中环的入口结点 
 * 问题描述： 
 * 				一个链表中包含环，请找出该链表的环的入口结点。
 * @author huan
 * @date 2018年6月30日
 */
public class Solution55 {

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/*
	 * 另一种实现方式：
	 * 			找到环中结点的个数n（快慢指针，相等位置一定是在环上）
	 * 			然后重置位置，让快指针先走n步，然后再让快指针和慢指针同时走
	 * 			当相等的时候就是入环结点
	 */
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null)
			return null;
		
		ListNode slow = pHead;
		ListNode fast = pHead.next;
		
		while (fast != null && fast.next != null && fast != slow) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//没有环
		if (fast == null || fast.next == null)
			return null;
		
		fast = pHead;
		slow = slow.next;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
			
		return fast;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = head.next.next;
		
		System.out.println(new Solution55().EntryNodeOfLoop(head).val);
	}
}
