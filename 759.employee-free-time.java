import java.util.*;
/*
 * @lc app=leetcode id=759 lang=java
 *
 * [759] Employee Free Time
 */
/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start,int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start,int _end) {
        start = _start;
        end = _end;
    }
};
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Queue<Integer> heap = new PriorityQueue<>(schedule.size(), new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int posAI = a / 100, posAJ = a % 100;
                int posBI = b / 100, posBJ = b % 100;
                if (schedule.get(posAI).size() <= posAJ) {
                    return -1;
                }
                if (schedule.get(posBI).size() <= posBJ) {
                    // System.out.println(posBI + " " + posBJ);
                    return 1;
                }
                Interval ia = schedule.get(posAI).get(posAJ);
                Interval ib = schedule.get(posBI).get(posBJ);
                return ia.start - ib.start;
            }
        });
        for (int i = 0; i < schedule.size(); i++) {
            heap.offer(i * 100);
        }
        // System.out.println(heap.toString()); 
        List<Interval> ans = new LinkedList<>();
        int pre_end = Integer.MIN_VALUE;
        while (heap.size() > 0) {
            int posI = heap.peek() / 100;
            int posJ = heap.poll() % 100;
            if (schedule.get(posI).size() <= posJ) {
                continue;
            }
            Interval tmp = schedule.get(posI).get(posJ);
            // System.out.println(tmp.start + " " + tmp.end);
            if (tmp.start <= pre_end) {
                pre_end = Math.max(pre_end, tmp.end);
            } else {
                if (pre_end != Integer.MIN_VALUE) {
                    ans.add(new Interval(pre_end, tmp.start));
                }
                pre_end = tmp.end;
                // System.out.println(pre_end);
            }
            heap.offer(posI * 100 + posJ + 1);
        }
        return ans;
    }
}
