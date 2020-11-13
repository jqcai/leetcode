/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0|| matrix[0].length == 0){
            return 0;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == '1'){
                    dp[i+1][j] = 0;
                }else{
                    dp[i+1][j] = dp[i][j] + 1;
                }
            }
        }
        return 0;
    }
}

