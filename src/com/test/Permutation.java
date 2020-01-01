package com.test;

public class Permutation {

	public static void main(String[] args) {
		int[] A={1,2,3};
		System.out.println(solution(A));

	}
	
	static int solution(int[] A) {
		if(A.length == 0) {
			return 0;
		}
		int number = 0;
		for(int i=0; i< A.length; i++) {
			number = number ^ i+1 ^ A[i];
		}
		
		if(number == 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
