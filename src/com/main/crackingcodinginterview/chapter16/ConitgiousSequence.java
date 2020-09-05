package com.main.crackingcodinginterview.chapter16;

public class ConitgiousSequence {

	public static void main(String[] args) {
		System.out.println(getMaxSum(new int[]{-8, 3, -2, 4, -10}));
		System.out.println(getMaxSum(new int[]{-8, 3, -2, 4, -5,7}));
	}

	private static int getMaxSum(int[] nums) {
		int maxEndingHere = nums[0];
		int maxSoFar = nums[0];
		
		for(int i=1; i< nums.length; i++) {
		      maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);

		      // Did we beat the 'maxSoFar' with the 'maxEndingHere'?
		      maxSoFar = Math.max(maxSoFar, maxEndingHere); 
		}
		return maxSoFar;
	}

}
