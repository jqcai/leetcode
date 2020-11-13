import java.util.*;
/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */
class Solution {
    public String minWindow(String s, String t) {
        int[] alphabet = new int[256];
        Map<Character, Integer> hm = new HashMap<>();
        for(char ch:t.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        int count = hm.size();
        int start = 0, end = 0;
        String ans = s + " ";
        while(end < s.length()){
            if(hm.containsKey(s.charAt(end))){
                // System.out.println(s.charAt(end));
                alphabet[s.charAt(end)] ++;
                if(alphabet[s.charAt(end)] == hm.get(s.charAt(end))){
                    count --;
                }
                while(start <= end && count == 0){
                    if(end - start + 1 < ans.length()){
                        ans = s.substring(start, end + 1);
                    }
                    if(hm.containsKey(s.charAt(start))){
                        alphabet[s.charAt(start)]--;
                        if (alphabet[s.charAt(start)] < hm.get(s.charAt(start))) {
                            count ++;
                        }
                    }
                    start ++;
                }
            }
            end++;
        }
        // System.out.println(ans);
        return ans.length() > s.length()?"":ans;
    }
}

