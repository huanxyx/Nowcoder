package com.xyx.nowcoder.tooffer;

/**
 * 问题：整数中1出现的次数（从1到n整数中1出现的次数）
 * 问题描述：
 * 			求出1~13的整数中1出现的次数,并算出
 * 			100~1300的整数中1出现的次数？为此他
 * 			特别数了一下1~13中包含1的数字有1、10、11、12、13因
 * 			此共出现6次,但是对于后面问题他就没辙了。
 * 			ACMer希望你们帮帮他,并把问题更加普遍化,可
 * 			以很快的求出任意非负整数区间中1出现的次数。
 * @author huan
 * @date 2018年6月24日
 */
public class Solution31 {

    public int NumberOf1Between1AndN_Solution(int n) {
        return numberOf1Recurs(n);
    }
    
    /*
     * 将1-2231所有数分为两个部分：（232-2231）（1-231）
     * （232-2231）：先计算当最高位为1的数的数量，再计算倒数第二位为1的数的数目，....
     * （1-231）：（递归求solution(231)）
     */
    public int numberOf1Recurs(int n) {
    	//终止条件：只有一位数
    	if (n == 0)
    		return 0;
    	if (n < 10)
    		return 1;
    	
    	//有多位数：先转换为字符数组
    	char[] numStr = getCharArrOfNum(n);
    	int first = numStr[0] - '0';
    	
    	//由最高位为1导致而产生的1的数量
    	int highNum = 0;
    	//由最高位和其他低位产生的1的数量
    	int lowNum = 0;
    	//由剩下的低位数产生的1的数量
    	int residueNum = 0;
    	
    	//若是n = 21345，10000-19999：中计算最高位1的个数为10000个
    	//若是n = 12345，10000-12345：中计算最高位1的个数位2346个
    	if (first > 1) {
    		highNum = powerOf10(numStr.length - 1);
    	} else if (first == 1) {
    		highNum = n - powerOf10(numStr.length - 1) + 1;
    	}
    	
    	//若是n = 21945，1946-21945中一共20000个数：不考虑最高位，只考虑低4位
    	//0-9999有10^3 * 4个1：控制四位中的任意1位为1，其他位的组合情况有10^3
    	//有0-9999，两遍。
    	lowNum = powerOf10(numStr.length - 2) * (numStr.length - 1) * first;
    	
    	//若是n = 23145，则只剩下1-3145没有计算了
    	residueNum = numberOf1Recurs(n - powerOf10(numStr.length - 1) * first);
    	
    	
    	return highNum + lowNum + residueNum;
    }
    
    private char[] getCharArrOfNum(int n) {
    	return (n + "").toCharArray();
    }
    
    //10的n次方
    private int powerOf10(int n) {
    	int sum = 1;
    	for (int i = 0; i < n; i++) {
    		sum *= 10;
    	}
    	return sum;
    }
    
    public static void main(String[] args) {
		new Solution31().NumberOf1Between1AndN_Solution(10);
	}
}
