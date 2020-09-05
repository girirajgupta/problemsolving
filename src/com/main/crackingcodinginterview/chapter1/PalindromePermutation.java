package com.main.crackingcodinginterview.chapter1;

import java.util.BitSet;

public class PalindromePermutation {
	static BitSet btst;
	static int count;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindromPermutaion("Tact Coa"));
		System.out.println(isPalindromPermutaion("tact Coa"));
		System.out.println(isPalindromPermutaion("tact CoOOa"));
		System.out.println(isPalindromPermutaion("aaaaaa"));
		System.out.println(isPalindromPermutaion("abcdefgh"));
	}

	private static boolean isPalindromPermutaion(String string) {
		String str = string.toLowerCase();
		btst = new BitSet();
		count = 0;
		str.chars().forEach((ch) -> {
			if(ch != ' ') {
				if(btst.get(ch)) {
					count--;
					btst.clear(ch);
				} else {
					count++;
					btst.set(ch);
				}
			}
		});
		
		return count == 0 || count == 1;
	}
}
