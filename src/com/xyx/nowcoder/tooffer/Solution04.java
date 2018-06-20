package com.xyx.nowcoder.tooffer;

/**
 * 问题：重建二叉树
 * 问题描述：
 * 		输入某二叉树的前序遍历和中序遍历的结果，
 * 		请重建出该二叉树。假设输入的前序遍历和中序遍
 * 		历的结果中都不含重复的数字。例如输入前序遍历序
 * 		列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 		则重建二叉树并返回。
 * @author huan
 * @date 2018年6月20日
 */
public class Solution04 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * 可以从先序遍历中获取根节点（第一个），然后再中序遍历中找到根节点的位置，
	 * 就可以将树分成左子树中序遍历的部分，和右子树中序遍历的部分。
	 * 最后将将先序遍历分割成左子树的先序遍历结果和右子树先序遍历的结果。
	 * 每次递归就可以获取一个根节点，左子树和右子树各自的先序遍历和中序遍历的结果
	 */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length != in.length)
            return null;
        return reConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    
    //递归构造二叉树（先序遍历和中序遍历结果）
    private TreeNode reConstruct(int[] pre, int pStart, int pEnd, int[] in, int iStart, int iEnd) {
        if (pStart > pEnd)
            return null;
        int rootNum = pre[pStart];
        int index = 0;
        //找到中序遍历的分割位置
        for (int i = iStart; i <= iEnd; i++) {
            if (in[i] == rootNum) {
                index = i;
                break;
            }
        }
        int leftLen = index - iStart;        //左子树的节点的数目
        TreeNode curRoot = new TreeNode(rootNum);
        curRoot.left = reConstruct(pre, pStart + 1, pStart + leftLen, in, iStart, index - 1);
        curRoot.right = reConstruct(pre, pStart + 1 + leftLen, pEnd, in, index + 1, iEnd);
        return curRoot;
    }

}
