import java.util.*;
/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 */
class Solution {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0) {
            return false;
        }else if(stones.length == 1) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < stones.length; i++){
            map.put(stones[i], i);
        }
        Set<Integer>[] jumps = new Set[stones.length];
        for(int i = 0; i < jumps.length; i++){
            jumps[i] = new HashSet<>();
        }
        jumps[0].add(0);
        int dest = stones[stones.length - 1];
        int[] range = new int[]{-1, 0, 1};
        for(int i = 0; i < jumps.length - 1; i++) {
            int pos = stones[i];
            for(int j:jumps[i]){
                for(int k:range) {
                    if(j + k > 0 && map.containsKey(pos + j + k)) {
                        int index = pos + j + k;
                        if(index == dest) {
                            return true;
                        }
                        jumps[map.get(index)].add(j + k);
                    }
                }
            }
        }
        return false;
    }
}

