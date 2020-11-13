/*
 * @lc app=leetcode id=1184 lang=java
 *
 * [1184] Distance Between Bus Stops
 */

// @lc code=start
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance.length == 0) {
            return 0;
        }
        if (start < 0 || destination < 0 || start >= distance.length || destination >= distance.length) {
            return 0;
        }
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        int sum = 0;
        int dist = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
            if (i >= start && i < destination) {
                dist += distance[i];
            }
        }
        return Math.min(sum - dist, dist);
    }
}
// @lc code=end
