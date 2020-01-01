package com.test;

import java.util.Arrays;

public class Triagnle {

	public static void main(String[] args) {
		int[] A = {Integer.MAX_VALUE, Integer.MAX_VALUE-1, Integer.MAX_VALUE-2};
		System.out.println(solution(A));

	}
	
	public static int solution(int[] A) {
		Arrays.sort(A);
		for(int i=0; i< A.length-2; i++) {
			long sum1 = Long.valueOf(A[i]) + Long.valueOf(A[i+1]);
			long sum2 = Long.valueOf(A[i+1]) + Long.valueOf(A[i+2]);
			long sum3 = Long.valueOf(A[i]) + Long.valueOf(A[i+2]);
			if( (sum1 > A[i+2]) && (sum2 > A[i]) && (sum3 > A[i+1])) {
				//System.out.println(A[i] + "," + A[i+1] + "," + A[i+2]);
				return 1;
			}
		}
		return 0;
	}

}
