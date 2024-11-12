package com.main.crackingcodinginterview.chapter1;
/*
Given two arrays X and Y of positive long integers,
find number of pairs such that x^y > y^x (raised to power of)
where x is an element from X and y is an element from Y.
brute force o(n2)
sort n log(n)
*/
public class Inversion {
    public static void invresion(int[] x) {
        int count =0;
        for(int i=0;i<x.length;i++) {
            for(int j=i;j<x.length;j++) {
                if ( x[i] > x[j]) {
                    System.out.println("pair is" + x[i] + "," + x[j]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void pairOptimized(int[] x, int[] y) {

    }
    public static void main(String args[]) {
            invresion(new int[]{5,4,3,2,1});
    }
}
