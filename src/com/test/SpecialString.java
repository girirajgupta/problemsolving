package com.test;

import java.util.ArrayList;
import java.util.List;

public class SpecialString {
static 		long totalCount = 0;
static char last;	
public static void main(String[] args) {
		System.out.println(getCount(5, "asasd"));
		System.out.println(getCount(4, "aaaa"));
		System.out.println(getCount(7, "abcbaba"));
		System.out.println(getCount(5, "ccaca"));
	}
	
	static int getCount(int n, String s) {
		List<Long> counts = new ArrayList<>();
		counts.clear();
		totalCount = 0;
		long count=1;
		last = s.charAt(0);
		for(int i=1; i< n; i++) {
			if(s.charAt(i) == last) {
				count++;
			} else {
				if(i==1) {
					totalCount += 1;
				}
				if(count > 1) {
					totalCount += 1;
				}
				counts.add(count);
				count = 1;
				checkPal(i, n, s);
			}
			last = s.charAt(i);
		}
		if(count>1) {
			counts.add(count);
		}
		counts.forEach( (n1) -> totalCount += getFactorial(n1));
		return (int) totalCount;
		
	}

	private static void checkPal(int i, int n, String s) {
		int diff = 1;
		int j = i-diff;
		int k = i + diff;
		while (j>= 0 && k < n) {
			if(s.charAt(j)==s.charAt(k) && s.charAt(j) == last) {
				totalCount += 1;
			} else {
				break;
			}
			j -= 1;
			k += 1;
		}
	}

	private static long getFactorial(Long n) {
		return n*(n+1)/2;
	}

}