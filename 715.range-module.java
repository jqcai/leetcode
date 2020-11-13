import java.util.*;

/*
 * @lc app=leetcode id=715 lang=java
 *
 * [715] Range Module
 */

// @lc code=start
class RangeModule {
    Set<Interval> bst;
    public RangeModule() {
        bst = new TreeSet<>();
    }
    
    public void addRange(int left, int right) {
        if(right <= left){
            return;
        }
        int start = left;
        int end = right;
        Iterator<Interval> itr = bst.iterator();
        while(itr.hasNext()){
            Interval tmp = itr.next();
            if(tmp.end < start){
                continue;
            }else if(tmp.start > end){
                break;
            }else{
                start = Math.min(start, tmp.start);
                end = Math.max(end, tmp.end);
                itr.remove();
            }
        }
        bst.add(new Interval(start, end));
    }
    
    public boolean queryRange(int left, int right) {
        Iterator<Interval> itr = bst.iterator();
        while(itr.hasNext()){
            Interval tmp = itr.next();
            if(tmp.end < left){
                continue;
            }else if(tmp.start <= left && tmp.end >= right){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    
    public void removeRange(int left, int right) {
        Iterator<Interval> itr = bst.iterator();
        Set<Interval> set = new HashSet<>();
        while(itr.hasNext()){
            Interval tmp = itr.next();
            if(tmp.end < left){
                continue;
            }else if(tmp.start > right){
                break;
            }else{
                if (tmp.start < left) set.add(new Interval(tmp.start, left));
                if (right < tmp.end) set.add(new Interval(right, tmp.end));
                itr.remove();
            }
        }
        for(Interval in:set){
            bst.add(in);
        }
    }
    public class Interval implements Comparable<Interval>{
        public int start;
        public int end;
        public Interval(int s, int e){
            start = s;
            end = e;
        }
		@Override
		public int compareTo(Interval o) {
			return this.start - o.start;
		}
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
// @lc code=end

