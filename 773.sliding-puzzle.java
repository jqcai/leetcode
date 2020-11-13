import java.util.*;

/*
 * @lc app=leetcode id=773 lang=java
 *
 * [773] Sliding Puzzle
 */
class Solution {
    // int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int destination = boardToInt(new int[][] { { 1, 2, 3 }, { 4, 5, 0 } });

    public int slidingPuzzle(int[][] board) {
        Set<Integer> hs = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int move = 0;
        queue.add(boardToInt(board));
        while(queue.size() > 0){
            int count = queue.size();
            for(int i = 0; i < count; i++){
                int b = queue.poll();
                if(b == destination){
                    return move;
                }
                
            }
            move ++;
        }
        return -1;
    }

    public int boardToInt(int[][] board) {
        return (board[0][0] << 15) & (board[0][1] << 12) & (board[0][2] << 9) & (board[1][0] << 6) & (board[1][1] << 3)
                & board[1][2];
    }
    public int swap(int boardInt, int zeroPos, int destinationPos){
        int dest = boardInt & (7 << (destinationPos * 3)) >> (destinationPos * 3);
        boardInt = boardInt - (dest << (destinationPos * 3));
        boardInt = (dest << (zeroPos * 3) | boardInt);
        return boardInt;
    }
}
