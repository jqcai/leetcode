import java.util.*;

/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int num = 0;
        int max = 0;
        Queue<Meeting> heap = new PriorityQueue<>();
        for (int[] interval : intervals) {
            heap.offer(new Meeting(interval[0], 1));
            heap.offer(new Meeting(interval[1], 0));
        }
        while(heap.size() > 0) {
            if(heap.poll().type == 1) {
                num ++;
                max = Math.max(num, max);
            }else{
                num --;
            }
        }
        return max;
    }

    public class Meeting implements Comparable<Meeting> {
        int type; // end: 0, start: 1
        int time;

        public Meeting(int time, int type) {
            this.type = type;
            this.time = time;
        }

        @Override
        public int compareTo(Meeting o) {
            // TODO Auto-generated method stub
            if (this.time != o.time) {
                return this.time - o.time;
            }
            return this.type - o.type;
        }
    }
}
