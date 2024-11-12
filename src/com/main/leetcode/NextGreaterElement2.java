package com.main.leetcode;

import java.util.Arrays;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        Arrays.stream(nextGreaterElement(new int[]{1,3,4,2})).sequential().forEach(System.out::println);
    }
    public static int[] nextGreaterElement(int[] nums1) {
        int[] output = new int[nums1.length];

        for(int i=0; i< nums1.length;i++) {
            output[i] = -1;
            int j = i+1;
            int count = 0;
            while(count++ < nums1.length) {
                if(nums1[j % nums1.length] > nums1[i]) {
                    output[i] = nums1[j % nums1.length];
                    break;
                }
                j++;
            }
        }

        return output;
    }
}
