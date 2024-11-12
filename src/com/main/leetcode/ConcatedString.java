package com.main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 */
public class ConcatedString {
    public static void main(String[] args) {
        findSubstring("bar", new String[]{"b,a,r"}).forEach(System.out::println);
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        int i=0;
        int sl = words[0].length();
        while(i < s.length()) {
            String str = s.substring(i, sl);
            break;
        }
        return indexes;
        // incomplete implementation
    }
}
