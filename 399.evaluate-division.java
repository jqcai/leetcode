import java.util.*;

/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Set<String> node = new HashSet<>();
        Map<String, Map<String, Double>> hm = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> ls = equations.get(i);
            String first = ls.get(0);
            String second = ls.get(1);
            double val = values[i];
            hm.putIfAbsent(first, new HashMap<>());
            hm.putIfAbsent(second, new HashMap<>());
            // node.add(first);
            // node.add(second);
            hm.get(first).put(second, val);
            hm.get(second).put(first, 1 / val);
        }
        if (queries.size() == 0) {
            return new double[] {};
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> ls = queries.get(i);
            String first = ls.get(0);
            String second = ls.get(1);
            if (!hm.containsKey(first) || !hm.containsKey(second)) {
                ans[i] = -1;
                continue;
            }
            if (hm.get(first).containsKey(second)) {
                ans[i] = hm.get(first).get(second);
                continue;
            }
            ans[i] = -1;
            Queue<String> queue = new LinkedList<>();
            Queue<Double> div = new LinkedList<>();
            queue.offer(first);
            div.offer(1.);
            Set<String> visited = new HashSet<>();
            while (queue.size() > 0) {
                String traverse = queue.poll();
                double d = div.poll();
                if (visited.contains(traverse)) {
                    continue;
                }
                visited.add(traverse);
                hm.get(first).put(traverse, d);
                hm.get(traverse).put(first, 1 / d);
                if (traverse.equals(second)) {
                    ans[i] = d;
                    break;
                }
                for(String t:hm.get(traverse).keySet()){
                    queue.offer(t);
                    div.offer(d * hm.get(traverse).get(t));
                }
            }
        }
        return ans;
    }
}
