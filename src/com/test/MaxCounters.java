package com.test;

public class MaxCounters {

	public static void main(String[] args) {
		int A[] = {3, 4, 4, 6, 1, 4, 4};
		for (int i : solution(5, A)) {
			System.out.println(i);
		};
	}
	
	static int[] solution(int N, int[] A) {
		int maxCounter = 0;
		int[] result = new int[N];
		for(int i=0; i < A.length; i++) {
			if(A[i] > N) {
				updateAllWithMax(result, maxCounter);
			} else {
				int currentValue = result[A[i]-1];
				result[A[i]-1] = currentValue + 1;
				if(maxCounter < currentValue + 1) {
					maxCounter = currentValue + 1;
				}
			}
		}
		
		return result;
	}

	private static void updateAllWithMax(int[] a, int maxCounter) {
		for (int i=0; i<a.length; i++) {
			a[i] = maxCounter;
		}
	}
	
	

}
