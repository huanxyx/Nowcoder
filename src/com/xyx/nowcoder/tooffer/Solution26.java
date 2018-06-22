package com.xyx.nowcoder.tooffer;

/**
 * 问题：二叉搜索树与双向链表
 * 问题描述：
 * 			输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双
 * 			向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author huan
 * @date 2018年6月21日
 */
public class Solution26 {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
    public TreeNode Convert(TreeNode pRootOfTree) {
        return main1(pRootOfTree);
    }
    
    //解法一：递归函数返回两个信息
    public TreeNode main1(TreeNode pRootOfTree) {
		return recursConvert1(pRootOfTree).head;
	}
    

    //解法二：通过一个全局变量记住中序遍历过结点的最后一个
    private TreeNode lastNode;
    public TreeNode main2(TreeNode pRootOfTree) {
    	if (pRootOfTree == null)
    		return null;
    	lastNode = null;
    	recursConvert2(pRootOfTree);
    	
    	while (lastNode.left != null)
    		lastNode = lastNode.left;
    	return lastNode;
    }
    
    /*
     * 保存子树生成的双向链表的首结点和尾结点
     */
    private Record recursConvert1(TreeNode root) {
    	if (root == null)
    		return new Record(null, null);
    	
    	TreeNode head = root;
    	TreeNode end = root;
    	if (root.left != null) {
    		Record record = recursConvert1(root.left);
        	head = record.head;
        	record.end.right = root;
        	root.left = record.end;
    	}
    	if (root.right != null) {
    		Record record = recursConvert1(root.right);
    		end = record.end;
    		record.head.left = root;
    		root.right = record.head;
    	}
    	return new Record(head, end);
    }
    
    //记录着当前二叉树树转换成双向链表的头和尾
    public static class Record {
    	TreeNode head;
    	TreeNode end;
    	public Record(TreeNode head, TreeNode end) {
    		this.head = head;
    		this.end = end;
    	}
    }
    
    private void recursConvert2(TreeNode root) {
    	if (root == null)
    		return ;
    	if (root.left != null) {
    		recursConvert2(root.left);
    	}
    	if (lastNode != null) {
    		lastNode.right = root;
    		root.left = lastNode;
    	}
    	lastNode = root;
    	if (root.right != null) {
    		recursConvert2(root.right);
    	}
    }
    

}
