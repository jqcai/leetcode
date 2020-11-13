import java.util.*;

/*
 * @lc app=leetcode id=1029 lang=java
 *
 * [1029] Two City Scheduling
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        LinkedList<Integer> ls = new LinkedList<>();
        int sum = 0;
        for(int[] cost:costs){
            sum += cost[0];
            ls.add(cost[1] - cost[0]);
        }
        Collections.sort(ls);
        for(int i = 0; i < costs.length / 2; i++){
            sum += ls.poll();
        }
        return sum;
    }
}

