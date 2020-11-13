import java.util.*;

/*
 * @lc app=leetcode id=909 lang=java
 *
 * [909] Snakes and Ladders
 */
class Solution {
    public int snakesAndLadders(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return 0;
        }
        int m = board.length;
        int dest = m * m;
        int[][] bfs = new int[m][m];
        Queue<Integer> queue = new LinkedList<>();
        bfs[m - 1][0] = 1;
        queue.offer(1);
        while(!queue.isEmpty()){
            int index = queue.poll();
            // System.out.println(index);
            int[] pos = calculateIndex(index, m);
            int times = bfs[pos[0]][pos[1]];
            if(index == dest) {
                return bfs[pos[0]][pos[1]] - 1;
            }
            for(int i = 1; i <= 6 && i + index <= dest; i++) {
                int[] posI = calculateIndex(index + i, m);
                if(board[posI[0]][posI[1]] != -1) {
                    posI = calculateIndex(board[posI[0]][posI[1]], m);
                }
                if(bfs[posI[0]][posI[1]] != 0){
                    continue;
                }
                bfs[posI[0]][posI[1]] = times + 1;
                queue.offer(calculatePos(posI, m));
            }
        }
        return -1;
    }

    private int[] calculateIndex(int index, int m){
        int i = (index - 1) / m;
        int j = (index - 1) % m;
        j = i % 2 == 0 ? j : (m - 1 - j);
        i = m - 1 - i;
        return new int[]{i, j};
    }
    private int calculatePos(int[] pos, int m){
        int i = pos[0], j = pos[1];
        if((m - i) % 2 == 0) {
            j = m - 1 - j;
        }
        i = m - 1 - i;
        return m * i + j + 1;
    }
}

