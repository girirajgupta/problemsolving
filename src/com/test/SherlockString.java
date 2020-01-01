package com.test;

import java.util.HashSet;
import java.util.Set;

public class SherlockString {

	public static void main(String[] args) {
		System.out.println(validOrNot("aabbcd"));
		System.out.println(validOrNot("aabbccddeefghi"));
		System.out.println(validOrNot("abcdefghhgfedecba"));
		//System.out.println(validOrNot("aabbcd"));
	}
	
	static String validOrNot(String s) {
		int[] count = new int[26];
		for(int i=0;i<s.length();i++) {
			int index = s.charAt(i)-97;
			count[index] += 1;
			//System.out.println(index);
		}
		
		boolean hasFrequency1 = false;
		int freq1=0;
		int freq2=0;
		boolean hasFrequency2 = false;
		Set<Integer> setOfValues = new HashSet<>();
		for(int i=0; i < 26; i++) {
			if(count[i] != 0) {
				if(freq1 ==0) {
					freq1 = count[i];
				} else if(freq1 == 0) {
					freq2 = count[i];
				} 
				
			}
			
		}
		
		int[] values =
				setOfValues.stream() 
	            .mapToInt(Integer::intValue) 
	            .toArray();
		
		if(values.length == 1 || values[0] == (values[1] +1) || (values[0] + 1) == values[1]) {
			return "YES";
		} else {
			return "NO";
		}
    }

}
