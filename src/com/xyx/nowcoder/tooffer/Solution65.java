package com.xyx.nowcoder.tooffer;

/**
 * 问题：矩阵中的路径
 * 问题描述：
 * 				请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字
 * 				符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 				每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 				如果一条路径经过了矩阵中的某一个格子，则之后不能再次进
 * 				入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩
 * 				阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 				因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * @author huan
 * @date 2018年6月30日
 */
public class Solution65 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
    	if (matrix == null || str == null || str.length == 0 || str.length > (rows * cols))
    		return false;
    	
    	boolean[] hasTraverse = new boolean[matrix.length];
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
    			if (hasPath(matrix, rows, cols, str, i, j, 0, hasTraverse)) 
    				return true;
    		}
    	}
    	return false;
    }
    
    /*
     * 回溯法
     */
    private boolean hasPath(char[] matrix, int rows, int cols, char[] str,
    						int curRow, int curCol, int curChIndex, boolean[] hasTraverse) {
    	if (curChIndex == str.length)
    		return true;
    	if (curRow < 0 || curRow >= rows)
    		return false;
    	if (curCol < 0 || curCol >= cols)
    		return false;
    	if (matrix[translate2To1(curRow, curCol, rows, cols)] != str[curChIndex])
    		return false;
    	if (hasTraverse[translate2To1(curRow, curCol, rows, cols)])
    		return false;
    	
    	hasTraverse[translate2To1(curRow, curCol, rows, cols)] = true;
    	curChIndex++;
    	boolean result = 
    				hasPath(matrix, rows, cols, str, curRow+1, curCol, curChIndex, hasTraverse) || 
    				hasPath(matrix, rows, cols, str, curRow-1, curCol, curChIndex, hasTraverse) ||
    				hasPath(matrix, rows, cols, str, curRow, curCol+1, curChIndex, hasTraverse) ||
    				hasPath(matrix, rows, cols, str, curRow, curCol-1, curChIndex, hasTraverse);
    	curChIndex--;
    	hasTraverse[translate2To1(curRow, curCol, rows, cols)] = false;
    	
    	return result;
    }
    
    //将二维坐标转换为一维坐标
    private int translate2To1(int curRow, int curCol, int rows, int cols) {
    	return curRow * cols + curCol;
    }

}
