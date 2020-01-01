package com.test;

public class WildCardSearch {

	public static void main(String[] args) {
		System.out.println(find("abcdefr", "a..*"));
	}
	
	static boolean find(String source, String pattern) {
		boolean[][] dp = new boolean[pattern.length()+1][source.length()+1];
		for(int i=0; i < pattern.length(); i++) {
			dp[i][0] = true;
		}
		for(int i=0; i < source.length(); i++) {
			dp[0][i] = true;
		}
		
		for(int i=0; i < pattern.length(); i++) {
			for(int j=0; j< source.length(); j++) {
				if(pattern.charAt(i) == '.' || pattern.charAt(i) == source.charAt(j)) {
					dp[i+1][j+1] = dp[i][j];
				} else if(pattern.charAt(i) == '*') {
					dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
				} else {
					dp[i+1][j+1] = false;
				}
			}
		}
		
		return dp[pattern.length()][source.length()];
	}

}
