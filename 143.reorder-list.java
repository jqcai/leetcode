/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        while(head!=null){
            queue.addLast(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while(queue.size()>0){
            ListNode q = queue.pollFirst();
            tmp.next = q;
            tmp = tmp.next;
            if(queue.size()>0){
                q = queue.pollLast();
                tmp.next = q;
                tmp = tmp.next;
            }
            tmp.next = null;
        }
        return;
    }
}

