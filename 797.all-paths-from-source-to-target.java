import java.util.*;

/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new LinkedList<>();
        if (graph == null || graph.length == 0 || graph[0].length == 0) {
            return ans;
        }
        List<Integer> ls = new ArrayList<>();
        ls.add(0);
        dfs(ans, graph, ls, 0, graph.length - 1);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, int[][] graph, List<Integer> tmp, int preNode, int target) {
        if (preNode == target) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i : graph[preNode]) {
            tmp.add(i);
            dfs(ans, graph, tmp, i, target);
            tmp.remove(tmp.size() - 1);
        }
        return;
    }
}
