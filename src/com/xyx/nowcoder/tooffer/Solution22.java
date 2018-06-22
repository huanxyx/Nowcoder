package com.xyx.nowcoder.tooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题：从上往下打印二叉树
 * 问题描述：
 * 			从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author huan
 * @date 2018年6月21日
 */
public class Solution22 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	/*
	 * 二叉树按层遍历
	 */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root != null)
        	queue.offer(root);
        
        while (!queue.isEmpty()) {
        	TreeNode cur = queue.poll();
        	if (cur.left != null)
        		queue.offer(cur.left);
        	if (cur.right != null)
        		queue.offer(cur.right);
        	result.add(cur.val);
        }
        return result;
    }

}
