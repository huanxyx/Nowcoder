package com.xyx.nowcoder.tooffer;

import java.util.Stack;

/**
 * 问题：包含min函数的栈
 * 问题描述：
 * 			定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * @author huan
 * @date 2018年6月21日
 */
public class Solution20 {
	
	/*
	 * 借助辅助栈存储数据栈中的最小值
	 */
	private Stack<Integer> dataStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        if (dataStack.isEmpty()) 
        	minStack.push(node);
        else {
        	if (minStack.peek() > node)
        		minStack.push(node);
        	else
        		minStack.push(minStack.peek());
        }
    	dataStack.push(node);	
    }
    
    public void pop() {
    	minStack.pop();
        dataStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
