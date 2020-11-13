import java.util.*;

/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tmp = root;
        for(char c:word.toCharArray()){
            if(!tmp.sons.containsKey(c)){
                tmp.sons.put(c,new TrieNode(c));
            }
            tmp = tmp.sons.get(c);
        }
        tmp.end_point = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tmp = root;
        for(char c:word.toCharArray()){
            if(!tmp.sons.containsKey(c)){
                return false;
            }
            tmp = tmp.sons.get(c);
        }
        return tmp.end_point;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        // System.out.println(prefix);
        for(char c:prefix.toCharArray()){
            // System.out.println(tmp.ch);
            if(!tmp.sons.containsKey(c)){
                return false;
            }
            tmp = tmp.sons.get(c);
        }
        return true;
    }
    
    private class TrieNode{
        public boolean end_point;
        public char ch;
        public Map<Character, TrieNode> sons;
        public TrieNode(char _ch){
            sons = new HashMap<>();
            ch = _ch;
            end_point = false;
            return;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

