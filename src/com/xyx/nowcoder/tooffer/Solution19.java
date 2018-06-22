package com.xyx.nowcoder.tooffer;

import java.util.ArrayList;

/**
 * 问题：顺时针打印矩阵
 * 问题描述：
 * 			输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 			例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则
 * 			依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author huan
 * @date 2018年6月21日
 */
public class Solution19 {
	
	/*
	 * 用例：多行多列，一行，一列，一行一列
	 */
    public ArrayList<Integer> printMatrix(int [][] matrix) {  
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	int x1 = 0;
    	int y1 = 0;
    	int x2 = matrix.length - 1;
    	int y2 = matrix[0].length - 1;
    	while (x1 <= x2 && y1 <= y2) {
    		traverseBorder(matrix, x1++, y1++, x2--, y2--, result);
    	}
    	return result;
    }
    
    /*
     * (x1,y1)和(x2,y2)表示边框的左上角坐标和右下角坐标
     */
    public void traverseBorder(int[][] matrix, int x1, int y1, int x2, int y2, ArrayList<Integer> result) {

    	if (x1 == x2) {
        	//一行
    		while (y1 <= y2) {
    			result.add(matrix[x1][y1++]);
    		}
    	} else if (y1 == y2) {
    		//一列
    		while (x1 <= x2) { 
    			result.add(matrix[x1++][y1]);
    		}
    	} else {
    		int x = x1;
    		int y = y1;    		
    		while (y < y2) 
    			result.add(matrix[x][y++]);
    		while (x < x2)
    			result.add(matrix[x++][y]);
    		while (y > y1)
    			result.add(matrix[x][y--]);
    		while (x > x1)
    			result.add(matrix[x--][y]);
    	}
    }

}
