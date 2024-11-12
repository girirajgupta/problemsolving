package com.main.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */
public class CharacterReplacement {
    public static void main(String[] args) {
        StringBuilder input1 = new StringBuilder();
       // System.out.println(Math.max(characterReplacement("ABBB",2),characterReplacement(input1.append("ABBB").reverse().toString(),2)));
        System.out.println(characterReplacement2("AABABBA",1));
    }
    public static int characterReplacement2(String s, int k) {
        int maxLen = 0, maxFreq = 0;
        int l = 0, r = 0;
        int size = s.length();
        Map<Character, Integer> map = new HashMap<>();

            while(r < size){
                char ch = s.charAt(r);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                maxFreq = Math.max(maxFreq, map.get(ch));

                // Shrink window if replacement count exceeds k
                while(((r - l + 1) - maxFreq) > k){
                    char leftChar = s.charAt(l);
                    map.put(leftChar, map.get(leftChar) - 1);
                    if(map.get(leftChar) == 0) map.remove(leftChar);
                    l++;
                }

                // Update max length of valid window
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            }
            return maxLen;
    }
    public static int characterReplacement(String s, int k) {
        int max = 0;
        int count = 0;
        int cc = 0;
        for(int i=0; i < s.length(); i++) {
            final char c = s.charAt(i);
            cc = 1;
            for(int j=i+1; j< s.length(); j++) {
                final char n = s.charAt(j);
                if(n != c) {
                    count++;
                }
                if(count > k) {
                    max = Math.max(max, cc);
                    count = 0;
                    break;
                }
                cc++;
                max = Math.max(max,cc);
            }
        }
        return max;
    }
}
