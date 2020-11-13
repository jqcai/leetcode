import java.util.*;

/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int multi = Math.max(m, n) + 1;
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Map<Integer, Integer> visited = new HashMap<>();
        int[] inEdge = new int[m * multi + n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    if (i + dir[0] >= 0 && i + dir[0] < m && j + dir[1] >= 0 && j + dir[1] < n) {
                        if (matrix[i][j] < matrix[i + dir[0]][j + dir[1]]) {
                            inEdge[i * multi + j]++;
                        }
                    }
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        // for (int i = 0; i < inEdge.length; i++) {
        //     if (inEdge[i] == 0) {
        //         queue.offer(i);
        //         // visited.put(i, 1);
        //     }
        // }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(inEdge[i * multi + j] == 0){
                    queue.offer(i * multi + j);
                }
            }
        }
        int maxLen = 1;
        while (queue.size() > 0) {
            int i = queue.poll();
            int x = i / multi;
            int y = i % multi;
            int len  = 1;
            // System.out.println(i);
            for (int[] dir : dirs) {
                if (x + dir[0] >= 0 && x + dir[0] < m && y + dir[1] >= 0 && y + dir[1] < n) {
                    // System.out.println((x + dir[0]) + " " + (y+dir[1]) + " " + x  + " "+ y + " " + multi);
                    int j = (x + dir[0]) * multi + y + dir[1];
                    if(matrix[x + dir[0]][y + dir[1]] > matrix[x][y]){
                        len = Math.max(len, visited.get(j) + 1);
                    }else if(matrix[x + dir[0]][y + dir[1]] < matrix[x][y]){
                        inEdge[j] --;
                        if(inEdge[j] == 0){
                            queue.offer(j);
                        }
                    }
                }
            }
            maxLen = Math.max(len, maxLen);
            visited.put(i, Math.max(visited.getOrDefault(i, 0), len));
        }
        return maxLen;
    }
}
