import java.util.*;
/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        int n1 = 0, n2 = 0, c1 = 0, c2 = 0;
        for(int n:nums){
            if(n == n1){
                c1++;
            }else if(n == n2){
                c2++;
            }else if(c1 == 0){
                n1 = n;
                c1 = 1;
            }else if(c2 == 0){
                n2 = n;
                c2 = 1;
            }else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int n:nums){
            if(n1 == n){
                c1++;
            }else if(n2 == n){
                c2++;
            }
        }
        if(c1 > (nums.length/3)){
            ans.add(n1);
        }
        if(c2 > (nums.length/3)){
            ans.add(n2);
        }
        return ans;
    }
}

