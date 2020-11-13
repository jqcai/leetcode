/*
 * @lc app=leetcode id=201 lang=java
 *
 * [201] Bitwise AND of Numbers Range
 */
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == n){
            return m;
        }
        if(m < n){
            m ^= n;
            n ^= m;
            m ^= n;
        }
        if(n == 0){
            return 0;
        }
        String ms = Integer.toBinaryString(m);
        String ns = Integer.toBinaryString(n);
        if(ms.length() != ns.length()){
            return 0;
        }
        // ms = ms.substring(ms.length() - ns.length(), ms.length());
        StringBuilder ans = new StringBuilder(ms);
        // System.out.println(ans.toString());
        int i = 0;
        for(; i < ns.length(); i ++){
            // System.out.println(i);
            if(ms.charAt(i) != ns.charAt(i)){
                ans.setCharAt(i, '0');
                break;
            }
        }
        for(; i<ns.length(); i++){
            ans.setCharAt(i, '0');
        }
        return Integer.parseInt(ans.toString(),2);
    }
}

