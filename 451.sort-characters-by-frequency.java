import java.util.*;

/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */
class Solution {
    public String frequencySort(String s) {
        int[] count = new int[256];
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        Queue<Integer> heap = new PriorityQueue<>(256, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return count[b] - count[a];
            }
        });
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0)
                heap.offer(i);
        }
        while (!heap.isEmpty()) {
            int ch = heap.poll();
            for (int i = 0; i < count[ch]; i++) {
                ans.append((char) ch);
            }
        }
        return ans.toString();
    }
}
