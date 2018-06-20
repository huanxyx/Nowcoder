package com.xyx.nowcoder.tooffer;

import java.util.Stack;

/**
 * 问题：用两个栈实现队列
 * 问题描述：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author huan
 * @date 2018年6月20日
 */
public class Solution05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    /*
     * 新进入就放到stack1中
     */
    public void push(int node) {
        stack1.push(node);
    }
    
    /*
     * 弹出就从stack2拿，若是stack2为空，则进行pour操作
     */
    public int pop() {
    	if (stack2.isEmpty()) 
    		pour();
    	return stack2.pop();
    }
    
    private void pour() {
    	while (!stack1.isEmpty()) 
    		stack2.push(stack1.pop());
    }
    

}
