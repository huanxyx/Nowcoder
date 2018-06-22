package com.xyx.nowcoder.tooffer;

import java.util.Stack;

/**
 * 问题：栈的压入、弹出序列
 * 问题描述：
 * 			输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 			假设压入栈的所有数字均不相等。
 * 			例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 			但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author huan
 * @date 2018年6月21日
 */
public class Solution21 {

	/*
	 * 模拟求解：
	 * 		如果下一个弹出的数字正好时栈顶数字，那么直接弹出，如果
	 * 		下一个弹出的数字不在栈顶，则把压栈序列中没有入栈的数字压入栈中，
	 * 		直到把下一个需要从栈中弹出的元素压入栈中位置。
	 * 		如果所有数字都压入栈中后依然没有找到下一个弹出的数字，那么该序列不可能是
	 * 		一个弹出序列。
	 */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int aP = 0;
        int bP = 0;
        
        //将压栈序列中的数压入栈中，直到压栈序列遍历完了
        while (aP < pushA.length) {
        	if (stack.isEmpty())
        		stack.push(pushA[aP++]);
        	else {
        		if (stack.peek() == popA[bP]) {
        			stack.pop();
        			bP++;
        		} else {
        			stack.push(pushA[aP++]);
        		}
        	}
        }
        
        //当所有的元素都压入栈中后，然后看看弹出序列能否将栈中的元素清空
        while (!stack.isEmpty() && stack.peek() == popA[bP]) {
        	stack.pop();
        	bP++;
        }
        
        return stack.isEmpty();
    }
}
