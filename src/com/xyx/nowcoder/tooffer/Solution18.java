package com.xyx.nowcoder.tooffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题：二叉树的镜像
 * 问题描述：操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author huan
 * @date 2018年6月21日
 */
public class Solution18 {
	
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
    public void Mirror(TreeNode root) {
    	noRecursMirror(root);
    }
    
    /*
     * 非递归实现：利用队列
     */
    private void noRecursMirror(TreeNode root) {
    	if (root == null)
    		return ;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	
    	while (!queue.isEmpty()) {
    		TreeNode cur = queue.poll();
    		swapLeftAndRight(cur);
    		if (cur.left != null)
    			queue.offer(cur.left);
    		if (cur.right != null)
    			queue.offer(cur.right);
    	}
    }
    
    private void swapLeftAndRight(TreeNode node) {
    	if (node == null)
    		return ;
    	TreeNode tmp = node.left;
    	node.left = node.right;
    	node.right = tmp;
    }
    
    /*
     * 递归实现
     */
    private void recursMirror(TreeNode root) {
        if (root == null)
        	return ;
        Mirror(root.right);
        Mirror(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

}
