package com.xyx.nowcoder.tooffer;

/**
 * 问题：平衡二叉树
 * 问题描述：
 * 				输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author huan
 * @date 2018年6月25日
 */
public class Solution39 {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}

	/*
	 * 递归
	 */
    public boolean IsBalanced_Solution(TreeNode root) {
        return balancedTreeDepth(root) != -1;
    }
    
    //判断一棵树是否为平衡二叉树，若是则返回该树的深度，若不是则返回-1
    public int balancedTreeDepth(TreeNode root) {
    	if (root == null)
    		return 0;
    	
    	int left = balancedTreeDepth(root.left);
    	if (left == -1)
    		return -1;
    	int right = balancedTreeDepth(root.right);
    	if (right == -1)
    		return -1;
    	if (Math.abs(left - right) < 2)
    		return Math.max(left, right) + 1;
    	return -1;
    }

}
