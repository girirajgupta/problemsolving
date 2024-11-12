package com.main.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/combination-sum-ii/description/
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

 */
public class CombinationSum2 {
    static Set<String> seen = new HashSet<String>();
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,2,7}, 7).forEach(System.out::println);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        for(int candidate: candidates) {
            items.add(candidate);
        }
        Collections.sort(items);
        findSum(items, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void findSum(List<Integer> items, int target, List<Integer> elements, List<List<Integer>> result) {
        if(target == 0) {
            if (!elements.isEmpty()) {
                final String collect = elements.stream().map(el -> el + ".").collect(Collectors.joining());
                if(!seen.contains(collect)) {
                    final List<Integer> integers = new ArrayList<>();
                    elements.forEach(integer -> integers.add(integer));
                    result.add(integers);
                    seen.add(collect);
                }

            }
            return;
        } else if (target < 0) {
            return;
        } else {
            for(int i = 0; i < items.size(); i++) {
                int newTarget = target - items.get(i);
                elements.add(items.get(i));
                List<Integer> items2 = new ArrayList<>();
                for(int j = i+1; j< items.size(); j++) {
                    items2.add(items.get(j));
                }
                findSum(items2, newTarget, elements, result);
                elements.remove(elements.size()-1);
            }
        }
    }
}
