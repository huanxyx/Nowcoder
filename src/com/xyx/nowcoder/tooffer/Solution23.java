package com.xyx.nowcoder.tooffer;

/**
 * 问题：二叉搜索树的后序遍历序列
 * 问题描述：
 * 				输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 				如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author huan
 * @date 2018年6月21日
 */
public class Solution23 {

	/*
	 * 序列的最后一个元素是根节点，根节点将除开根节点的序列分成了两部分，一个是大于根节点的，一个是小于根节点的
	 */
    public boolean VerifySquenceOfBST(int [] sequence) {
    	if (sequence == null || sequence.length == 0)
    		return false;
    	return recursVerify(sequence, 0, sequence.length - 1);
    }
    
    private boolean recursVerify(int[] sequence, int start, int end) {
    	if (start >= end)
    		return true;
    	
    	int rootNum = sequence[end];
    	//找到左子树后序遍历序列的部分
    	int i = start;
    	for (; i < end; i++) {
    		if (sequence[i] > rootNum)
    			break;
    	}
    	//找到右子树后序遍历序列的部分，右子树后序遍历的结果后面不是根节点，那么则不能构成搜索二叉树
    	int j = i;
    	for (; j < end; j++) {
    		if (sequence[j] < rootNum)
    			return false;
    	}
   	
    	return recursVerify(sequence, start, i - 1) && recursVerify(sequence, i, j - 1);
    }

}
