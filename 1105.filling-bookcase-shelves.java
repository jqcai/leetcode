import java.util.Arrays;

/*
 * @lc app=leetcode id=1105 lang=java
 *
 * [1105] Filling Bookcase Shelves
 */
class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < books.length; i++){
            int curWidth = 0;
            int curHeight = 0;
            for(int j = i; j >= 0; j--){
                curWidth += books[j][0];
                if(curWidth > shelf_width){
                    break;
                }
                curHeight = Math.max(curHeight, books[j][1]);
                dp[i + 1] = Math.min(curHeight + dp[j], dp[i + 1]);
            }
        }
        return dp[dp.length - 1];
    }
}
