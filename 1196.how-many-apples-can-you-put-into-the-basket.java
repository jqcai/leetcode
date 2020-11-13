import java.util.Arrays;

/*
 * @lc app=leetcode id=1196 lang=java
 *
 * [1196] How Many Apples Can You Put into the Basket
 */
class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int count = 0;
        for(int i:arr) {
            sum += i;
            if(sum > 5000){
                return count;
            }
            count ++;
        }
        return count;
    }
}

