import java.util.*;
/*
 * @lc app=leetcode id=582 lang=java
 *
 * [582] Kill Process
 */
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < pid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new HashSet<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        Set<Integer> ans = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while(queue.size() > 0) {
            int tmp = queue.poll();
            if(ans.contains(tmp)) {
                continue;
            }
            ans.add(tmp);
            for(int i:map.getOrDefault(tmp, new HashSet<>())) {
                queue.offer(i);
            }
        }
        return new ArrayList<Integer>(ans);
        
    }
}

