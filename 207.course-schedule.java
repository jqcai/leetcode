import java.util.*;
/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }
        Map<Integer, Set<Integer>> hm = new HashMap<>();
        int[] inEdge = new int[numCourses];
        for(int[] pre:prerequisites){
            hm.put(pre[0], hm.getOrDefault(pre[0], new HashSet<>()));
            hm.get(pre[0]).add(pre[1]);
            inEdge[pre[1]] ++;
        }
        label:while(hm.size() > 0){
            for(Integer i:hm.keySet()){
                if(inEdge[i] == 0){
                    for(Integer j:hm.get(i)){
                        inEdge[j] --;
                    }
                    hm.remove(i);
                    continue label;
                }
            }
            break;
        }
        return hm.size() == 0;
        
    }
}


