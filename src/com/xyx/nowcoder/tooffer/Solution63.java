package com.xyx.nowcoder.tooffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 问题：数据流中的中位数
 * 问题描述：
 * 				如何得到一个数据流中的中位数？如果从数据流中读出奇数个数
 * 				值，那么中位数就是所有数值排序之后位于中间的数值。
 * 				如果从数据流中读出偶数个数值，那么中位数就是所有数值
 * 				排序之后中间两个数的平均值。
 * @author huan
 * @date 2018年6月30日
 */
public class Solution63 {
	
	private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
 
    /*
     * 每次操作都保证了大根堆所有元素都小于小根堆的元素，
     * 保证了若是总量为奇数个，小根堆元素数目比大根堆大一（意味着小根堆最小的元素就是中位数）
     * 保证了若是总量为偶数个，小根堆和大根堆的元素数目相同
     */
    public void Insert(Integer num) {
        if (count % 2 == 0) {
            //1.当总数为偶数个时，新加入的元素，应该进入大根堆
            //然后经过大根堆筛选一个进入小根堆
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            //2.当总数为奇数个时，新加入的元素，应该进入小根堆
            //然后经过小根堆筛选一个进入大根堆
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        count++;
    }
     
    //获取中位数
    public Double GetMedian() {
        if (count % 2 == 0)
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        else
            return (double)minHeap.peek();
    }
}
