/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0){
            return -1;
        }
        int[] res =  new int[gas.length];
        for(int i = 0; i < gas.length; i ++){
            res[i] = gas[i] - cost[i];
        }
        int pos = -1;
        int max = -1;
        int sum = 0;
        for(int i = res.length - 1; i >= 0; i--){
            // System.out.println(sum);
            sum += res[i];
            if(sum > max){
                pos = i;
                max = sum;
            }
        }
        if(sum < 0){
            return -1;
        }
        return pos;
    }
}

