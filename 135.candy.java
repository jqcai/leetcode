/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */
class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 0){
            return 0;
        }
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
            int j = ratings.length - 1 - i;
            if(ratings[j] > ratings[j + 1]){
                right[j] = right[j + 1] + 1;
            }
        }
        int sum = 0;
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        for(int i = 0; i < ratings.length; i++){
            sum += Math.max(left[i], right[i]) + 1;
        }
        return sum;
    }
}

