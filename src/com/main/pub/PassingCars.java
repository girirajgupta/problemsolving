package com.main.pub;

public class PassingCars {

	public static void main(String[] args) {
		int[] A = {0,1,0,1,1};
		System.out.println(solution(A));

	}
	
	static public long solution(int[] A) {
		long count = 0;
		int numberOfZeros=0;
		for (int i : A) {
			if(i == 0) {
				numberOfZeros += 1;
			} else {
				count += numberOfZeros;
			}
			if(count > 1000000000) {
				return -1;
			}
		}
		return count;
	}

}
