/*
 * @lc app=leetcode id=978 lang=java
 *
 * [978] Longest Turbulent Subarray
 */
class Solution {
    public int maxTurbulenceSize(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = 1;
        int maxLen = 1;
        int pre = A[0];
        boolean type = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > pre) {
                if (type) {
                    len = 1;
                }
                len++;
                maxLen = Math.max(len, maxLen);
                type = true;
                pre = A[i];
            } else if (A[i] < pre) {
                if (!type) {
                    len = 1;
                }
                len++;
                maxLen = Math.max(len, maxLen);
                type = false;
                pre = A[i];
            } else {
                maxLen = Math.max(len, maxLen);
                len = 1;
                pre = A[i];
            }
        }
        return maxLen;

    }
}
