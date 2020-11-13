import java.util.*;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */
class Solution {
    int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new LinkedList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words.length == 0) {
            return ans;
        }
        Set<String> st = new HashSet<>();
        TrieNode root = new TrieNode('0');
        for (String word : words) {
            root.addString(new StringBuilder(word));
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    // sb.append(board[i][j]);
                    backtracking(st, sb, board, root.children[board[i][j] - 'a'], i, j);
                    // sb.deleteCharAt(0);
                }
            }
        }
        return new LinkedList<>(st);
    }

    public void backtracking(Set<String> ans, StringBuffer sb, char[][] board, TrieNode root, int i, int j) {
        // System.out.println(sb.toString());
        int m = board.length;
        int n = board[0].length;
        char tmp = board[i][j];
        sb.append(tmp);
        board[i][j] = '.';
        if (root.end == true) {
            ans.add(sb.toString());
        }
        for (int[] dir : dirs) {
            if (i + dir[0] >= 0 && i + dir[0] < m && j + dir[1] >= 0 && j + dir[1] < n) {
                char t = board[i + dir[0]][j + dir[1]];
                if (Character.isLowerCase(t) && root.children[t - 'a'] != null) {
                    // sb.append(t);
                    // board[i + dir[0]][j + dir[1]] = '.';
                    backtracking(ans, sb, board, root.children[t - 'a'], i + dir[0], j + dir[1]);
                    // board[i + dir[0]][j + dir[1]] = t;
                    // sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        board[i][j] = tmp;
        return;
    }

    public class TrieNode {
        boolean end;
        TrieNode[] children;
        char c;

        public TrieNode(char c) {
            end = false;
            children = new TrieNode[26];
            this.c = c;
        }

        public boolean addString(StringBuilder sb) {
            if (sb.length() == 0) {
                end = true;
            } else {
                char tmp = sb.charAt(0);
                sb.deleteCharAt(0);
                if (children[tmp - 'a'] == null) {
                    children[tmp - 'a'] = new TrieNode(tmp);
                }
                children[tmp - 'a'].addString(sb);
            }
            return true;
        }
    }
}
