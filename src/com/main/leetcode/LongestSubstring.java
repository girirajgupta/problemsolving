package com.main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstring("abca"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if("".equals(s)) {
            return 0;
        }
        int index=0;
        int startIndex = -1;
        int length = 0;
        int maxLength = 0;
        Map<String, Integer> unique = new HashMap<>();
        for (String current :s.split("")) {
            if (unique.containsKey(current) && (unique.get(current) > startIndex)) {
                startIndex = unique.get(current);
                unique.put(current, index);
                length = index - startIndex;
                maxLength = Math.max(length, maxLength);
            } else {
                unique.put(current, index);
                length++;
                maxLength = Math.max(length, maxLength);
            }
            index++;
        }
        return maxLength;
    }
}
