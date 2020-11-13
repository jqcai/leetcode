import java.util.*;

/*
 * @lc app=leetcode id=269 lang=java
 *
 * [269] Alien Dictionary
 */
class Solution {
    public String alienOrder(String[] words) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Character, Set<Character>> hm = new HashMap<>();
        int[] inEdge = new int[26];
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, true);
        StringBuilder dict = new StringBuilder();
        if(words.length > 0){
            for(char c: words[0].toCharArray()){
                visited[c - 'a'] = false;
            }
        }
        for (int i = 1; i < words.length; i++) {
            // System.out.println(i);
            String pre = words[i - 1];
            String now = words[i];
            for (char c : pre.toCharArray()) {
                visited[c - 'a'] = false;
            }
            for (char c : now.toCharArray()) {
                visited[c - 'a'] = false;
            }
            for (int j = 0; j < Math.min(pre.length(), now.length()); j++) {
                char p = pre.charAt(j);
                char n = now.charAt(j);
                if (n != p) {
                    hm.putIfAbsent(p, new HashSet<>());
                    if (!hm.get(p).contains(n)) {
                        inEdge[n - 'a']++;
                        hm.get(p).add(n);
                    }
                    break;
                }
            }
        }
        // System.out.println(1);
        for (int i = 0; i < 26; i++) {
            if (inEdge[i] == 0 && !visited[i]) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        // System.out.println(queue.toString());
        // System.out.println(Arrays.toString(inEdge));
        while (!queue.isEmpty()) {
            int i = queue.poll();
            char tmpC = (char) (i + 'a');
            dict.append(tmpC);
            // System.out.println(tmpC);
            // System.out.println(hm.toString());
            for (char c : hm.getOrDefault(tmpC, new HashSet<>())) {
                inEdge[c - 'a']--;
                if (inEdge[c - 'a'] == 0) {
                    queue.offer(c - 'a');
                }
            }
        }
        for (int i : inEdge) {
            if (i > 0) {
                return "";
            }
        }
        return dict.toString();
    }
}
