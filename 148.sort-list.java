/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode a = sortList(slow.next);
        slow.next = null;
        ListNode b = sortList(head);
        ListNode dummy = new ListNode(0);
        ListNode co = dummy;
        while(a!=null && b!=null){
            if(a.val <= b.val){
                co.next = a;
                a = a.next;
                co = co.next;
            }else{
                co.next = b;
                b = b.next;
                co = co.next;
            }
        }
        if(a == null){
            co.next = b;
        }else{
            co.next = a;
        }
        return dummy.next;
    }
}

