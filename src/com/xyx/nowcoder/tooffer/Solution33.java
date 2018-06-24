package com.xyx.nowcoder.tooffer;

/**
 * 问题：丑数
 * 问题描述：
 * 			把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 			例如6、8都是丑数，但14不是，因为它包含因子7。 
 * 			习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author huan
 * @date 2018年6月24日
 */
public class Solution33 {
	
	/*
	 * 假设需要求第M个丑数，那么这是丑数一定是在他之前的某个丑数*2或*3或*5
	 * 对于*2而言，第M个丑数之前肯定存在一个丑数k它前面的数*2都不大于第M个丑数，而k大于第M个丑数
	 * 同理*3和*4也是一样。这样我们就可以缩小遍历的范围
	 */
    public int GetUglyNumber_Solution(int index) {
        if (index < 1)
        	return 0;
        int[] uglyNumbers = new int[index];
        
        uglyNumbers[0] = 1;
        
        int pMultiply2 = 0;
        int pMultiply3 = 0;
        int pMultiply5 = 0;
        
        for (int i = 1; i < index; i++) {
        	uglyNumbers[i] = Math.min(
        			Math.min(uglyNumbers[pMultiply2] * 2, uglyNumbers[pMultiply3] * 3),
        			uglyNumbers[pMultiply5] * 5);
        	
        	//找到第一个*2或*3或*5大于第i个丑数的数的位置
        	while (uglyNumbers[pMultiply2] * 2 <= uglyNumbers[i])
        		pMultiply2++;
        	while (uglyNumbers[pMultiply3] * 3 <= uglyNumbers[i])
        		pMultiply3++;
        	while (uglyNumbers[pMultiply5] * 5 <= uglyNumbers[i])
        		pMultiply5++;
        }
        
        return uglyNumbers[index - 1];
    }

}
