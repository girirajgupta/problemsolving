package com.test;

public class MinAvgSlice {

	public static void main(String[] args) {
		int A[] = {4, 2, 2, 5, 1, 5, 8};
		System.out.println(solution(A));

	}
	
	public static double solution(int[] A) {
		if(A.length == 2) {
			return 0;
		}
		
		double previousAvg = (A[0] + A[1])/2;
		double minAvg = previousAvg;
		int  minIndex = 0;
		for(int i=2; i < A.length; i++) {
			double avgOfThree = (A[i-2] + A[i-1] + A[i])/3.0;
			double avgOfTwo = (A[i-1] + A[i])/2.0;
			if(avgOfTwo < avgOfThree) {
				if(avgOfTwo < minAvg) {
					minIndex = i-1;
				}
			} else {
				if(avgOfThree < minAvg) {
					minIndex = i-2;
				}
			}
			minAvg = Math.min(Math.min(avgOfTwo, avgOfThree), minAvg);
		}
		
		return minIndex;
	}

}
