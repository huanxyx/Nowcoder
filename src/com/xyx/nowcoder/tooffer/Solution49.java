package com.xyx.nowcoder.tooffer;

/**
 * 问题：把字符串转换成整数
 * 问题描述：
 * 			将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * @author huan
 * @date 2018年6月29日
 */
public class Solution49 {

    public int StrToInt(String str) {
    	//空指针判断，空字符串判断
    	if (str == null || str.length() == 0)
    		return 0;
    	
        char[] numStr = str.toCharArray();
        int cur = 0;
        int len = str.length();
        
        //去除空字符
        while (cur < len && numStr[cur] == ' ')
        	cur++;
        //正负号
        boolean positive = true;
        if (cur < len) {
        	if (numStr[cur] == '-') {
        		positive = false;
        		cur++;
        	}
        	else if (numStr[cur] == '+') {
        		positive = true;
        		cur++;
        	}
        }
        
        //转换值
        long num = 0;
        while (cur < len) {
        	if (numStr[cur] >= '0' && numStr[cur] <= '9') {
	        	num *= 10;
	        	num += numStr[cur] - '0';
	        	cur++;
        	} else 
        		//若是中间出现非法字符，则返回0
        		return 0;
        }
        
        num = positive ? num : -num;
        //判断是否溢出
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
        	return 0;
        return (int) num;
    }

}
