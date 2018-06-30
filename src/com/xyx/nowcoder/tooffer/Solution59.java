package com.xyx.nowcoder.tooffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题：按之字形顺序打印二叉树
 * 问题描述：
 * 			请实现一个函数按照之字形打印二叉树，即
 * 			第一行按照从左到右的顺序打印，第二层按照
 * 			从右至左的顺序打印，第三行按照从左到右的顺
 * 			序打印，其他行以此类推。
 * @author huan
 * @date 2018年6月30日
 */
public class Solution59 {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> result = 
    			new ArrayList<ArrayList<Integer>>();
    	
    	if (pRoot == null)
    		return result;
    	
    	Queue<TreeNode> queue1 = new LinkedList<TreeNode>();	//奇数层从左到右的队列
    	Queue<TreeNode> queue2 = new LinkedList<TreeNode>();	//偶数层从右到左的队列
    	Deque<Integer> stack = new LinkedList<Integer>();		//偶数层用来逆转顺序的栈
    	
    	queue1.offer(pRoot);
    	
    	while (!queue1.isEmpty()) {
    		//奇数层
    		ArrayList<Integer> item1 = new ArrayList<Integer>();
	    	while (!queue1.isEmpty()) {
	    		TreeNode cur = queue1.poll();
	    		item1.add(cur.val);
	    		if (cur.left != null)
	    			queue2.offer(cur.left);
	    		if (cur.right != null)
	    			queue2.offer(cur.right);
	    	}
	    	result.add(item1);
	    	
	    	//偶数层
    		ArrayList<Integer> item2 = new ArrayList<Integer>();
	    	while (!queue2.isEmpty()) {
	    		TreeNode cur = queue2.poll();
	    		stack.push(cur.val);
	    		if (cur.left != null)
	    			queue1.offer(cur.left);
	    		if (cur.right != null)
	    			queue1.offer(cur.right);
	    	}
	    	
	    	while (!stack.isEmpty())
	    		item2.add(stack.pop());
	    	//为空的时候不加入
	    	if (!item2.isEmpty())
	    		result.add(item2);
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(10);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(11);
		System.out.println(new Solution59().Print(root));
	}

}
