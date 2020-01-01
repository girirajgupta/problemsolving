package com.main.pub;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {
	static Map<Integer, Integer> dic = new HashMap<>();
	
	public static void main(String args[]) {
		//System.out.println(anagrams("kkkk"));
		System.out.println(anagrams("ifailuhkqq"));
	}
	
	static int anagrams(String s) {
		if(s.length()==1) {
			return 0;
		}
		int count = 0;
		int maxlength = s.length() -1;
		System.out.println(" maxlength ::" + maxlength);
		while(maxlength > 0) {
			System.out.println(" count ::" + count);
			for(int i=0; i+maxlength < s.length(); i++) {
				int j = i+1;
				System.out.println(" i :: " + i + " , and j ::" + j);
				String str = s.substring(i, i+maxlength);
				System.out.println(" str ::" + str);
				int hash = getHash(str);
				System.out.println(" has ::" + hash);
				dic.put(hash, 0);
				System.out.println(" j ::" + j);
				do {
					String str2 = s.substring(j, j+maxlength);
					System.out.println(" str2 ::" + str2);
					int hash2 = getHash(str2);
					System.out.println(" hash2 ::" + hash2);
					if(dic.containsKey(hash2)) {
						System.out.println(" anagram ::");
						count++;
					}
					j++;
				} while(j+maxlength <= s.length());
			}
			maxlength--;
		}
		System.out.println(" count before return::" + count);
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
