import java.util.*;

/*
 * @lc app=leetcode id=159 lang=java
 *
 * [159] Longest Substring with At Most Two Distinct Characters
 */
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        int p1 = 0, p2 = 0;
        char[] ch = s.toCharArray();
        Map<Character, Integer> hm = new HashMap<>();
        while(p2 < ch.length){
            hm.put(ch[p2], hm.getOrDefault(ch[p2], 0) + 1);
            p2 ++;
            if(hm.size() < 3){
                max = Math.max(p2 - p1, max);
            }else{
                while(hm.size() > 2 && p1 < p2){
                    if(hm.get(ch[p1]) == 1){
                        hm.remove(ch[p1]);
                    }else{
                        hm.put(ch[p1], hm.get(ch[p1]) - 1);
                    }
                    p1++;
                }
                max = Math.max(p2 - p1, max);
            }
        }
        return max;
    }
}

