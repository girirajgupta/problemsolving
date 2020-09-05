package com.main.crackingcodinginterview.chapter1;

import java.util.Arrays;
import java.util.BitSet;

import jdk.nashorn.internal.runtime.BitVector;

public class CheckPermutation {
	static long hash;
	static BitSet vector;
	static boolean isValidP;
	public static void main(String[] args) {
		System.out.println(checkPermuation("abc","bca"));
		System.out.println(checkPermuation("abc","dca"));
		System.out.println(checkPermuation("bcd","ace"));
		
		//sort 
		System.out.println(checkPermutationWithSorting("abc","bca"));
		System.out.println(checkPermutationWithSorting("abc","dca"));
		System.out.println(checkPermutationWithSorting("bcd","ace"));
		
		
		//BitSet
		System.out.println(checkPermutationWithBitSet("abc","bca"));
		System.out.println(checkPermutationWithBitSet("abc","dca"));
		System.out.println(checkPermutationWithBitSet("bcd","ace"));
	}

	private static boolean checkPermuation(String str1, String str2) {
		return getHash(str1) == getHash(str2);
	}
	
	private static boolean checkPermutationWithSorting(String str1, String str2) { //O(N LogN)
		return sort(str1).equals(sort(str2));
	}
	
	private static boolean checkPermutationWithBitSet(String str1, String str2) { //flawed O(N)
		isValidP = true;
		vector = new BitSet();
		str1.chars().forEach((ch) -> {
			vector.set(ch);
		}); 
		
		str2.chars().forEach((ch) -> {
			if(vector.get(ch)) {
				vector.clear(ch);
			} else {
				isValidP = false;
				return;
			}
		});
		
		return isValidP;
	}

	private static String sort(String str1) {
		char[] ch = str1.toCharArray();
		Arrays.sort(ch);
		return Arrays.toString(ch);
	}

	private static long getHash(String str) { //wrong
		hash= 0;
		str.chars().forEach((ch)-> {
			hash = hash + ch;
		});
		
		return hash;
	}
}
