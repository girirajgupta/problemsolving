package com.main.crackingcodinginterview.chapter1;
// Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
/* Input:
The first line of input contains an integer T denoting the number of test cases.
Then T test cases follow. Each test case consists of two lines.
The first line of each test case is N and S, where N is the size of array and S is the sum.
The second line of each test case contains N space separated integers denoting the array elements.*/
/* Output:
For each testcase, in a new line, print the starting
and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1. */
public class SumArray {
    public static int[] sumArray(int[] arr, int d) {
        if (arr == null) {
            return new int[]{-1,-1};
        } else {
            int sumSoFar = 0;
            int firstIndex = 0;
            int endIndex = -1;
            for(int i=0;i<(arr.length);i++) {
                sumSoFar +=arr[i];
                if(sumSoFar == d) {
                    return new int[]{firstIndex,i};
                } else if (sumSoFar < d) {
                } else {
                    int sum = sumSoFar - arr[firstIndex];
                    firstIndex = firstIndex + 1;
                    if (sum < d ) {
                        sumSoFar = sum;
                    } else if ( sum ==d) {
                        endIndex = i;
                        return new int[]{firstIndex,i};
                    } else {

                    }
                }
            }
            return new int[]{firstIndex,endIndex};
        }
    }

    public static void print(int[] arr) {
        for(int i : arr)
            System.out.println(" " + i);
    }
    public static void main(String args[]){
        print(sumArray(new int[] { 1, 2, 3, 10, 1, 6,7,8 }, 11));
    }
}
