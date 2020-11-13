import java.util.*;

/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */
class LFUCache {
    int capacity;
    int size;
    DequeNode first;
    DequeNode last;
    Map<Integer, Integer> valueMap;
    Map<Integer, DequeNode> nodeMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        first = new DequeNode(0);
        last = new DequeNode(0);
        first.next = last;
        last.pre = first;
        valueMap = new HashMap<>();
        nodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        // System.out.println(1);
        if(!valueMap.containsKey(key)){
            return -1;
        }else{
            DequeNode n = nodeMap.get(key);
            if(n.values.size() == 1 && n.next.freq != n.freq + 1){
                n.freq ++;
            }else{
                int freq = n.freq;
                if(n.values.size() == 1){
                    n = n.pre;
                    n.next = n.next.next;
                    n.next.pre = n;
                }
                else{
                    n.values.remove(key);
                }
                if(n.next == last || n.next.freq > freq + 1){
                    DequeNode tmp = n.next;
                    n.next = new DequeNode(freq + 1);
                    n.next.pre = n;
                    n.next.next = tmp;
                    tmp.pre = n.next;
                }
                n.next.values.put(key, key);
                nodeMap.put(key, n.next);
            }
            return valueMap.get(key);
        }
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        // System.out.println(2);
        if(valueMap.containsKey(key)){
            this.get(key);
            valueMap.replace(key, value);
        }else{
            // System.out.println(2.5);
            if(size == capacity){
                // int tmp = first.next.values.entrySet().iterator().next().getValue();
                int tmp = first.next.values.keySet().iterator().next();
                // System.out.println(first.next.values.toString());
                // System.out.println(first.next.freq);
                // System.out.println(first.next.next.values.toString());
                // System.out.println(first.next.next.freq);
                // System.out.println(tmp);
                if(first.next.values.size() == 1){
                    first.next = first.next.next;
                    first.next.pre = first;
                }else{
                    first.next.values.remove(tmp);
                }
                nodeMap.remove(tmp);
                valueMap.remove(tmp);
                size--;
            }
            // System.out.println(3);
            if(first.next == last || first.next.freq > 1){
                DequeNode tmp = first.next;
                first.next = new DequeNode(1);
                first.next.next = tmp;
                first.next.pre = first;
                tmp.pre = first.next;
            }
            first.next.values.put(key,key);
            nodeMap.put(key, first.next);
            valueMap.put(key, value);
            size++;
        }
        // System.out.println(3);
    }

    private class DequeNode{
        LinkedHashMap<Integer,Integer> values;
        DequeNode pre;
        DequeNode next;
        int freq;
        public DequeNode(int _freq){
            values = new LinkedHashMap<Integer, Integer>();
            pre = null;
            next = null;
            freq = _freq;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

