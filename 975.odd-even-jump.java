import java.util.*;

/*
 * @lc app=leetcode id=975 lang=java
 *
 * [975] Odd Even Jump
 */
class Solution {
    public int oddEvenJumps(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }
        int m = A.length;
        int count = 0;
        LinkedList<Integer> min = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        int[] odd = new int[m];
        int[] even = new int[m];
        for (int i = 0; i < m; i++) {
            while (!max.isEmpty() && A[max.peekLast()] >= A[i]) {

            }
        }
        // return count;
    }
}
