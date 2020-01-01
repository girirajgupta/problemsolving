package com.test;

import java.util.Arrays;

public class Genome2 {

	public static void main(String[] args) {
		/*int[] P = {2,5,0};
		int[] Q = {4,5,6};*/
		int[] P = {0};
		int[] Q = {0};
		
		for (int i: solution("G", P, Q)) {
			System.out.println(i);
		}

	}
// o(n*m) time and o(n2) space so not efficient
	public static int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        
        int[] lastSeenA = new int[S.length()];
        int[] lastSeenC = new int[S.length()];
        int[] lastSeenG = new int[S.length()];
        int[] lastSeenT = new int[S.length()];
   
        
        Arrays.fill(lastSeenA, -1);
        Arrays.fill(lastSeenC, -1);
        Arrays.fill(lastSeenG, -1);
        Arrays.fill(lastSeenT, -1);
        
        //initialize
        for(int i = 0; i< S.length(); i++) {
        	updateLastSeen(S, lastSeenA, 'A', i);
        	updateLastSeen(S, lastSeenC, 'C', i);
        	updateLastSeen(S, lastSeenG, 'G', i);
        	updateLastSeen(S, lastSeenT, 'T', i);
        }
        
        //process
        for(int i=0; i< P.length; i++) {
        	if(lastSeenA[Q[i]] >= P[i]) {
        		result[i] = 1;
        	} else if(lastSeenC[Q[i]] >= P[i]) {
        		result[i] = 2;
        	} else if(lastSeenG[Q[i]] >= P[i]) {
        		result[i] = 3;
        	} else {
        		result[i] = 4;
        	}
        }
        
        return result;
    }
	
	static void updateLastSeen(String S, int[] arr, int currentValue, int index) {
		if(S.charAt(index) == currentValue) {
			arr[index] = index;
		} else if(index > 0){
			arr[index] = arr[index-1];
		}
	}	
}
