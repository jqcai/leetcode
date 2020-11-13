import java.util.*;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inEdge = new int[numCourses];
        int[] order = new int[numCourses];
        Map<Integer, Set<Integer>> hm = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            inEdge[prerequisite[0]]++;
            hm.put(prerequisite[1], hm.getOrDefault(prerequisite[1], new HashSet<>()));
            hm.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inEdge.length; i++) {
            if (inEdge[i] == 0) {
                q.add(i);
            }
        }
        int pos = 0;
        while (q.size() > 0) {
            int course = q.poll();
            order[pos] = course;
            pos++;
            if (hm.containsKey(course)) {
                for (int after : hm.get(course)) {
                    inEdge[after]--;
                    if (inEdge[after] == 0) {
                        q.add(after);
                    }
                }
                hm.remove(course);
            }
        }
        if (pos == numCourses) {
            return order;
        }
        return new int[]{};
    }
}
