package com.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {
	static Map<Integer, Integer> dic = new HashMap<>();
	static Set<Integer> dic2 = new HashSet<>();
    static // Complete the minimumBribes function below.
	int countFinal = 0;
    static void minimumBribes(int[] q) {
        int numberOfBribes = 0;
        int offset = 0;
        boolean doagain = false;
        boolean useOffset = false;
        for(int i=0;i<q.length;i++) {
            if(q[i] > (i + 3)) {
                System.out.println("Too chaotic");
                return;
            }
        }
        int i=0,j=0,k=1;
        do {
        	i++;
        	doagain = false;    
             while(k < q.length && q[j] <= q[k]) {
            	 j++;
            	 k++;
             }
             System.out.print("before ");
             printarray(q);
             while(j > 0 && k<q.length && q[k] < q[j]) {
            	 numberOfBribes ++;
            	 swap(q, j, k);
            	 j--;
            	 k--;
             }
             System.out.print("After ");
             printarray(q);
        }
        while (i!=10);
        System.out.println(numberOfBribes);
    }

    private static void swap(int[] q, int j, int k) {
        int temp = q[j];
        q[j] = q[k];
        q[k] = temp;
    }
    
    private static void printarray(int[] q) {
    	for(int i=0;i<q.length;i++) {
    		System.out.print(q[i] + " ");
    	}
    	System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//int[] q = {1,2,5,3,7,8,6,4};
//    	minimumBribes(q);
int count = anagrams("kkkkk");
System.out.println(count);
//checkFilter();

    }

	private static void checkFilter() {
		List<String> customers = Arrays.asList("sarah", "james", "rooney");
		System.out.println("size is :" + customers.size());
		List<String> customers2 = customers.stream().filter(customer -> customer.equals("james")).collect(Collectors.toList());
		System.out.println("size after is :" + customers2.size());
	}

	private static int anagrams(String string) {
		if(string.length() == 1) {
			return 0;
		} else {
			int maxlength = string.length()-1;
			int count = 0;
			while(maxlength>0) {
				System.out.println("Maxlength ::" + maxlength);
				int i = 0;
				do {
					System.out.println("i ::" + i);
					String subs = string.substring(i, (i+maxlength));
					System.out.println("subs ::" + subs);
					int hash = getHash(subs);
					System.out.println("hash ::" + hash);
					if(dic2.contains(hash)) {
						int rowCount = dic.get(hash) + 1;
						System.out.println("rowCount ::" + rowCount);
						dic.put(hash, rowCount);
						System.out.println("contains ::");
						count++;
					} else {
						dic.put(hash, 0);
						System.out.println("Adding ::");
						dic2.add(hash);
					}
					i++;
				}while ((i+maxlength) <= string.length());
				maxlength--;	
			}
			dic.forEach((rowhash, rowCount) -> {
				System.out.println("row is ::" + rowhash);
				System.out.println("Cont is ::" + rowCount);
				System.out.println("countFinal before::" + countFinal);
				countFinal = countFinal + getCount(rowCount);
				System.out.println("countFinal after::" + countFinal);
			});
			return countFinal;
		}
	}

	private static int getCount(Integer rowCount) {
		int count = 0;
		while(rowCount > 0) {
			count += rowCount;
			rowCount--;
		}
		return count;
	}

	private static int getHash(String subs) {
		int hash = 0;
		for(int i=0; i< subs.length(); i++) {
			hash = hash + subs.charAt(i);
		}
		return hash;
	}
}
