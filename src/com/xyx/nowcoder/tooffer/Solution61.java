package com.xyx.nowcoder.tooffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题：序列化二叉树 问题描述： 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 * @author huan
 * @date 2018年6月30日
 */
public class Solution61 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
	
	private static final String NULL = "!";
	private static final String SPLIT = "#";

	//按层序列化
	String Serialize(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		StringBuilder buffer = new StringBuilder();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				buffer.append(NULL + SPLIT);
			} else {
				buffer.append(cur.val + SPLIT);
				queue.offer(cur.left);
				queue.offer(cur.right);
			}
		}
		return buffer.toString();
	}

	//按层反序列化
	TreeNode Deserialize(String str) {
		String[] values = str.split(SPLIT);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		TreeNode root = parseStr(values[0]);
		if (root == null)
			return null;
		queue.offer(root);
		int cur = 1; 
		while (!queue.isEmpty()) {
			TreeNode troot = queue.poll();
			if (troot != null) {
				troot.left = parseStr(values[cur++]);
				troot.right = parseStr(values[cur++]);
				queue.offer(troot.left);
				queue.offer(troot.right);
			}
		}
		return root;
	}
	
	//解析
	private TreeNode parseStr(String val) {
		if (NULL.equals(val))
			return null;
		else 
			return new TreeNode(Integer.parseInt(val));
	}

}
