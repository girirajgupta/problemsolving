package com.test;

public class KMPSearch {

	public static void main(String[] args) {
		//int[] prefixArray = new int[8];
		//buildPrefixArray(prefixArray, "abcdabca");
		/*for (int i : prefixArray) {
			System.out.println(i);
		}*/
		System.out.println(substring("ababababcabababababc","ababababab"));
	}
	
	static int substring(String source, String substring) {
		int prefixArray[] = new int[substring.length()];
		buildPrefixArray(prefixArray, substring);
		int j =0;
		for(int i=0; i < source.length();) {
			
			while(i < source.length() && j < substring.length() && source.charAt(i) == substring.charAt(j)) {
				i++;
				j++;
			}
			if(j == substring.length()) {
				return i - substring.length();
			} else if(j==0) {
				i++;
			} else {
				j = prefixArray[j];
			}
		}
		return -1;
	}

	private static void buildPrefixArray(int[] prefixArray, String substring) {
		int j=0;
		for(int i =1; i< substring.length(); i++) {
			if(substring.charAt(i) == substring.charAt(j)) {
				prefixArray[i] = j + 1;
				j++;
			} else if (j>0) {
				j = prefixArray[j-1];
				i = i-1;
			}
		}
		
	}

}
