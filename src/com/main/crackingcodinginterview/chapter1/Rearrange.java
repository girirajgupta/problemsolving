package com.main.crackingcodinginterview.chapter1;
/*
Given a sorted array of positive integers.
Your task is to rearrange  the array elements alternatively
i.e first element should be max value, second should be min value, third should be second max,
fourth should be second min and so on...
Note: O(1) extra space is allowed. Also, try to modify the input array as required.

Constraints:
1 <=T<= 100
1 <=N<= 10^7
1 <=arr[i]<= 10^7
*/
public class Rearrange {
    public static int[] reArrange(int[] A) {
        if (A == null) {
            return A;
        } else {
            int K = 13,i=0;
            int max = A.length-1;
            int min = 0;
            while(min <= max) {
                if (i%2 == 0) {
                    A[i] = A[i] + (A[max]%K) * K;
                    max--;
                } else {
                    A[i] = A[i] + (A[min]%K)*K;
                    min++;
                }
                i++;
            }
            i=0;
            for(int j : A) {
                A[i] = A[i]/K;
                i++;
            }

            return A;
        }
    }
    public static void print(int[] arr) {
        for(int i : arr)
            System.out.println(" " + i);
    }
    public static void main(String args[]){
        print(reArrange( new int[]{1,2,3,4,5,6,7,8,9,10}));
        // 10 1 9 2 8 3 7 4 6 5
        // 10 1 9 2 8 3 7 4 3 5
    }
}
