import java.util.LinkedList;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ans = new LinkedList<>();
        int i = 0;
        for(; i < intervals.length; i++){
            if(intervals[i][1] < newInterval[0]){
                ans.add(intervals[i]);
            }else break;
        }
        if(i == intervals.length){
            ans.add(newInterval);
            return ans.toArray(new int[ans.size()][2]);
        }
        int start = Math.min(intervals[i][0], newInterval[0]);
        int finish = newInterval[1];
        for(; i < intervals.length; i ++){
            if(intervals[i][0] <= newInterval[1]){
                finish = Math.max(finish, intervals[i][1]);
            }else{
                break;
            }
        }
        ans.add(new int[]{start, finish});
        for(; i < intervals.length; i++){
            ans.add(intervals[i]);
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}

