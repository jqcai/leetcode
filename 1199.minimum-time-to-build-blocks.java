import java.util.*;
/*
 * @lc app=leetcode id=1199 lang=java
 *
 * [1199] Minimum Time to Build Blocks
 */

class Solution {
    public int minBuildTime(int[] blocks, int split) {
        if (blocks.length == 0) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int block : blocks) {
            queue.offer(block);
        }
        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll() + split);
        }
        return queue.poll();
    }
}
