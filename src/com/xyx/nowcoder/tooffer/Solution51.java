package com.xyx.nowcoder.tooffer;

/**
 * 问题：构建乘积数组
 * 问题描述：
 * 			给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其
 * 			中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @author huan
 * @date 2018年6月29日
 */
public class Solution51 {

	/*
	 * 构造两个数组：
	 * 				C[i]存储着A[0]...A[i-1]
	 * 				D[i]存储着A[i+1]...A[last]
	 */
	public int[] multiply(int[] A) {
		if (A == null || A.length == 0)
			return new int[0];
		
		int[] C = new int[A.length];
		int[] D = new int[A.length];
		
		//初始化C
		C[0] = 1;
		for (int i = 1; i < C.length; i++) 
			C[i] = C[i-1] * A[i-1];
		//初始化D
		D[D.length - 1] = 1;
		for (int i = D.length-2; i >= 0; i--) 
			D[i] = D[i+1] * A[i+1];
		
		int[] B = new int[A.length];
		for (int i = 0; i < B.length; i++) 
			B[i] = C[i] * D[i];
		return B;
	}

}
