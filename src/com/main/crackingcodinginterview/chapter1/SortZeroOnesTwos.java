package com.main.crackingcodinginterview.chapter1;
/*
Given an array A of size N containing 0s, 1s, and 2s;
you need to sort the array in ascending order.
Constraints:
1 <= T <= 500
1 <= N <= 106
0 <= Ai <= 2
*/
public class SortZeroOnesTwos {
    public static void sort(int[] x) {
        int pos_zero = -1,pos_one=-1,pos_two=-1;
        int count_zeros = 0,count_ones=0,count_twos=0;
        for(int i=0;i<x.length;i++) {
            if (x[i] == 0) {
                count_zeros++;
            } else if(x[i] == 1) {
                count_ones++;
            } else {
                count_twos++;
            }
        }
        for (int i =0;i < x.length;i++) {
            if (i < count_zeros) {
                x[i] = 0;
            } else if (i < (count_zeros + count_ones)) {
                x[i] = 1;
            } else {
                x[i] = 2;
            }
        }
        print(x);
    }

    public static void print(int[] arr) {
        for(int i : arr)
            System.out.println(" " + i);
    }
    public static void pairOptimized(int[] x, int[] y) {

    }
    public static void main(String args[]) {
        sort(new int[]{0,1,0,2,2,0,1,2,0,1,2});
    }
}
