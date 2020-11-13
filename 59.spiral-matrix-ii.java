/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */
class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 0){
            return new int[][]{{}};
        }
        int[][] ans = new int[n][n];
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int i = 1;
        int x = 0, y = -1;
        while(i <= n * n){
            for(int[] dir:dirs){
                // System.out.println("start");
                while(x+dir[0]<n&&(x+dir[0]>=0)&&y+dir[1]<n&&(y+dir[1]>=0)&&ans[x+dir[0]][y+dir[1]] == 0){
                        ans[x+dir[0]][y+dir[1]] = i;
                        x += dir[0];
                        y += dir[1];
                        // System.out.println(x+ " " + y);
                        // System.out.println(Arrays.toString(dir));
                        i++;
                    }
            }
        }
        return ans;
    }
}

