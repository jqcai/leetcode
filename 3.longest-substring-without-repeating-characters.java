/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] alphabet = new int[256];
        int p1 = 0, p2 = 0;
        int longest = 0;
        while (p2 < s.length()) {
            char ch = s.charAt(p2);
            p2++;
            if (++alphabet[ch] == 1) {
                // System.out.println(p2 - p1);
                longest = Math.max(p2 - p1, longest);
                continue;
            }
            while (p1 < p2) {
                char del = s.charAt(p1);
                p1 ++;
                if(--alphabet[del] == 1) {
                    // System.out.println(p2 - p1);
                    // System.out.println(p1);
                    // System.out.println(p2);
                    longest = Math.max(p2 - p1, longest);
                    break;
                }
            }
        }
        return longest;
    }
}
