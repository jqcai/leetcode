import java.util.*;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return o1.val - o2.val;
            }
        });
        for (ListNode ln : lists) {
            if (ln != null)
                queue.offer(ln);
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (!queue.isEmpty()) {
            pre.next = queue.poll();
            pre = pre.next;
            if (pre.next != null) {
                queue.offer(pre.next);
                pre.next = null;
            }
        }
        return dummy.next;
    }
}
