import java.util.LinkedList;

/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */
class Solution {
    public String removeDuplicates(String S) {
        StringBuffer sb = new StringBuffer();
        for(char ch:S.toCharArray()) {
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == ch){
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}

