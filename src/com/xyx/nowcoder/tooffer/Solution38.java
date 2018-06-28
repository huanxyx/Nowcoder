package com.xyx.nowcoder.tooffer;

/**
 * 问题：二叉树的深度
 * 问题描述：	
 * 			输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 * 			（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author huan
 * @date 2018年6月25日
 */
public class Solution38 {
	
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
    public int TreeDepth(TreeNode root) {
        return recursTreeDepth(root);
    }
    
    public int recursTreeDepth(TreeNode root) {
    	if (root == null)
    		return 0;
    	return Math.max(recursTreeDepth(root.left), recursTreeDepth(root.right)) + 1; 
    }

}
