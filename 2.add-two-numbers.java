/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addOne = 0;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode ans = l1;
        ListNode pre = l1;
        while(l1 != null && l2 != null){
            int val = addOne + l1.val + l2.val;
            addOne = val/10;
            l1.val = val % 10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null){
            l1 = l2;
            pre.next = l2;
        }
        while(l1 != null){
            int val = addOne + l1.val;
            l1.val = val % 10;
            addOne = val / 10;
            pre = l1;
            l1 = l1.next;
        }
        if(addOne == 1){
            pre.next = new ListNode(1);
        }
        return ans;
    }
}

