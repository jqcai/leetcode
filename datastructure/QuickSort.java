package datastructure;

import java.util.*;
public class QuickSort {
    public static int[] quicksort(int[] ls) {
        helper(ls, 0, ls.length - 1);
        return ls;
    }

    public static void helper(int[] ls, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = ls[start];
        int p1 = start + 1, p2 = end;
        while (p1 <= p2) {
            while (p1 <= p2 && ls[p1] <= pivot) {
                p1++;
            }
            while (p1 <= p2 && ls[p2] >= pivot) {
                p2--;
            }
            if (p1 < p2) {
                int tmp = ls[p1];
                ls[p1] = ls[p2];
                ls[p2] = tmp;
                p1++;
                p2--;
            }
        }
        ls[start] = ls[p1 - 1];
        ls[p1 - 1] = pivot;
        p1--;
        helper(ls, start, p1 - 1);
        helper(ls, p1 + 1, end);
        return;
    }
    public static void main(String args[]) {
        // System.out.println("hello world");
        int[] ans = QuickSort.quicksort(
                new int[] { 15, 4, 6, 3, 2, 6, 2, 23, 6, 12, 3, 612, 3, 46, 213, 32, 1, 234, 6, 12, 3, 6, 12, 3, 6 });
        System.out.println(Arrays.toString(ans));
    }
}