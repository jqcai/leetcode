import javafx.util.Pair;
import java.util.*;
/*
 * @lc app=leetcode id=362 lang=java
 *
 * [362] Design Hit Counter
 */
class HitCounter {
    LinkedList<Pair<Integer, Integer>> hits;
    int count;
    int current;
    int total;
    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new LinkedList<>();
        count = 0;
        current = 0;
        total = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(count == 0 || current == timestamp){
            current = timestamp;
            count++;
        }else{
            hits.addLast(new Pair<Integer,Integer>(current, count));
            total += count;
            count = 1;
            current = timestamp;
                
            while(hits.size() > 0 && hits.peekFirst().getKey()<=(timestamp-300)){
                total -= hits.pollFirst().getValue();
            }
        }
        return;
        
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        // System.out.println(hits.peekFirst().getKey());
        // System.out.println(timestamp);
        // System.out.println(hits.peekFirst().getValue());
        while(hits.size() > 0 && hits.peekFirst().getKey()<=(timestamp-300)){
            // System.out.println(1);
            // System.out.println(hits.peekFirst().getKey());
            // System.out.println(hits.peekFirst().getValue());
            total -= hits.pollFirst().getValue();
        }
        if(current <= timestamp - 300){
            current = timestamp;
            count = 0;
        }
        // System.out.println(hits.size());
        return total + count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

