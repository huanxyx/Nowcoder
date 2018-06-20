package com.xyx.nowcoder.tooffer;

/**
 * 问题：变态跳台阶
 * 问题描述：		
 * 			一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 			求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author huan
 * @date 2018年6月20日
 */
public class Solution09 {
	
	/*
	 * 因为能够随便跳，所以使用dp[i]表示跳到第i阶不同跳法的个数，dp[i + 1] = dp[0] + dp[1] + dp[2] .. + dp[i]
	 */
    public int JumpFloorII(int target) {
    	if (target < 3)
    		return target;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= target; i++) {
        	int sum = 0;
        	for (int j = 0; j < i; j++)
        		sum += dp[j];
        	dp[i] = sum;
        }
        return dp[target];
    }

}
