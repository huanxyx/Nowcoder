package com.xyx.nowcoder.tooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题：把二叉树打印成多行
 * 问题描述：
 * 			从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @author huan
 * @date 2018年6月30日
 */
public class Solution60 {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	/*
	 * 使用一个队列按层输出：
	 * 			开始遍历每一层的时候，记录该层有多少个结点
	 */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null)
        	return result;
        
        queue.offer(pRoot);
        
        while (!queue.isEmpty()) {
        	int count = queue.size();
        	ArrayList<Integer> item = new ArrayList<Integer>();
        	for (int i = 0; i < count; i++) {
        		TreeNode cur = queue.poll();
        		item.add(cur.val);
        		if (cur.left != null)
        			queue.offer(cur.left);
        		if (cur.right != null)
        			queue.offer(cur.right);
        	}
        	result.add(item);
        }
        
        return result;
    }

}
