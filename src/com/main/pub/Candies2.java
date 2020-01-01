package com.main.pub;

import java.util.Arrays;

public class Candies2 {
static long count = 0;
	public static void main(String[] args) {
		int a[] = {2,4,2,6,1,7,8,9,2,1};
		//int a[] = {1,2,3,4,5,6,7,8,9,10}; 
		//int a[] = {10,9,8,7,6,5,4,3,2,1};
 		System.out.println(getMin(10, a));

	}
	static long getMin(int n, int[] arr) {
		int[] candies = new int[arr.length];
		int[] candies2 = new int[arr.length];
		candies[0] = 1;
		for(int i=1; i< arr.length; i++) {
			if(arr[i] > arr[i-1]) {
				candies[i] = candies[i-1] + 1;
			} else {
				candies[i]  = 1;
			}
		}
		count = candies[arr.length-1];
		candies2[arr.length-1]= 1;
		for(int i = arr.length-2; i>=0;i--) {
			if(arr[i] > arr[i+1]) {
				candies2[i] = candies2[i+1] + 1;
			} else {
				candies2[i] = 1;
			}
			count += (candies[i] > candies2[i] ? candies[i] : candies2[i]);
		}
		
		//Arrays.stream(candies).forEach(cc -> count+=cc);
		
		return count;
    }
}
