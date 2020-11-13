import java.util.*;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int count  = 0;
        int[] dict = new int[26];
        List<Integer> ls = new LinkedList<Integer>();
        if(s.length() < p.length()){
            return ls;
        }
        for(char ch:p.toCharArray()){
            if(dict[ch - 'a'] == 0){
                count ++;
            }
            dict[ch - 'a'] ++;
        }
        int p1 = 0, p2 = 0;
        for(; p2 < p.length() - 1; p2++){
            int tmp = --dict[s.charAt(p2) - 'a'];
            // System.out.println(tmp);
            if (tmp == 0){
                count --;
            }
            if(tmp == -1){
                count ++;
            }
        }
        // System.out.println(count);
        // System.out.println(Arrays.toString(dict));
        while(p2 < s.length()){
            int tmp = (--dict[s.charAt(p2) - 'a']);
            p2++;
            if (tmp == 0){
                count --;
            }
            if(tmp == -1){
                count ++;
            }
            if(count == 0){
                ls.add(p1);
            }
            tmp = (++dict[s.charAt(p1) - 'a']);
            if(tmp == 0){
                count --;
            }
            if(tmp == 1){
                count ++;
            }
            p1++;
        }
        return ls;
    }
}

