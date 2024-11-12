package com.main.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/description/
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []

 */
public class CombinationSum {
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7}, 7).forEach(System.out::println);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        for(int candidate: candidates) {
            items.add(candidate);
        }
        findSum(items, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void findSum(List<Integer> items, int target, List<Integer> elements, List<List<Integer>> result) {
        if(target == 0) {
            if (!elements.isEmpty()) {
                final List<Integer> integers = new ArrayList<>();
                elements.forEach(integer -> integers.add(integer));
                result.add(integers);
            }
            return;
        } else if (target < 0) {
            return;
        } else {
            for(int i = 0; i < items.size(); i++) {
                int newTarget = target - items.get(i);
                elements.add(items.get(i));
                List<Integer> items2 = new ArrayList<>();
                for(int j = i; j< items.size(); j++) {
                    items2.add(items.get(j));
                }
                findSum(items2, newTarget, elements, result);
                elements.remove(elements.size()-1);
            }
        }
    }
}
