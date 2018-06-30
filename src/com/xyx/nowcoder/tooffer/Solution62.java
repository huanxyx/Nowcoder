package com.xyx.nowcoder.tooffer;

/**
 * 问题：二叉搜索树的第k个结点 问题描述： 给定一颗二叉搜索树，请找出其中的第k小的结点。 例如， 5 / \ 3 7 /\ /\ 2 4 6 8
 * 中，按结点数值大小顺序第三个结点的值为4。
 * 
 * @author huan
 * @date 2018年6月30日
 */
public class Solution62 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	/*
	 * 中序遍历
	 */
	int count;								//设置一个全局变量
	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k == 0)
			return null;
		count = k;
		return kthNode(pRoot);
	}
	
	/*
	 * 当遍历到第k个结点的时候（count=0），直接返回，不用遍历其他的结点了
	 */
	private TreeNode kthNode(TreeNode root) {
		if (root == null)
			return null;
		
		TreeNode left = kthNode(root.left);
		if (count == 0)
			return left;
		
		count--;
		if (count == 0)
			return root;
		
		TreeNode right = kthNode(root.right);
		if (count == 0)
			return right;
		return null;
	}
}
