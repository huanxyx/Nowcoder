package com.xyx.nowcoder.tooffer;

/**
 * 问题：机器人的运动范围
 * 问题描述：
 * 				地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移
 * 				动，每一次只能向左，右，上，下四个方向移动一格，但是不能进
 * 				入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机
 * 				器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能
 * 				进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 * @author huan
 * @date 2018年6月30日
 */
public class Solution66 {

	/*
	 * 回溯
	 */
    public int movingCount(int threshold, int rows, int cols) {
    	if (threshold < 0 || rows <= 0 || cols <= 0)
    		return 0;
    	
        boolean[][] visited = new boolean[rows][cols];
        
        return move(threshold, rows, cols, 0, 0, visited);
    }
    
    //移动到新的位置
    private int move(int threshold, int rows, int cols, int curRow, int curCol, boolean[][] visited) {
    	if (curRow < 0 || curRow >= rows)
    		return 0;
    	if (curCol < 0 || curCol >= cols)
    		return 0;
    	if (visited[curRow][curCol])
    		return 0;
    	if (getDigitSum(curRow) + getDigitSum(curCol) > threshold)
    		return 0;
    	
    	visited[curRow][curCol] = true;
    	return 1 + 
    			move(threshold, rows, cols, curRow+1, curCol, visited) +
    			move(threshold, rows, cols, curRow-1, curCol, visited) +
    			move(threshold, rows, cols, curRow, curCol+1, visited) +
    			move(threshold, rows, cols, curRow, curCol-1, visited);
    }
    
    //计算坐标的数位之和
    private int getDigitSum(int number) {
    	int sum = 0;
    	while (number != 0) {
    		sum += number % 10;
    		number /= 10;
    	}
    	return sum;
    }

}
