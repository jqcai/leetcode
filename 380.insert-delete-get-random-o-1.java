import java.util.*;

/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */
class RandomizedSet {
    ArrayList<Integer> list;
    Map<Integer, Integer> map;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            // System.out.println(list.toString());
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        // System.out.println(list.toString());
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            // System.out.println(list.toString());
            return false;
        }
        int pos = map.get(val);
        int new_val = list.get(list.size() - 1);
        list.set(pos, new_val);
        list.remove(list.size() - 1);
        map.put(new_val, pos);
        map.remove(val);
        // System.out.println(list.toString());
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(list.size() == 0) {
            return 0;
        }
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
