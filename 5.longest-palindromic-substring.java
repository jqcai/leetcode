import java.util.*;

/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */
class Solution {
    public String longestPalindrome(String s) {
        if(s == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for(char ch:s.toCharArray()){
            sb.append(ch);
            sb.append('#');
        }
        char[] charArray = new char[sb.length()];
        sb.getChars(0, sb.length(), charArray, 0);
        int[] manacher = new int[charArray.length];
        Arrays.fill(manacher, 1);
        int farest = 0;
        int pos = -1;
        for(int i = 0; i < manacher.length; i++){
            int rl = 0;
            if(i < farest && 2 * pos - i >= 0){
                int pre = 2 * pos - i;
                rl = Math.min(manacher[pre], farest - i);
            }
            while(i + rl < manacher.length && i >= rl){
                if(charArray[i + rl] == charArray[i - rl]){
                    rl ++;
                }else break;
            }
            manacher[i] = rl;
            if(farest < i + rl){
                farest = i + rl;
                pos = i;
            }
        }
        int maxPos = 0;
        for(int i = 0; i < manacher.length; i++){
            if(manacher[maxPos] < manacher[i]){
                maxPos = i;
            }
        }
        // System.out.println(maxPos);
        sb = new StringBuilder();
        for(int i = maxPos - manacher[maxPos] + 1; i<= maxPos + manacher[maxPos] - 1; i++){
            if(charArray[i] != '#')
                sb.append(charArray[i]);
        }
        return sb.toString();



    }
}

