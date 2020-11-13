/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() == 0){
            return false;
        }
        for(int i = 1; i < s.length(); i++){
            if(buildFrom(s, s.substring(0,i))){
                return true;
            }
        }
        return false;
    }
    public boolean buildFrom(String s, String p){
        if(s.length() == 0){
            return true;
        }else if(s.length() % p.length()!=0){
            return false;
        }else if(!s.substring(0, p.length()).equals(p)){
            return false;
        }else{
            return buildFrom(s.substring(p.length()), p);
        }
    }
}

