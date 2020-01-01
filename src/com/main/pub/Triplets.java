package com.main.pub;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Triplets {

	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7};
		int [] b = {5, 7, 9};
		int[] c= {7, 9, 11, 13};
		System.out.println(getTriplets(a, b, c));

	}
	
	static long getTriplets(int[] a, int[] b, int[] c) {
		Set<Integer> dist = new HashSet<>();
		for(int i=0; i < a.length; i++) {
			dist.add(a[i]);
		}
		Integer[] d = new Integer[dist.size()];
		dist.toArray(d);
		dist.clear();
		for(int i=0; i < b.length; i++) {
			dist.add(b[i]);
		}
		Integer[] e = new Integer[dist.size()];
		dist.toArray(e);
		dist.clear();
		
		for(int i=0; i < c.length; i++) {
			dist.add(c[i]);
		}
		Integer[] f = new Integer[dist.size()];
		dist.toArray(f);
		
		Arrays.sort(d);
		Arrays.sort(e);
		Arrays.sort(f);
		
		int count = 0;
		/*int startingJ = 0;
		boolean isBSet = false;
		boolean isCset;
		for(int i=0; i < d.length; i++) {
			int tempA = d[i];
			isBSet = false;
			for(int j=startingJ; j<e.length; j++) {
				if(e[j] >= tempA) {
					if(!isBSet) {
						startingJ = j;
						isBSet = true;
					}
				int tempB = e[j];	
					for(int k=f.length-1; k >= 0;k--) {
						if(f[k] <= tempB) {
							count = count + k + 1;
							break;
						} 
					}
				}
			}
		}*/
		int bi=0;
		int ai=0;
		int ci=0;
		while(bi < e.length) {
			ai=0;
			ci=0;
	        while (ai < d.length && d[ai] <= e[bi]) {
	            ai += 1;
	        }
	        while( ci < f.length && f[ci] <= e[bi]) {
	            ci += 1;
	        }
	        count += ai * ci;
	        bi += 1;
		}
	    return count;
		
    }

}
