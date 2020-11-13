/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null||head.next == null){
            return null;
        }
        ListNode fast = head.next.next, slow = head.next;
        while(fast!=slow && fast!=null &&fast.next!=null && slow!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null || fast.next == null || slow == null){
            return null;
        }
        ListNode slower = head;
        while(slower!=slow){
            slower = slower.next;
            slow = slow.next;
        }
        return slow;
    }
}