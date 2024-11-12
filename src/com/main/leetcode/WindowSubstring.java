package com.main.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/minimum-window-substring/description/
 */
public class WindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
    public static String minWindow(String s, String t) {
        int l=0,r = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        while(l< t.length()) {
            int c = s.charAt(l);
            freq.put(c, freq.getOrDefault(c,0)+1);
        }
        l=0;
        String result = s + t;
        int seenTotal = 0;
        while(r < t.length()) {
            int c = s.charAt(r);
            if(freq.getOrDefault(c,0) != 0) {
                seenTotal++;
                freq.put(c, freq.get(c)-1);
                if(seenTotal == t.length()) {
                    String newResult = s.substring(l,r);
                    if(newResult.length() < result.length()) {
                        result = newResult;
                    }
                    // move left until we don't remove
                }
            }
            r++;
        }
        return s;
    }
}
