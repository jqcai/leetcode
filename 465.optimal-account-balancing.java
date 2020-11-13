import java.util.*;

/*
 * @lc app=leetcode id=465 lang=java
 *
 * [465] Optimal Account Balancing
 */
class Solution {
    int count = 0;
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> balance = new HashMap<>();
        for (int[] transaction : transactions) {
            balance.put(transaction[0], balance.getOrDefault(transaction[0], 0) + transaction[2]);
            balance.put(transaction[1], balance.getOrDefault(transaction[1], 0) - transaction[2]);
        }
        int groupSize = 2;
        // System.out.println(balance.toString());
        Set<Integer> st = new HashSet<>();
        for(int b:balance.keySet()){
            if(balance.get(b) == 0){
                st.add(b);
            }
        }
        for(int b:st){
            balance.remove(b);
        }
        while(balance.size() > 0){
            // System.out.println(groupSize);
            while(backtracking(new HashSet<>(), 0, balance, groupSize)){
                
            }
            groupSize++;
        }
        return count;
    }

    private boolean backtracking(Set<Integer> st, int sum, Map<Integer, Integer> mp, int k){
        // System.out.println(st.toString());
        // System.out.println(sum);
        // System.out.println(k);
        if(st.size() == k && sum == 0){
            count += k - 1;
            // System.out.println(count);
            for(int d:st){
                mp.remove(d);
            }
            st.clear();
            return true;
        }else if(st.size() == k){
            return false;
        }else{
            for(int i:mp.keySet()){
                if(!st.contains(i)){
                    st.add(i);
                    if(backtracking(st, sum + mp.get(i), mp, k)){
                        return true;
                    }
                    st.remove(i);
                }
            }
        }
        return false;
    }
}
