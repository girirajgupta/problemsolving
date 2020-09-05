package com.main.crackingcodinginterview.chapter1;

import java.util.HashMap;
import java.util.Map;

public class OneAway {
	static Map<Integer, Integer> charCount = new HashMap<>();
	static int numberOfdistance;
	public static void main(String[] args) {
		System.out.println(isOneAway("PALE", "PALE"));
		System.out.println(isOneAway("ABCDEF", "ABCDEF"));
		System.out.println(isOneAway("ABCDEF", "ABCDE"));
		System.out.println(isOneAway("ABCDEF", "ABCDEFG"));
		System.out.println(isOneAway("ABCDEF", "ABCDEG"));
		System.out.println(isOneAway("ABCDEF", "ABCD"));
		System.out.println(isOneAway("ABCDEF", "ABCDG"));
	}

	private static boolean isOneAway(String str, String str2) {
		if(str.length() == str2.length() || (str.length()+1) == str2.length() || str.length() == (str2.length()+1)) {
			//do nothing
		} else {
			return false;
		}
		
		charCount = new HashMap<>();
		numberOfdistance = 0;
		str.chars().forEach((ch) -> {
			if(charCount.get(ch) != null) {
				int count = charCount.get(ch) + 1;
				charCount.put(ch, count);
			} else {
				charCount.put(ch, 1);
			}
		});
		
		str2.chars().forEach((ch) -> {
			if(charCount.get(ch) != null) {
				int count = charCount.get(ch) - 1;
				if(count < 0) {
					numberOfdistance++;
				}
				
			} else {
				numberOfdistance++;
			}
		});
		
		numberOfdistance = numberOfdistance + (str.length() - str2.length());
		
		return numberOfdistance == 0 || numberOfdistance == 1;
	}

}
