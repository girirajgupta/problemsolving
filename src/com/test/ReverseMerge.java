package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseMerge {

	public static void main(String[] args) {
		System.out.println(getString("abcdefgabcdefg"));
		System.out.println(getString("aeiouuoiea"));
		System.out.println(getString("eggegg"));
	}
	
	static String getString(String s) {
		char[] str = new char[26];
		for(int i=0; i < s.length(); i++) {
			int index = s.charAt(i) - 97;
			str[index] += 1;
		}
		
		StringBuilder builder = new StringBuilder(s.length()/2);
		char ch = 'a';
		for(int i=0; i< 26; i++) {
			int k = str[i]/2;
			while(k-- > 0) {
				builder.append(ch);
			}
			ch++;
		}
		
		return builder.toString();
		
    }

}
