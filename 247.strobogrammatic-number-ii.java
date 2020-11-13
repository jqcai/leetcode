/*
 * @lc app=leetcode id=247 lang=java
 *
 * [247] Strobogrammatic Number II
 */
class Solution {
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n, true);
    }
    private List<String> findStrobogrammatic(int n, boolean out){
        List<String> ans = new LinkedList<>();
        if(n == 0 && out == false){
            ans.add("");
            return ans;
        }else if(n == 1){
            ans.add("1");
            ans.add("8");
            ans.add("0");
            return ans;
        }
        List<String> pre = findStrobogrammatic(n - 2, false);
        for(String p:pre){
            ans.add(1+p+1);
            ans.add(8+p+8);
            ans.add(6+p+9);
            ans.add(9+p+6);
            if(out == false){
                ans.add(0+p+0);
            }
        }
        return ans;
    }
}

