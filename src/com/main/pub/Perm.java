package com.main.pub;

public class Perm {

	public static void main(String[] args) {
		int[] A= {1,4,5,3};
		System.out.println(solution(A));

	}
	
	static int solution(int[] A) {
		if(A.length == 0) {
			return 0;
		}
		int number = A.length+1;
		for(int i=0; i< A.length; i++) {
			number = number ^ i+1 ^ A[i];
		}
		
		return number;
	}

}
