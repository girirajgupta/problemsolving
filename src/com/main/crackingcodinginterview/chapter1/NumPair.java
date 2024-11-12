package com.main.crackingcodinginterview.chapter1;
/*
Given two arrays X and Y of positive long integers,
find number of pairs such that x^y > y^x (raised to power of)
where x is an element from X and y is an element from Y.
*/
public class NumPair {
    public static void pair(int[] x, int[] y) {
        int count =0;
        for(int i=0;i<x.length;i++) {
            for(int j=0;j<y.length;j++) {
                if ( Math.pow(x[i],y[j]) > Math.pow(y[j],x[i])) {
                    System.out.println("pair is" + x[i] + "," + y[j]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void pairOptimized(int[] x, int[] y) {

    }
    public static void main(String args[]) {
            pair(new int[]{1,2,3,4},new int[]{2,3});
    }
}
