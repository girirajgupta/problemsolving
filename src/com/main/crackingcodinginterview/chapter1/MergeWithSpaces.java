package com.main.crackingcodinginterview.chapter1;
/*
Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m.
The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).

Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.

/space is o(m+n)
/time is o(m+n)
*/
public class MergeWithSpaces {
    public static int[] merge(int[] A, int[] B) {
        if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        } else {
            int[] C = new int[A.length+B.length];
            if (A[0] <= B[0]) {
                C[0] = A[0];
                merge(A,B,C,1,0,1);
            } else {
                C[0] = B[0];
                merge(B,A,C,1,0,1);
            }

            return C;
        }
    }

    public static void merge(int[] A, int[] B, int[] C, int i, int j,int k) {
        if (i >= A.length && j >=B.length)
            return;

        while(i < A.length && j < B.length && A[i] <= B[j] ) {
            C[k++] = A[i++];
        }
        if (i == A.length) {
            while(j<B.length) {
                C[k++] = B[j++];
            }
        } else {
            merge(B, A, C,j,i,k);
        }
    }
    public static void print(int[] arr) {
        for(int i : arr)
            System.out.println(" " + i);
    }
    public static void main(String args[]){
        print(merge( new int[]{2,2,5,6,6,8,12}, new int[] { 2, 2, 6,9}));
    }
}
