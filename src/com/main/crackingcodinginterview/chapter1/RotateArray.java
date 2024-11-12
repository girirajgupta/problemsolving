package com.main.crackingcodinginterview.chapter1;

/*
// Given an unsorted array arr[] of size N, rotate it by D elements (counter clockwise).
1,2,3,4,5,6,7,8
4,5,6,7,8,1,2,3
 */
public class RotateArray {
    public static int[] rotateArrayByD(int[] arr, int d) {
        if (arr == null || arr.length == 1) {
            return arr;
        } else {
            int[] newarr = new int[arr.length];
            for(int i=0;i<(arr.length);i++) {
                newarr[i] = arr[(i+d)%arr.length];
            }
            return newarr;
        }
    }

    public static void print(int[] arr) {
        for(int i : arr)
            System.out.println(" " + i);
    }
    public static void main(String args[]){
        print(rotateArrayByD(new int[] { 1, 2, 3, 4, 5, 6,7,8 }, 3));
    }

}
