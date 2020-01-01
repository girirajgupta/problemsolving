package com.test;

public class MaxSum {

	public static void main(String[] args) {
		//int[] a = {3, 5, -7, 8, 10};
		//int[] a = {3, 7, 4, 6, 5};
		int[] a = {2, 1, 5, 8, 4};
		System.out.println(getMax(a));

	}
	
	static int getMax(int[] arr) {
		int inc = 0;
		int exl = 0;
		for(int i=0; i< arr.length; i++) {
			int temp = inc;
			inc = Math.max(exl+arr[i], inc);
			exl = temp;
		}
		
		
		return Math.max(inc, exl);
    }

}
