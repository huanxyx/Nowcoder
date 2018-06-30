package com.xyx.nowcoder.tooffer;

/**
 * 问题：表示数值的字符串
 * 问题描述：
 * 			请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 			例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表
 * 			示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author huan
 * @date 2018年6月30日
 */
public class Solution53 {

	private int index;
	/*
	 * 注意：index别超出数组范围
	 */
    public boolean isNumeric(char[] str) {
        if (str == null)
        	return false;
        
        index = 0;
        boolean isNumber = scanInteger(str);
        
        //若是出现了.，则表示小数部分
        if (index < str.length && str[index] == '.') {
        	index++;
        	
        	/*
        	 * 使用||的原因：
        	 * 1.小数可以没有整数部分.123
        	 * 2.小数点后面可以没有数字2312.
        	 * 3.小数点前候都可以由数字
        	 */
        	isNumber = scanUnsignedInteger(str) || isNumber;
        }
        //若是出现了E或者e，则表示指数部分
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
        	index++;
        	
        	/*
        	 * 使用&&的原因：
        	 * 1.当e或E前面有没有数字时，不能表示数字，如.e1,e1
        	 * 2.当e或E后面没有整数时，不能表示数字，如12e
        	 */
        	isNumber = isNumber && scanInteger(str);
        }
        
        return isNumber && index == str.length;
    }
    
    //扫描有符号的数
    private boolean scanInteger(char[] str) {
    	if (index < str.length && 
    			(str[index] == '-' || str[index] == '+'))
    		index++;
    		
    	return scanUnsignedInteger(str);
    }
    
    
    //扫描没有符号的数：返回false白哦是没有扫描到数
    private boolean scanUnsignedInteger(char[] str) {
    	int before = index;
    	while (index < str.length && str[index] <= '9' && str[index] >= '0')
    		index++;
    	return index > before;
    }

}
