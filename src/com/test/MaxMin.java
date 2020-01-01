package com.test;

import java.util.Arrays;

public class MaxMin {

	public static void main(String[] args) {
		//int[] arr = {10,100,300,200,1000,20,30};
		//int[] arr = {1,2,3,4,10,20,30,40,100,200};
		//int[] arr = {1,2,1,2,1};
		int[] arr = {100,200,300,350,400,401,402};
		System.out.println(getMaxMin(3, arr));

	}
	
	static int getMaxMin(int k, int[] arr) {
		Arrays.sort(arr);
		int minSum = Integer.MAX_VALUE;
		for(int i=0; i < arr.length-k+1; i++) {
			int diff = arr[i+k-1] - arr[i];
			if(diff < minSum) {
				minSum = diff;
			}
		}
		return minSum;
    }

}
