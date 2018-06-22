package com.xyx.nowcoder.tooffer;

/**
 * 问题：复杂链表的复制
 * 问题描述：
 * 				输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 				一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 				返回结果为复制后复杂链表的head。
 * 				（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author huan
 * @date 2018年6月21日
 */
public class Solution25 {

	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	/*
	 * 在原链表中每个节点的后面创建拷贝节点
	 */
    public RandomListNode Clone(RandomListNode pHead) {
    	cloneNodes(pHead);
    	setRandomNext(pHead);
    	return split(pHead);
    }
    
    //克隆新节点到每个节点的后面
    private void cloneNodes(RandomListNode head) {
    	RandomListNode cur = head;
    	while (cur != null) {
    		RandomListNode newNode = new RandomListNode(cur.label);
    		newNode.next = cur.next;
    		cur.next = newNode;
    		cur = cur.next.next;
    	}
    }
    
    //设置克隆节点的random
    private void setRandomNext(RandomListNode head) {
    	RandomListNode cur = head;
    	while (cur != null) {
    		RandomListNode newNode = cur.next;
    		newNode.random = cur.random == null ? null : cur.random.next;		//注意为空的时候
    		cur = cur.next.next;
    	}
    }
    
    //分割获取克隆链表
    private RandomListNode split(RandomListNode head) {
    	RandomListNode dummy = new RandomListNode(1);
    	RandomListNode newCur = dummy;
    	RandomListNode cur = head;
    	
    	while (cur != null) {
    		newCur.next = cur.next;
    		cur.next = cur.next.next;
    		cur = cur.next;
    		newCur = newCur.next;
    	}
    	return dummy.next;
    }

}
