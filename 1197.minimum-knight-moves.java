import java.util.*;
/*
 * @lc app=leetcode id=1197 lang=java
 *
 * [1197] Minimum Knight Moves
 */

class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int[][] dirs = new int[][] { { 1, 2 }, { 2, 1 }, { -1, -2 }, { -2, -1 }, { 1, -2 }, { 2, -1 }, { -1, 2 },
                { 2, -1 } };
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> visited = new HashSet<>(queue);
        for (int i = 0; !queue.isEmpty(); i++) {
            int qs = queue.size();
            for (int j = 0; j < qs; j++) {
                int tmpI = queue.peek() / 301, tmpJ = queue.poll() % 301;
                if (tmpI == x && tmpJ == y)
                    return i;
                for (int[] dir : dirs) {
                    int r = Math.abs(tmpI + dir[0]), c = Math.abs(tmpJ + dir[1]);
                    if (visited.add(r * 301 + c)) {
                        queue.offer(r * 301 + c);
                    }
                }
            }
        }
        return -1;
    }
}
