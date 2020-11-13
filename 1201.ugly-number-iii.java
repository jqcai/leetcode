import java.util.*;

/*
 * @lc app=leetcode id=1201 lang=java
 *
 * [1201] Ugly Number III
 */
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int p1 = 1;
        int p2 = 1;
        int p3 = 1;
        int count = 0;
        while (true) {
            int min = Math.min(a * p1, Math.min(b * p2, c * p3));
            count++;
            if (count == n) {
                return min;
            }
            if(min == p1 * a) {
                p1 ++;
            }
            if(min == p2 * b) {
                p2 ++;
            }
            if(min == p3 * c) {
                p3 ++;
            } 
        }

    }
}
