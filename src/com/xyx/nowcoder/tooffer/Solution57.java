package com.xyx.nowcoder.tooffer;

/**
 * 问题：二叉树的下一个结点
 * 问题描述：
 * 				给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一
 * 				个结点并且返回。注意，树中的结点不仅包含左右子结
 * 				点，同时包含指向父结点的指针。
 * @author huan
 * @date 2018年6月30日
 */
public class Solution57 {

	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
        	return null;
        if (pNode.right != null)
        	return getFirstNode(pNode.right);
        else 
        	return getLeftChild(pNode);	
    }
    
    //往上找到第一个满足为父结点的左儿子的结点的父节点。
    private TreeLinkNode getLeftChild(TreeLinkNode root) {
    	while (root.next != null && root.next.right == root)
    		root = root.next;
    	return root.next;
    }
    
    //找到一棵树最左边的结点
    private TreeLinkNode getFirstNode(TreeLinkNode root) {
    	while (root.left != null)
    		root = root.left;
    	return root;
    }
    
    

}
