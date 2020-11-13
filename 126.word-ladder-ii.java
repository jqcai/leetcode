import java.util.*;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        List<List<String>> ans = new LinkedList<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        int count = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        String s = null;
        // boolean find = false;
        out: while (queue.size() > 0) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                s = queue.poll();
                if(visited.contains(s)){
                    continue;
                }
                visited.add(s);
                distance.put(s, count);
                if (s.equals(endWord)) {
                    // find = true;
                    break out;
                }
                StringBuilder sb = new StringBuilder(s);
                for (int j = 0; j < sb.length(); j++) {
                    char tmp = sb.charAt(j);
                    for (char k = 'a'; k <= 'z'; k++) {
                        sb.setCharAt(j, k);
                        String t = sb.toString();
                        if (set.contains(t) && !visited.contains(t)) {
                            graph.put(s, graph.getOrDefault(s, new HashSet<>()));
                            graph.get(s).add(t);
                            queue.add(t);
                        }
                    }
                    sb.setCharAt(j, tmp);
                }
            }
            count++;
        }
        if (s == null || !s.equals(endWord)) {
            return ans;
        }
        // System.out.println(graph.toString());
        dfs(ans, new ArrayList<>(), beginWord, endWord, new HashSet<>(), new HashSet<>(wordList), count, graph, distance);
        return ans;

    }

    private void dfs(List<List<String>> ans, List<String> ls, String midWord, String endWord, Set<String> visited,
            Set<String> dict, int count, Map<String, Set<String>> graph, Map<String, Integer> distance) {
        ls.add(midWord);
        // visited.add(midWord);
        // System.out.println(ls.toString());
        if (ls.size() == count && midWord.equals(endWord)) {
            ans.add(new ArrayList<>(ls));
        }else if(ls.size() < count && graph.containsKey(midWord)){
            for(String tmp:graph.get(midWord)){
                // if(!visited.contains(tmp)){
                if(distance.containsKey(tmp) && distance.get(tmp) - distance.get(midWord) == 1)
                dfs(ans, ls, tmp, endWord, visited, dict, count, graph, distance);
                // }
            }
        }
        ls.remove(ls.size() - 1);
        return;

    }
}
