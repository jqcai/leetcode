/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m >= n){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for(int i = 0; i < m - 1; i++){
            head = head.next;
        }
        ListNode fin = null, fin_tail = head.next;
        ListNode ln = head.next;
        for(int i = 0; i < n - m + 1; i++){
            ListNode tmp = ln.next;
            ln.next = fin;
            fin = ln;
            ln = tmp;
        }
        fin_tail.next = ln;
        head.next = fin;
        return dummy.next;
    }
}

