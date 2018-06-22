package com.xyx.nowcoder.tooffer;

import java.util.ArrayList;

/**
 * 问题：二叉树中和为某一值得路径
 * 问题描述：
 * 			输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 			路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author huan
 * @date 2018年6月21日
 */
public class Solution24 {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	
    	recursFindPath(root, target, result, path);
        return result;
    }
    
    
    /*
     * 每访问一个节点，则将他添加到路径中去，回到上层路径则需要将添加到路径中的节点删除
     */
    private void recursFindPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
    	if (root == null)
    		return ;
    	//当前节点为页节点的时候
        if (root.left == null && root.right == null) {
        	//构成一条路径的时候
        	if (target == root.val) {
        		ArrayList<Integer> successPath = new ArrayList<Integer>(path);
        		successPath.add(root.val);
        		result.add(successPath);
        	}
        	return ;
        } else {
        	//添加当前节点到路径上
        	path.add(root.val);
        	recursFindPath(root.left, target - root.val, result, path);
        	recursFindPath(root.right, target - root.val, result, path);
        	//返回到父节之前，删除在路径上的当前节点
        	path.remove(path.size() - 1);
        }
    }

}
