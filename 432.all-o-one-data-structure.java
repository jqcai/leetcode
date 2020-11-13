import java.util.*;
/*
 * @lc app=leetcode id=432 lang=java
 *
 * [432] All O`one Data Structure
 */
class AllOne {
    ListNodeClass first;
    ListNodeClass last;
    Map<String, ListNodeClass> map;
    /** Initialize your data structure here. */
    public AllOne() {
        first = new ListNodeClass();
        last = new ListNodeClass();
        first.next = last;
        last.pre = first;  
        map = new HashMap<>(); 
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        boolean newNode = false;
        ListNodeClass ln = null;
        // ListNodeClass t = first;
        // while(t != null){
        //     System.out.print(t.val + " ");
        //     t = t.next;
        // }

        if(map.containsKey(key)){
            ln = map.get(key);
            ln.keys.remove(key);
            if(ln.next.val != ln.val + 1) {
                newNode = true;
            }
        }else{
            ln = first;
            if(ln.next.val != 1){
                newNode = true;
            }
        }
        if(newNode){
            // System.out.println(2);
            ListNodeClass nn = new ListNodeClass();
            nn.val = ln.val + 1;
            nn.keys.add(key);
            map.put(key, nn);
            nn.next = ln.next;
            nn.pre = ln;
            ln.next = nn;
            nn.next.pre = nn;
        }else{
            ln.next.keys.add(key);
            map.put(key, ln.next);
        }
        if(ln.keys.size() == 0 && ln.val != 0){
            ln.pre.next = ln.next;
            ln.next.pre = ln.pre;
        }
        return;

    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!map.containsKey(key)){
            return;
        }
        ListNodeClass ln = map.get(key);
        ln.keys.remove(key);
        if(ln.val == 1) {
            map.remove(key);
        }else if(ln.pre.val == ln.val - 1) {
            map.put(key, ln.pre);
            ln.pre.keys.add(key);
        }else{
            ListNodeClass pre = new ListNodeClass();
            pre.val = ln.val - 1;
            pre.keys.add(key);
            map.put(key, pre);
            pre.pre = ln.pre;
            pre.pre.next = pre;
            ln.pre = pre;
            pre.next = ln;
        }
        if(ln.keys.size() == 0 && ln.val != 0) {
            ln.pre.next = ln.next;
            ln.next.pre = ln.pre;
        }
        return;
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMinKey() {
        if(first.next == last) {
            return "";
        }
        return first.next.keys.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMaxKey() {
        if(last.pre == first) {
            return "";
        }
        return last.pre.keys.iterator().next();
    }

    private class ListNodeClass{
        ListNodeClass pre;
        ListNodeClass next;
        int val;
        Set<String> keys;
        public ListNodeClass(){
            pre = null;
            next = null;
            keys = new HashSet<>();
            val = 0;
        }
        // public String add(String n){
        //     keys.add(n);
        //     return n;
        // }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

