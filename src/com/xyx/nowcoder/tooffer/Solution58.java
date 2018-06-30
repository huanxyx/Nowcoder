package com.xyx.nowcoder.tooffer;

/**
 * 问题：对称的二叉树
 * 问题描述：
 * 			请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 			注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author huan
 * @date 2018年6月30日
 */
public class Solution58 {

	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	/*
	 * 递归判断两棵树是否对称：
	 * 			当根节点相同时，
	 * 			判断第一棵树的左子树与第二颗树的右子树是否相等
	 * 			判断第一颗树的右子树与第二颗树的左子树是否相等
	 */
    boolean isSymmetrical(TreeNode pRoot) {
    	return treeEquals(pRoot, pRoot);
    }
    
    //判断两颗二叉树是否对称
    private boolean treeEquals(TreeNode root1, TreeNode root2) {
    	if (root1 == null && root2 == null)
    		return true;
    	if (root1 == null || root2 == null)
    		return false;
    	if (root1.val != root2.val)
    		return false;
    	//剩下的情况就是val1 == val2
    	//只需要比较左子树是否相等，右子树是否相等
    	return treeEquals(root1.left, root2.right) && 
    			treeEquals(root1.right, root2.left);
    }


}
