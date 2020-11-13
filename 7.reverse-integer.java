import java.util.*;

/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */
class Solution {
    public int reverse(int x) {
        long max = (long) Integer.MAX_VALUE;
        long min = (long) Integer.MIN_VALUE;
        boolean negative = x < 0;
        long value = Math.abs((long) x);
        List<Long> ls = new LinkedList<>();
        long ans = 0;
        while (value > 0) {
            ls.add(value % 10);
            value /= 10;
        }
        for (long i : ls) {
            ans = ans * 10 + i;
        }
        ans = negative ? -ans : ans;
        if (ans > max || ans < min) {
            return 0;
        }
        return (int) ans;
    }
}
