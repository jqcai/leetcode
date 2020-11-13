import java.util.*;
/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        UF uf = new UF(nums.length);
        Map<Integer, Integer> reverse = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (reverse.containsKey(nums[i])) {
                continue;
            }
            reverse.put(nums[i], i);
            if (reverse.containsKey(nums[i] - 1)) {
                uf.union(i, reverse.get(nums[i] - 1));
            }
            if (reverse.containsKey(nums[i] + 1)) {
                uf.union(i, reverse.get(nums[i] + 1));
            }
        }
        int max = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (Integer reverseKey : reverse.keySet()) {
            int f = uf.find(reverse.get(reverseKey));
            count.put(f, count.getOrDefault(f, 0) + 1);
        }
        for (Integer c : count.keySet()) {
            max = Math.max(count.get(c), max);
        }
        return max;
    }

    public class UF {
        int[] unionFind;

        public UF(int size) {
            unionFind = new int[size];
            for (int i = 0; i < unionFind.length; i++) {
                unionFind[i] = i;
            }
        }

        public int find(int n) {
            if (unionFind[n] != n) {
                unionFind[n] = find(unionFind[n]);
            }
            return unionFind[n];
        }

        public int union(int m, int n) {
            if (find(m) != find(n)) {
                unionFind[find(m)] = n;
            }
            return find(m);
        }
    }
}
