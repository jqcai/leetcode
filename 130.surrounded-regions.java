import java.util.*;

/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */
class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return;
        }
        UF unionfind = new UF(board.length * board[0].length);
        Set<Integer> edge = new HashSet<>();
        Set<Integer> all = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    if(i > 0 && board[i-1][j] == 'O'){
                        unionfind.union(i*board[0].length + j, (i-1)*board[0].length + j);
                    }
                    if(j > 0 && board[i][j-1] == 'O'){
                        unionfind.union(i*board[0].length + j, i*board[0].length + j - 1);
                    }
                    all.add(unionfind.find(i*board[0].length + j));
                    if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1){
                        edge.add(unionfind.find(i*board[0].length + j));
                    }
                }
            }
        }
        // unionfind.print();
        Set<Integer> edgeFinal = new HashSet<>();
        for(Integer i:edge){
            edgeFinal.add(unionfind.find(i));
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    if(!edgeFinal.contains(unionfind.find(i*board[0].length + j))){
                        board[i][j] = 'X';
                    }
                }
            }
        }
        // unionfind.print();
        return;
    }
    class UF{
        int[] union;
        // int[] size;
        public UF(int x){
            union = new int[x];
            for(int i = 0; i < x; i++){
                union[i] = i;
            }
            // size = new int[]{x, y};
        }
        public int find(int x){
            if(union[x] != x){
                union[x] = find(union[x]);
            }
            return union[x];
        }
        public int union(int x, int y){
            int fx = find(x);
            int fy = find(y);
            if(fx != fy){
                union[fy] = fx;
            }
            return fx;
        }
        public void print(){
            System.out.println(Arrays.toString(union));
            return;
        }
    }
}

