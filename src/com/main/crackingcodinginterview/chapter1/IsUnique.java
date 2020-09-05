package com.main.crackingcodinginterview.chapter1;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {
	static boolean hasDuplicate = false;
	public static void main(String[] args) {
		System.out.println(isUnique("abcde"));  // should be true
		System.out.println(isUnique("abcdedf")); // should be false
		System.out.println(isUniqueWithBITSet("abcde"));  // should be true
		System.out.println(isUniqueWithBITSet("abcdedf")); // should be false
	}
	
	public static boolean isUnique(String str) {  //O(N) time, O(N) space
		if(str == null || str.isEmpty()) {
			return true;
		}
		hasDuplicate = false;
		Set<String> uniqueChars = new HashSet<>();
		str.chars().forEach((c) -> {
			System.out.println(uniqueChars.toString());
			if(uniqueChars.contains(String.valueOf(c))) {
				System.out.println("contains :" + c);
				hasDuplicate = true;
				return;
			} else {
				uniqueChars.add(String.valueOf(c));
			}
		});
		return hasDuplicate;
	}
	
	public static boolean isUniqueWithBITSet(String str) {//O(N) 
		hasDuplicate = false;
		BitSet bit = new BitSet();
		str.chars().forEach((c) -> {
			if(bit.get(c)) {
				hasDuplicate = true;
				return;
			} else {
				bit.set(c);
			}
		});
		return hasDuplicate;
	}
	
	public static boolean isUniqueWithNLOGN(String str) { //O(NLogN)
		/*
		 * sort
		 * Iterate and binary search in the rest of the string
		 */
		return false;
	}

}
