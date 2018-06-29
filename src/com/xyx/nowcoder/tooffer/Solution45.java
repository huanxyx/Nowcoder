package com.xyx.nowcoder.tooffer;

import java.util.Arrays;

/**
 * 问题：扑克牌顺子
 * 问题描述：
 * 			LL今天心情特别好,因为他去买了一副扑克牌,发现
 * 			里面居然有2个大王,2个小王(一副牌原本是54
 * 			张^_^)...他随机从中抽出了5张牌,想测测自己
 * 			的手气,看看能不能抽到顺子,如果抽到的话,他
 * 			决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小
 * 			王,大王,方片5”,“Oh My God!”不是顺子.....
 * 			LL不高兴了,他想了想,决定大\小 王可以看成任何
 * 			数字,并且A看作1,J为11,Q为12,K为13。上面的5
 * 			张牌就可以变成“1,2,3,4,5”(大小王分别看作2和
 * 			4),“So Lucky!”。LL决定去买体育彩票啦。 现在
 * 			,要求你使用这幅牌模拟上面的过程,然后告诉我们
 * 			LL的运气如何。为了方便起见,你可以认为大小王是0。
 * @author huan
 * @date 2018年6月28日
 */
public class Solution45 {

	/*
	 * 通过排序，再统计大小王个数和空缺的数量
	 * 也可以通过哈希表存储每种牌出现的次数实现，避免排序
	 */
    public boolean isContinuous(int [] numbers) {
    	if (numbers == null || numbers.length != 5)
    		return false;
    	
    	Arrays.sort(numbers);
    	
    	//统计大王小王的个数
    	int zeroNum = 0;
    	while (numbers[zeroNum] == 0) 
    		zeroNum++;
    	
    	//统计空缺总数
    	int gapNum = 0;
    	int left = zeroNum;
    	int right = zeroNum + 1;
    	while (right < numbers.length) {
    		if (numbers[left] == numbers[right])
    			return false;
    		gapNum += numbers[right] - numbers[left] - 1;
    		left++;
    		right++;
    	}
    	//若是空缺数目大于大小王个数，则返回false
    	return (gapNum > zeroNum) ? false : true;
    }
}
