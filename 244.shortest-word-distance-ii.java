import java.util.*;
/*
 * @lc app=leetcode id=244 lang=java
 *
 * [244] Shortest Word Distance II
 */
class WordDistance {
    Map<String, Set<Integer>> mp;
    public WordDistance(String[] words) {
        mp = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            mp.put(words[i], mp.getOrDefault(words[i], new HashSet<>()));
            mp.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        Set<Integer> a = mp.get(word1);
        Set<Integer> b = mp.get(word2);
        int min = Integer.MAX_VALUE;
        for(Integer i:a){
            for(Integer j:b){
                min = Math.min(Math.abs(i - j), min);
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

