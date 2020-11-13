import java.util.*;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        // st.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (st.isEmpty() || heights[i] > heights[st.peek()]) {
                st.push(i);
                continue;
            }

        }
    }
}
