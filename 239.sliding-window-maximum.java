/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k > nums.length || nums.length ==0){
            return new int[]{};
        }
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 0; i < k - 1; i++){
            while(deque.size() > 0 && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        int p1 = 0, p2 = k - 1;
        while(p2 < nums.length){
            while(deque.size() > 0 && deque.peekLast() < nums[p2]){
                deque.pollLast();
            }
            deque.addLast(nums[p2]);
            ans[p1] = deque.peekFirst();
            if(nums[p1] == ans[p1]){
                deque.pollFirst();
            }
            p1++;
            p2++;
        }
        return ans;
    }
}

