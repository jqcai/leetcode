import java.util.*;

/*
 * @lc app=leetcode id=1200 lang=java
 *
 * [1200] Minimum Absolute Difference
 */
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return ans;
        }
        Arrays.sort(arr);
        int min = -1;
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i] - arr[i - 1] || min == -1) {
                min = arr[i] - arr[i - 1];
                ans.clear();
            }
            if (min == arr[i] - arr[i - 1]) {
                List<Integer> tmp = new LinkedList<>();
                tmp.add(arr[i - 1]);
                tmp.add(arr[i]);
                ans.add(tmp);
            }
        }
        return ans;
    }
}
