package com.main.pub;

public class Domino {

	public static void main(String[] args) {
		int[] A = {4, 3, 3, 4, 1, 2, 2, 3, 6, 5, 4, 5};// [0, 1, 2, 3, 3, 2, 1, 0, 0, 0, 0, 0, 0]
		//int[] A = {1,1,1,1,1,1,1,1,1,1,1,1};//[0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		//int[] A = {4, 3, 3, 4, 1, 2, 2, 3, 5, 5, 4, 5}; //[0, 1, 2, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0]
		//int[] A = {1,1,1,1,1,1,2,2,2,2,2,2};
		System.out.println(solution(A));

	}
	
	public static String solution(int[] A) {
		int[] counts = new int[13];
        for(int i =0; i < A.length; i++) {
        	counts[A[i]] +=1;
        }
        
        int[] metaCount = new int[13];
        for(int i=0; i< counts.length; i++) {
        	if(counts[i] != 0) {
        		metaCount[counts[i]] += 1;
        	}
        }
        
        for(int i=0; i< metaCount.length; i++) {
        	if(metaCount[i] == 12) {
        		break;
        	}
        } 
        return "YES";
    }

}
