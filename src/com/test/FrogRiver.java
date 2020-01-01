package com.test;

public class FrogRiver {

	public static void main(String[] args) {
		int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
		System.out.println(solution(5, A));

	}
	
	static int solution(int X, int[] A) {
		long expectedSum = X*(X+1)/2;
		long runningSum = 0;
		int[] visited = new int[X+1];
		for(int i=0; i< A.length; i++)  {
			if(visited[A[i]] == 0) {
				runningSum += A[i];
				visited[A[i]] = 1;
			}
			if(runningSum == expectedSum) {
				return i;
			}
		}
		return 0;
	}

}
