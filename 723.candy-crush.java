/*
 * @lc app=leetcode id=723 lang=java
 *
 * [723] Candy Crush
 */
class Solution {
    public int[][] board;
    public int m;
    public int n;

    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return board;
        }
        this.board = board;
        m = board.length;
        n = board[0].length;
        crash();
        while (true) {
            if (!drop()) {
                return this.board;
            }
            if (!crash()) {
                return this.board;
            }
        }
    }

    public boolean crash() {
        boolean isCrash = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                if (Math.abs(board[i][j]) == Math.abs(board[i][j + 1])
                        && Math.abs(board[i][j]) == Math.abs(board[i][j + 2])) {
                    isCrash = true;
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -Math.abs(board[i][j]);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m - 2; i++) {
                if (board[i][j] == 0)
                    continue;
                if (Math.abs(board[i][j]) == Math.abs(board[i + 1][j])
                        && Math.abs(board[i][j]) == Math.abs(board[i + 2][j])) {
                    isCrash = true;
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -Math.abs(board[i][j]);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = Math.max(0, board[i][j]);
            }
        }

        return isCrash;
    }

    public boolean drop() {
        boolean isDrop = false;
        for (int j = 0; j < n; j++) {
            int p1 = m - 1, p2 = m - 1;
            while (p2 >= 0) {
                if (board[p2][j] == 0) {
                    p2--;
                    continue;
                }
                if (p1 != p2) {
                    isDrop = true;
                    board[p1][j] = board[p2][j];
                    board[p2][j] = 0;
                }
                p1--;
                p2--;
            }
        }
        return isDrop;
    }
}
