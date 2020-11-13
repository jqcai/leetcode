/*
 * @lc app=leetcode id=340 lang=java
 *
 * [340] Longest Substring with At Most K Distinct Characters
 */
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] ch = new char[256];
        int count = 0;
        int max = 0;
        int p1 = 0;
        int p2 = 0;
        while(p2 < s.length()){
            char tmp = s.charAt(p2);
            if(ch[tmp] == 0){
                count ++;
            }
            ch[tmp] ++;
            while(count > k && p1 <= p2){
                tmp = s.charAt(p1);
                ch[tmp]--;
                if(ch[tmp] == 0){
                    count --;
                }
                p1 ++;
            }
            max = Math.max(max, p2 - p1 + 1);
            p2 ++;
        }
        return max;
    }
}

