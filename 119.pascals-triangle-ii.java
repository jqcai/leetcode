import java.util.*;
/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] nas = new int[rowIndex + 1];
        nas[0] = 1;
        for(int i = 0; i < rowIndex; i++){
            for(int j = i + 1; j > 0; j--){
                nas[j] = nas[j] + nas[j - 1];
            }
        }

        List<Integer> ans = new LinkedList<>();
        for(int i:nas){
            ans.add(i);
        }
        return ans;
    }
}

