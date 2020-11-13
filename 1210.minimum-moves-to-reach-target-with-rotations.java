import java.util.*;

/*
 * @lc app=leetcode id=1210 lang=java
 *
 * [1210] Minimum Moves to Reach Target with Rotations
 */

// @lc code=start
class Solution {
    public int minimumMoves(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int move = 0;
        queue.add(new int[] { 0, 0, 0, 1 });
        while (queue.size() > 0) {
            for (int i = queue.size(); i > 0; i--) {
                int[] bfs = queue.poll();
                // System.out.println(Arrays.toString(bfs));
                if (visited.contains((bfs[0] << 21) + (bfs[1] << 14) + (bfs[2] << 7) + bfs[3])) {
                    continue;
                }
                visited.add((bfs[0] << 21) + (bfs[1] << 14) + (bfs[2] << 7) + bfs[3]);
                if (bfs[0] == n - 1 && bfs[1] == n - 2 && bfs[2] == n - 1 && bfs[3] == n - 1) {
                    return move; // reach end
                }
                if (bfs[2] == n || bfs[3] == n) {
                    continue;
                }
                if (grid[bfs[0]][bfs[1]] == 1 || grid[bfs[2]][bfs[3]] == 1) {
                    continue;
                }
                queue.offer(new int[] { bfs[0], bfs[1] + 1, bfs[2], bfs[3] + 1 });
                queue.offer(new int[] { bfs[0] + 1, bfs[1], bfs[2] + 1, bfs[3] });
                if (bfs[0] == bfs[2] && bfs[0] < n - 1 && grid[bfs[0] + 1][bfs[1] + 1] == 0) { // horizontal
                    queue.offer(new int[] { bfs[0], bfs[1], bfs[0] + 1, bfs[1] });
                } else if (bfs[1] == bfs[3] && bfs[1] < n - 1 && grid[bfs[0] + 1][bfs[1] + 1] == 0) { // vertical
                    queue.offer(new int[] { bfs[0], bfs[1], bfs[0], bfs[1] + 1 });
                }
            }
            move++;
        }
        return -1;
    }
}
// @lc code=end
