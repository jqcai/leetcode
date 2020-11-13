import java.util.*;
/*
 * @lc app=leetcode id=245 lang=java
 *
 * [245] Shortest Word Distance III
 */
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1) && hm.containsKey(word2)){
                min = Math.min(min, i - hm.get(word2));
            }else if(words[i].equals(word2) && hm.containsKey(word1)){
                min = Math.min(min, i - hm.get(word1));
            }
            hm.put(words[i], i);
        }
        return min;
    }
}

