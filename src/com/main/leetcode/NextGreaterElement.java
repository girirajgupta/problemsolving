package com.main.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
    public static void main(String[] args) {
        Arrays.stream(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})).sequential().forEach(System.out::println);
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] output = new int[nums1.length];
        Map<Integer,Integer> pos = new HashMap<>();
        for(int i =0; i< nums2.length;i++) {
            pos.put(nums2[i],i);
        }

        for(int i=0; i< nums1.length;i++) {
            int p = pos.get(nums1[i]);
            output[i] = -1;
            for(int j = p+1; j<nums2.length;j++) {
                if(nums2[j] > nums1[i]) {
                    output[i] = nums2[j];
                    break;
                }
            }
        }

        return output;
    }
}
