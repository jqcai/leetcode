// import java.util.HashSet;
// import java.util.Set;

/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */
class Solution {
    public int longestPalindrome(String s) {
        Set<Character> st = new HashSet<>();
        int count = 0;
        for(char c:s.toCharArray()){
            if(st.contains(c)){
                count += 2;
                st.remove(c);
            }else{
                st.add(c);
            }
        }
        return st.size()>0?count+1:count;
    }
}

