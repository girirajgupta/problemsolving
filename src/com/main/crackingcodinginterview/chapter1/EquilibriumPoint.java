package com.main.crackingcodinginterview.chapter1;

public class EquilibriumPoint {
    public static void findPoint(int[] x) {
        int totalSum = 0;
        for(int i : x) {
            totalSum += i;
        }
        int sumSoFar=0;
        for (int i=0;i<x.length;i++) {
            sumSoFar += x[i];
            if (sumSoFar == (totalSum-sumSoFar)) {
                System.out.println(i);
                break;
            }
        }

    }
    public static void main(String args[]) {
        findPoint(new int[]{2,3,5});
    }
}
