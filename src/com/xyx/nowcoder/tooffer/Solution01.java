package com.xyx.nowcoder.tooffer;

/**
 * 题目：二维数组中的查找
 * 题目描述：
 * 		在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 		每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 		输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author huan
 * @date 2018年6月20日
 */
public class Solution01 {

    public boolean Find(int target, int [][] array) {
    	if (array == null || array.length == 0 
    			|| array[0] == null || array[0].length == 0)
    		return false;
        int row = array.length - 1;
        int col = 0;
        
        while (row >= 0 && col < array.length) {
        	if (target == array[row][col])
        		return true;
        	else if (target < array[row][col])
        		row--;
        	else 
        		col++;
        }
        return false;
    }

}
