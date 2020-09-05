package com.main.crackingcodinginterview.chapter1;

public class StringComparision {
	static int length;
	static String prevChar;
	static int curCount;
	public static void main(String[] args) {
		System.out.println(covert("aabcccccbb"));
		System.out.println(covert("aa"));
		System.out.println(covert("aabcdddaavv"));
	}

	private static String covert(String str) {
		StringBuilder target = new StringBuilder();
		prevChar = "";
		curCount = 0;
		str.chars().forEachOrdered((ch) -> {
			if(!String.valueOf(ch).equals(prevChar)) {
				if(!prevChar.isEmpty()) {
					target.append(prevChar).append(curCount);
				}
				prevChar = String.valueOf(ch);
				curCount = 1;
			} else {
				curCount++;
			}
		});
		target.append(prevChar).append(curCount);
		return target.toString();
	}

}
