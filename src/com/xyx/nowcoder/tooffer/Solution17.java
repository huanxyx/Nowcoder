package com.xyx.nowcoder.tooffer;

/**
 * 问题：树的子结构
 * 问题描述：
 * 			输入两棵二叉树A，B，判断B是不是A的子结构。
 * 			（ps：我们约定空树不是任意一个树的子结构）
 * @author huan
 * @date 2018年6月21日
 */
public class Solution17 {
	
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	/*
	 * 鲁棒性：使用引用前需要考虑是否为空
	 * root2可以构成root1的子结构，意味着root2与root1某个子树的上面的部分相同
	 */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	return recursHasSubTree(root1, root2);
    }
    
    /*
     * 先判断以root1为根的树和以root2为根的树是否完全相同，
     * 若是不相同再判断子树
     */
    private boolean recursHasSubTree(TreeNode root1, TreeNode root2) {
    	//只要有一个为空，则返回false
    	if (root1 == null || root2 == null) 
    		return false;
    	
    	//判断以root1为根和以root2为根的树是否构成子结构
    	if (recursEqual(root1, root2)) 
    		return true;
    	else 
    		//不构成的话则判断root1的子树
    		return recursHasSubTree(root1.left, root2) || recursEqual(root1.right, root2);
    }
    
    private boolean recursEqual(TreeNode root1, TreeNode root2) {
    	if (root2 == null)
    		return true;
    	if (root1 == null)
    		return false;
    	if (root1.val != root2.val)
    		return false;
    	return recursEqual(root1.left, root2.left) && recursEqual(root1.right, root2.right);
    }
	
}
