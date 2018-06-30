package com.xyx.nowcoder.tooffer;

/**
 * 问题：删除链表中重复的结点 问题描述： 在一个排序的链表中，存在重复的结点， 请删除该链表中重复的结点，重复的结点 不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * @author huan
 * @date 2018年6月30日
 */
public class Solution56 {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode deleteDuplication(ListNode pHead) {
		ListNode dummy = new ListNode(0);
		dummy.next = pHead;
		ListNode cur = pHead;
		ListNode last = dummy;
		
		//终止条件为：剩下的结点不够2个了
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				int val = cur.val;
				//找到相等的最后一个
				while (cur.next != null && cur.next.val == val)
					cur = cur.next;
				last.next = cur.next;
				cur = cur.next;
			} else {
				last = cur;
				cur = cur.next;
			}
		}
		return dummy.next;
	}

}
