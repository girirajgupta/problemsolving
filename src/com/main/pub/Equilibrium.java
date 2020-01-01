package com.main.pub;

public class Equilibrium {

	public static void main(String[] args) {
		int A[] = {3, 1, 2, 4, 3};
		System.out.println(solution(A));

	}
	
	static int solution(int[] A) {
		if(A.length == 2) {
			return Math.abs(A[0] - A[1]);
		}
		int[] sumLR = new int[A.length];
		int[] sumRL = new int[A.length];
		
		sumLR[0] = A[0];
		for(int i=1; i< A.length; i++) {
			sumLR[i] = sumLR[i-1] + A[i];
		}
		
		sumRL[A.length-1] = A[A.length-1];
		for(int i=A.length-2; i>=0; i--) {
			sumRL[i] = sumRL[i+1] + A[i];
		}
		
		int minSum = Integer.MAX_VALUE;
		for(int i=0; i<A.length-2; i++) {
			int diff = Math.abs(sumLR[i] - sumRL[i+1]);
			if(diff < minSum) {
				minSum = diff;
			}
		}
		
		return minSum;
	}

}
