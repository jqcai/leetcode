import java.util.*;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dirs = new int[] { 0, 1, 0, -1, 0 };
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }
        int count = 1;
        while (queue.size() > 0) {
            for (int i = queue.size(); i > 0; i--) {
                int[] pos = queue.poll();
                if (pos[0] < 0 || pos[0] >= m || pos[1] < 0 || pos[1] >= n) {
                    continue;
                }
                if (matrix[pos[0]][pos[1]] < 0) {
                    continue;
                }
                matrix[pos[0]][pos[1]] = -count;
                for (int j = 1; j < 5; j++) {
                    queue.offer(new int[] { pos[0] + dirs[j - 1], pos[1] + dirs[j] });
                }
            }
            count++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1 - matrix[i][j];
            }
        }
        return matrix;
    }
}
