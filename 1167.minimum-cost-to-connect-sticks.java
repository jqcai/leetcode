import java.util.*;

/*
 * @lc app=leetcode id=1167 lang=java
 *
 * [1167] Minimum Cost to Connect Sticks
 */
class Solution {
    public int connectSticks(int[] sticks) {
        Queue<Integer> heap = new PriorityQueue<>();
        for(int i:sticks){
            heap.add(i);
        }
        int ans = 0;
        while(heap.size() > 1){
            int sum = heap.poll() + heap.poll();
            ans += sum;
            heap.offer(sum);
        }
        return ans;
    }
}

