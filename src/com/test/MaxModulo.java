package com.test;

public class MaxModulo {

	public static void main(String[] args) {
		long[] a = {3, 3, 9, 9, 5};
		System.out.println(getMax(a, 7));

	}
	
	static long getMax(long[] a, long m) {
	long[] prefix = new long[a.length];	
		long curr = 0;
		for(int i = 0; i < a.length; i ++) {
		  curr = (a[i] % m + curr) % m;
		  prefix[i] = curr;
		}
		long ret = 0;
		for(int i = 0; i < a.length; i ++) {
		  for(int j = i-1; j >= 0; j --) {
		    ret = Math.max(ret, (prefix[i] - prefix[j] + m) % m);
		  }
		  ret = Math.max(ret, prefix[i]); // Don't forget sum from beginning. 
		}
		return ret;
	}

}
