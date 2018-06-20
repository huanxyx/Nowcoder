package com.xyx.nowcoder.tooffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 问题：从尾到头打印链表
 * 问题描述：
 * 			输入一个链表，从尾到头打印链表每个节点的值。
 * @author huan
 * @date 2018年6月20日
 */
public class Solution03 {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/*
	 * 使用栈逆序，也可以使用递归，不过若是递归太深，有可能会导致栈溢出
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack = new Stack<Integer>();
		
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (!stack.isEmpty()) 
			result.add(stack.pop());
		return result;
	}

}
