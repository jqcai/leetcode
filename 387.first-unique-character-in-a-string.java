import java.util.*;

/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, -1);
            }else{
                map.put(ch, i);
            }
        }
        int min = Integer.MAX_VALUE;
        for(char ch:map.keySet()){
            if(map.get(ch) >= 0) {
                min = Math.min(map.get(ch), min);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

