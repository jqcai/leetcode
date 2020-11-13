import java.util.*;

/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new LinkedList<>();
        if (words.length == 0) {
            return ans;
        }
        Map<String, Integer> dict = new HashMap<>();
        for (String str : words) {
            dict.put(str, dict.getOrDefault(str, 0) + 1);
        }
        int len = words[0].length();
        for (int i = 0; i <= s.length() - words.length * len; i++) {
            if (checkIfExist(dict, s, i, len)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean checkIfExist(Map<String, Integer> dict, String s, int pos, int len) {
        // System.out.println(pos);
        if (dict.isEmpty()) {
            return true;
        }
        String sub = s.substring(pos, pos + len);
        if (dict.containsKey(sub)) {
            if (dict.get(sub) == 1) {
                dict.remove(sub);
            } else {
                dict.replace(sub, dict.get(sub) - 1);
            }
            if (checkIfExist(dict, s, pos + len, len)) {
                dict.put(sub, dict.getOrDefault(sub, 0) + 1);
                return true;
            }
            dict.put(sub, dict.getOrDefault(sub, 0) + 1);
        }
        return false;
    }
}