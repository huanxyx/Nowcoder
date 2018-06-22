package com.xyx.nowcoder.tooffer;

/**
 * 问题：数值的整数次方
 * 问题描述：（程序的完整性）
 * 			给定一个double类型的浮点数base和int类型的整数exponent。
 * 			求base的exponent次方。
 * @author huan
 * @date 2018年6月21日
 */
public class Solution12 {

    public double Power(double base, int exponent) {
    	//处理特殊情况：底数为0，而指数小于0，因为0不能作为分母
    	if (equal(base, 0.0) && exponent < 0) {
    		throw new IllegalArgumentException("底数为0的情况下，指数不能为负数");
    	}
    	double result = positiveExpPower(base, Math.abs(exponent));
    	if (exponent < 0)
    		result = 1.0 / result;
    	return result;
    } 
    
    private boolean equal(double a, double b) {
    	return Math.abs(a - b) < 0.000001;
    }
    
    /*
     * 快速乘方:
     * 		偶次方：a^k = a^(k/2) * a^(k/2)
	 *		奇次方：a^k = a^(k-1/2) * a^(k-1/2) * a
     */
    private double positiveExpPower(double base, int positiveExp) {
    	if (positiveExp == 0)
    		return 1.0;
    	if (positiveExp == 1)
    		return base;
    	
    	double result = positiveExpPower(base, positiveExp >> 1);
    	result *= result;
    	if ((positiveExp & 1) == 1)
    		result *= base;
    	return result;
    }

}
