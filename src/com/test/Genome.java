package com.test;

public class Genome {

	public static void main(String[] args) {
		int[] P = {2,5,0};
		int[] Q = {4,5,6};
		
		for (int i: solution("CAGCCTA ", P, Q)) {
			System.out.println(i);
		}

	}
// o(n*m) time and o(n2) space so not efficient
	public static int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        int[][] prefixes = new int[S.length()][S.length()];
        
        //initialize
        for(int i = 0; i< S.length(); i++) {
        	for(int j = i; j < S.length(); j++) {
        		if(S.charAt(j) < S.charAt(i)) {
        			prefixes[i][j] = getValue(S.charAt(j));
        		} else if(j==i){
        			prefixes[i][j] = getValue(S.charAt(i));
        		} else {
        			prefixes[i][j] = prefixes[i][j-1];
        		}
        	}
        }
        
        //process
        for(int i=0; i< P.length; i++) {
        	result[i] = prefixes[P[i]][Q[i]];
        }
        
        return result;
    }

	private static int getValue(char charAt) {
		switch(charAt) {
		case 'A':
			return 1;
		case 'C':
			return 2;
		case 'G':
			return 3;
		case 'T':
			return 4;
		}
		return -1;
	}
	
}
