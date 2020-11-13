/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */
import java.util.*;
class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('0');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode tmp = root;
        for(char c:word.toCharArray()){
            tmp.sons.put(c, tmp.sons.getOrDefault(c, new TrieNode(c)));
            // tmp.ch = c;
            tmp = tmp.sons.get(c);
        }
        tmp.end = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(TrieNode root, String word){
        if(word.length() == 0 && root.end == true){
            return true;
        }else if(word.length() == 0){
            return false;
        }else{
            char c = word.charAt(0);
            String sub = word.substring(1,word.length());
            if(c == '.'){
                for(Character ch:root.sons.keySet()){
                    if(search(root.sons.get(ch), sub)){
                        return true;
                    }
                }
                return false;
            }else{
                if(root.sons.containsKey(c) && search(root.sons.get(c), sub)){
                    return true;
                }
                return false;
            }
        }
        
    }


    private class TrieNode{
        // char ch;
        Map<Character, TrieNode> sons;
        boolean end;
        public TrieNode(char _ch){
            // ch = _ch;
            end = false;
            sons = new HashMap<>();
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

