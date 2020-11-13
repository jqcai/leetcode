import java.util.*;

/*
 * @lc app=leetcode id=317 lang=java
 *
 * [317] Shortest Distance from All Buildings
 */
class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int minval = Integer.MAX_VALUE;
        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int m = grid.length, n = grid[0].length;
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count ++;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 || grid[i][j] == 2){
                    continue;
                }
                Queue<Integer> queue = new LinkedList<>();
                
            }
        }

    }
}
