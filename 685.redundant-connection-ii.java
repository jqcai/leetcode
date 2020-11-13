import java.util.*;

/*
 * @lc app=leetcode id=685 lang=java
 *
 * [685] Redundant Connection II
 */
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges.length == 0) {
            return new int[] {};
        }
        if (edges.length == 1) {
            return edges[0];
        }
        int n = edges.length;
        int[] inEdge = new int[n];
        int[] outEdge = new int[n];
        Map<Integer, Map<Integer, Integer>> inMap = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> outMap = new HashMap<>();
        int ind = 0;
        for (int[] edge : edges) {
            inEdge[edge[1] - 1]++;
            outEdge[edge[0] - 1]++;
            inMap.putIfAbsent(edge[1] - 1, new HashMap<>());
            outMap.putIfAbsent(edge[0] - 1, new HashMap<>());
            inMap.get(edge[1] - 1).put(edge[0] - 1, ind);
            outMap.get(edge[0] - 1).put(edge[1] - 1, ind);
            ind++;
        }
        boolean rootCircle = true;
        int root = 0;
        for (int i = 0; i < inEdge.length; i++) {
            if (inEdge[i] == 0) {
                rootCircle = false;
                root = i;
                break;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        if (!rootCircle) {
            // System.out.println(outMap.toString());
            queue.add(root);
            int ansPos = -1;
            int ansNode = -1;
            while (queue.size() > 0) {
                int node = queue.poll();
                // System.out.println(node);
                for (int child : outMap.getOrDefault(node, new HashMap<>()).keySet()) {
                    if (inEdge[child] == 2) {
                        ansNode = child;
                        ansPos = outMap.get(node).get(child);
                        inEdge[child]--;
                    } else if (ansNode != child) {
                        inEdge[child]--;
                        queue.offer(child);
                    } else {
                        ansPos = Math.max(outMap.get(node).get(child), ansPos);
                        inEdge[child] --;
                        break;
                    }
                }
            }
            // System.out.println(Arrays.toString(edges[ansPos]));
            // System.out.println(inMap.toString());
            if(inEdge[ansNode] > 0){
                for(int tmp:inMap.get(ansNode).keySet()){
                    if(tmp != edges[ansPos][0] - 1){
                        return edges[inMap.get(ansNode).get(tmp)];
                    }
                }
            }
            return edges[ansPos];
        }
        for (int i = 0; i < outEdge.length; i++) {
            if (outEdge[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int parent : inMap.get(node).keySet()) {
                outEdge[parent] --;
                if(outEdge[parent] == 0){
                    queue.add(parent);
                }
            }
            inMap.remove(node);
        }
        int ans = 0;
        for(int i:inMap.keySet()){
            for(int j:inMap.get(i).keySet()){
                ans = Math.max(ans, inMap.get(i).get(j));
            }
        }
        return edges[ans];

    }
}
