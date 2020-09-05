package com.main.crackingcodinginterview.chapter1;

public class StringRotation {

	public static void main(String[] args) {
		System.out.println(isRotation("abcdef", "defabc"));
		System.out.println(isRotation("abcdef", "dabcef"));
		System.out.println(isRotation("abcdef", "fabcde"));
		System.out.println(isRotation("abcdef", "efabcd"));
		System.out.println(isRotation("abcdef", "cdefab"));
		System.out.println(isRotation("abcdef", "bcdefa"));
		System.out.println(isRotation("abcdef", "abcdef"));
	}

	private static boolean isRotation(String str, String str2) {
		return (str + str).contains(str2);
	}

}
