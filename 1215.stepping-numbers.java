import java.util.*;

/*
 * @lc app=leetcode id=1215 lang=java
 *
 * [1215] Stepping Numbers
 */

// @lc code=start
class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> ans = new LinkedList<>();
        // Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            bfs(low, high, i, ans);
        }
        Collections.sort(ans);
        return ans;
    }

    public void bfs(int low, int high, long num, List<Integer> ans) {
        if (num >= low && num <= high) {
            ans.add((int) num);
        }
        if (num > high || num == 0) {
            return;
        }
        int last = (int) (num % 10);
        int pre = last - 1;
        int nxt = last + 1;
        if(nxt < 10){
            bfs(low, high, num * 10 + nxt, ans);
        }
        if(pre > -1){
            bfs(low, high, num * 10 + pre, ans);
        }
    }
}
// @lc code=end
