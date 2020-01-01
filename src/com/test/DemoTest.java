package com.test;

import java.util.Arrays;

public class DemoTest {

	public static void main(String[] args) {
		//int[] A = {1, 3, 6, 4, 1, 2};
		//int[] A = {1, 2, 3};
		//int[] A = {-1,-5,0,-3};
		int[] A = {-1,-3};
		//int[] A = {-2,-6,0,5};
		System.out.println(getSol(A));

	}
	
	public static int getSol(int[] A) {
       Arrays.sort(A);
       if(A[0] > 1) {
    	   return 1;
       } else {
    	   int smallest = 1;
    	   int index = 0;
    	   while(index < A.length && A[index] <= 0) {
    		   index++;
    	   }
    	   if(index == A.length) {
    		   return 1;
    	   }
    	   while(index < A.length) {
    		   if(smallest == A[index]) {
    			   smallest++;
    		   } else if (smallest > A[index]) {
    			   // do nothing
    		   } else {
    			   return smallest;
    		   }
    		   index++;
    	   }
    	   return A[A.length-1] + 1;
       }
       
    }

}
