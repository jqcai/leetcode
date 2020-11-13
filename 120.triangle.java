import java.util.*;
/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 ) {
            return 0;
        }
        int[] length = new int[triangle.size()];
        Arrays.fill(length, Integer.MAX_VALUE);
        length[0] = 0;
        for(List<Integer> ls:triangle){
            int s = ls.size();
            if(s == 1) {
                length[0] = ls.get(0);
                continue;
            }
            for(int i = s - 1; i > 0; i--) {
                length[i] = Math.min(length[i], length[i - 1]) + ls.get(i);
            }
            length[0] = length[0] + ls.get(0);
        }
        int min = Integer.MAX_VALUE;
        for(int i:length){
            min = Math.min(min, i);
        }
        return min;
    }
}

