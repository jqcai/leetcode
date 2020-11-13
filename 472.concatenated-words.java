import java.util.*;
/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 */
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> ans = new HashSet<>();
        Set<String> dict = new HashSet<>();
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return a.length() - b.length();
            }
            
        });
        for(String w:words){
            if(find(dict, w)){
                ans.add(w);
                // System.out.println(1);
            }
            dict.add(w);
        }
        // System.out.println(dict.toString());
        return new LinkedList<>(ans);


    }
    private boolean find(Set<String> dict, String s){
        if(dict.contains(s)){
            return true;
        }
        else{
            for(int i = 1; i < s.length(); i++){
                if(dict.contains(s.substring(0,i)) && find(dict, s.substring(i, s.length()))){
                    dict.add(s);
                    return true;
                }
            }
        }
        return false;
    }
}

