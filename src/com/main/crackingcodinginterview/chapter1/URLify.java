package com.main.crackingcodinginterview.chapter1;

import java.util.Arrays;

public class URLify {

	public static void main(String[] args) {
		System.out.println(getURL("Mr John Smith      "));
		System.out.println(getURLStartingFromEnd("Mr John Smith    "));
	}
	
	private static String getURLStartingFromEnd(String string) {
		int i = string.length()-1;
		int j = string.length()-1;
		char[] target = string.toCharArray();
		while(i>=0) {
			if(string.charAt(i) == ' ') {
				i--;
			} else if(string.charAt(i) != ' ') {
				break;
			}
		}
		
		while(i>=0) {
			if(string.charAt(i) != ' ') {
				target[j--] = target[i--];
			} else {
				target[j--] = '0';
				target[j--] = '2';
				target[j--] = '%';
				i--;
			}
		}
		
		return Arrays.toString(target);
	}

	private static String getURL(String string) {
		char[] ch = string.toCharArray();
		StringBuffer sbr = new StringBuffer(string.length());
		int j=1;
		sbr.append(ch[0]);
		for(int i=1;i<ch.length;i++) {
			if(ch[i-1] == ' ' && ch[i] != ' ') {
				sbr.append('%').append('2').append('0').append(ch[i]);
			} else if(ch[i] != ' ') {
				sbr.append(ch[i]);
			}
		}
		
		return sbr.toString();
	}
}
