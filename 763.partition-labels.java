import java.util.*;
/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        Stack<Integer> breakPoint = new Stack<>();
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        breakPoint.push(-1);
        for(int i = 0; i < S.length(); i ++){
            char c = S.charAt(i);
            if(lastSeen[c - 'a'] == -1){
                lastSeen[c - 'a'] = i;
                breakPoint.push(i);
            }else{
                while(breakPoint.peek() >= lastSeen[c - 'a']){
                    breakPoint.pop();
                }
                breakPoint.push(i);
                lastSeen[c - 'a'] = i;
            }
        }
        LinkedList<Integer> ans = new LinkedList<>();
        while(breakPoint.peek() != -1){
            ans.addFirst(breakPoint.pop() - breakPoint.peek());
        }
        return ans;
    }
}

