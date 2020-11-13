import java.util.Arrays;

/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */
class Solution {
    public String reverseWords(String s) {
        String[] s_array = s.trim().split("\\s+");
        // System.out.println(Arrays.toString(s_array));
        StringBuilder sb = new StringBuilder();
        for(int i = s_array.length - 1; i >= 0; i--){
            sb.append(s_array[i]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}

