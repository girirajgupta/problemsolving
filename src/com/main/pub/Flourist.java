package com.main.pub;

import java.util.Arrays;

public class Flourist {

	public static void main(String[] args) {
		//int[] c = {1, 3, 5, 7, 9};
		int[] c = {2, 5, 6};
		System.out.println(getCost(2, c));
	}

	static int getCost(int k, int[] c) {
		Arrays.sort(c);
		int cost =0;
		int multiFactor = 1;
		for(int i=c.length-1; i>=0;) {
			int index=0;
			while(index < k && i >=0) {
				cost = cost + multiFactor * c[i];
				index++;
				i--;
			}
			multiFactor += 1;
		}
		return cost;
    }
}
