import java.util.*;
/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        List<int[]> ls = new ArrayList<>();
        for(int[] pair:pairs){
            ls.add(pair);
        }
        Collections.sort(ls, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        int[] dp = new int[ls.size() + 1];
        for(int i = 0; i < ls.size(); i++){
            
        }
    }
}

