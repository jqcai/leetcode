/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = head.next;
        dummy.next.next = null;
        while(head!=null){
            ListNode tmp = dummy;
            while(tmp.next!=null){
                if(head.val < tmp.next.val){
                    break;
                }else{
                    tmp = tmp.next;
                }
            }
            ListNode t = tmp.next;
            tmp.next = head;
            head = head.next;
            tmp.next.next = t;
            // head = head.next;
        }
        return dummy.next;
    }
}

