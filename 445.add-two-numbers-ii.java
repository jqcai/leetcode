/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
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
        if(l1 == null){
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while(l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        if(s1.size() < s2.size()) {
            Stack<ListNode> tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        int pos = 0;
        int add = 0;
        ListNode ln1 = null;
        while(s2.size() > 0){
            ln1 = s1.pop();
            ListNode ln2 = s2.pop();
            ln1.val = add + ln1.val + ln2.val;
            add = 0;
            if(ln1.val > 9) {
                add = 1;
                ln1.val -= 10;
            }

        }
        
        while(s1.size() > 0) {
            ln1 = s1.pop();
            ln1.val = add + ln1.val;
            add = 0;
            if(ln1.val > 9) {
                add = 1;
                ln1.val -= 10;
            }
        }
        if(add == 1){
            ListNode t = new ListNode(1);
            t.next = ln1;
            ln1 = t;
        }
        return ln1;

    }
}

