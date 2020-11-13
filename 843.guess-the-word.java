import java.util.*;

/*
 * @lc app=leetcode id=843 lang=java
 *
 * [843] Guess the Word
 */
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Map<String, Integer> mp = new HashMap<>();
        int count = 10;
        boolean guess;
        for(String w:wordlist){
            guess = true;
            for(String record:mp.keySet()){
                if(compare(w, record) != mp.get(record)){
                    guess = false;
                    break;
                }
            }
            if(guess){
                mp.put(w, master.guess(w));
                System.out.println(w);
                count --;
                if(count == 10){
                    break;
                }
            }
        }
        return;
    }
    public int compare(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == b.charAt(i)){
                count ++;
            }  
        }
        return count;
    }
}

